package models;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public List<StudentEntity> parseCsv(String filePath, DatabaseHelper dbHelper) {
        List<StudentEntity> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header lines
            br.readLine(); // Skip the first line (subject names)
            br.readLine(); // Skip the second line (column names)
            br.readLine(); // Skip the third line (maximum scores)

            // DAOs for database operations
            Dao<GroupEntity, Integer> groupDao = DaoManager.createDao(dbHelper.getConnectionSource(), GroupEntity.class);
            Dao<StudentEntity, Integer> studentDao = DaoManager.createDao(dbHelper.getConnectionSource(), StudentEntity.class);
            Dao<GradeEntity, Integer> gradeDao = DaoManager.createDao(dbHelper.getConnectionSource(), GradeEntity.class);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(";"); // Split the line by semicolon

                if (columns.length < 4) { // Ensure all required columns are present
                    continue; // Skip incomplete lines
                }

                // Parse student data
                String name = columns[0]; // Student Name (e.g., "LastName FirstName")
                String groupName = columns[1]; // Group name (e.g., "RTF.2021 Part 1")

                // Search for or create the group
                GroupEntity group = groupDao.queryForEq("name", groupName).stream().findFirst().orElseGet(() -> {
                    GroupEntity newGroup = new GroupEntity(groupName);
                    try {
                        groupDao.create(newGroup);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return newGroup;
                });

                // Parse the grades
                int dzGrade = 0;
                int exerciseGrade = 0;
                try {
                    dzGrade = Integer.parseInt(columns[4]); // Homework grade
                    exerciseGrade = Integer.parseInt(columns[3]); // Exercise grade
                } catch (NumberFormatException e) {
                    // Handle invalid numeric data by assigning 0
                }

                // Create and save the student
                StudentEntity student = new StudentEntity(name, group);
                studentDao.create(student); // Save the student to the database
                students.add(student); // Add the student to the list

                // Create and save the grades linked to the student
                GradeEntity grade = new GradeEntity(student, dzGrade, exerciseGrade);
                gradeDao.create(grade); // Save the grades to the database
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

