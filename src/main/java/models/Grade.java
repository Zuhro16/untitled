package models;

public class Grade {
    private StudentEntity student; // Updated to use StudentEntity// Added GroupEntity for better structure
    private int dzGrade;           // Homework grade
    private int exerciseGrade;     // Exercise grade

    // Constructor
    public Grade(StudentEntity student, GroupEntity group, int dzGrade, int exerciseGrade) {
        this.student = student;
        this.dzGrade = dzGrade;
        this.exerciseGrade = exerciseGrade;
    }

    // Getters
    public StudentEntity getStudent() {
        return student;
    }

    public int getDzGrade() {
        return dzGrade;
    }

    public int getExerciseGrade() {
        return exerciseGrade;
    }

    // Setters (if needed)
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
