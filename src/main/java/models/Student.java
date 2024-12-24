package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int totalGradeDz;
    private int totalGradeUp;

    public Student(String name, String group, int totalGradeDz, int totalGradeUp) {
        this.name = name;
        this.group = group;
        this.totalGradeDz = totalGradeDz;
        this.totalGradeUp = totalGradeUp;
    }

    public Student(String name, GroupEntity group, int gradeDz, int gradeUp) {
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getTotalGradeDz() {
        return totalGradeDz;
    }

    public int getTotalGradeUp() {
        return totalGradeUp;
    }

    public String getPerformance() {
        // Проверяем, если студент имеет более 20% в обоих разделах
        double dzPercentage = (double) totalGradeDz / 2800 * 100;
        double upPercentage = (double) totalGradeUp / 411 * 100;

        if (dzPercentage > 20 && upPercentage > 20) {
            return "Хорошая успеваемость";
        } else {
            return "Плохая успеваемость";
        }
    }
}
