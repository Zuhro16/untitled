package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "grades")
public class GradeEntity {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private StudentEntity student;

    @DatabaseField
    private int dzGrade; // Grade for homework

    @DatabaseField
    private int exerciseGrade; // Grade for exercises

    public GradeEntity() {}

    public GradeEntity(StudentEntity student, int dzGrade, int exerciseGrade) {
        this.student = student;
        this.dzGrade = dzGrade;
        this.exerciseGrade = exerciseGrade;
    }

    // Getters and setters
    public StudentEntity getStudent() {
        return student;
    }

    public int getDzGrade() {
        return dzGrade;
    }

    public int getExerciseGrade() {
        return exerciseGrade;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public void setDzGrade(int dzGrade) {
        this.dzGrade = dzGrade;
    }

    public void setExerciseGrade(int exerciseGrade) {
        this.exerciseGrade = exerciseGrade;
    }
}
