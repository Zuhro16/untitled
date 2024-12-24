package models;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper dbHelper = new DatabaseHelper();
        try {
            dbHelper.setupDatabase();

            // DAO for working with the student entity
            Dao<StudentEntity, Integer> studentDao = DaoManager.createDao(dbHelper.getConnectionSource(), StudentEntity.class);
            CSVParser parser = new CSVParser();

            // Parse CSV and save to the database
            List<StudentEntity> students = parser.parseCsv("src/main/java/models/basicprogramming_2 (1).csv", dbHelper);
            for (StudentEntity student : students) {
                studentDao.create(student);
            }

            // Check records
            List<StudentEntity> savedStudents = studentDao.queryForAll();
            System.out.println("Saved students:");
            for (StudentEntity student : savedStudents) {
                System.out.println(student.getName() + " - " + student.getGroup().getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.close();
        }
    }
}

//        CSVParser parser = new CSVParser();
//        List<Student> students = parser.parseCsv("src/main/java/models/");
//
//        // Создаем Map для хранения среднего балла по каждому типу задания
//        Map<String, Double> taskTypeAvgGrades = new HashMap<>();
//        taskTypeAvgGrades.put("ДЗ", students.stream()
//                .mapToInt(Student::getTotalGradeDz)
//                .average()
//                .orElse(0));
//        taskTypeAvgGrades.put("Упражнения", students.stream()
//                .mapToInt(Student::getTotalGradeUp)
//                .average()
//                .orElse(0));
//
//        // Находим самый сложный тип задания (с самым низким средним баллом)
//        String hardestTaskType = taskTypeAvgGrades.entrySet()
//                .stream()
//                .min(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse("Нет данных");
//
//        // Вывод информации по каждому студенту
//        System.out.println("Анализ успеваемости студентов:");
//        System.out.println("================================");
//
//        for (Student student : students) {
//            System.out.println("\nСтудент: " + student.getName());
//            System.out.println("Группа: " + student.getGroup());
//            System.out.println("Успеваемость: " + student.getPerformance());
//
//            // Определяем, какие типы заданий решал студент
//            List<String> solvedTaskTypes = new ArrayList<>();
//            if (student.getTotalGradeDz() > 0) {
//                solvedTaskTypes.add("ДЗ (балл: " + student.getTotalGradeDz() + ")");
//            }
//            if (student.getTotalGradeUp() > 0) {
//                solvedTaskTypes.add("Упражнения (балл: " + student.getTotalGradeUp() + ")");
//            }
//
//            System.out.println("Решенные типы заданий: " +
//                    (solvedTaskTypes.isEmpty() ? "Нет решенных заданий" : String.join(", ", solvedTaskTypes)));
//        }
//
//        // Вывод статистики по типам заданий
//        System.out.println("\nСтатистика по типам заданий:");
//        System.out.println("================================");
//        taskTypeAvgGrades.forEach((type, avg) ->
//                System.out.printf("%s - средний балл: %.2f%n", type, avg));

