package models;

public class Topic {
    private String name;
    private int order; // Порядковый номер темы

    // Конструктор
    public Topic(String name, int order) {
        this.name = name;
        this.order = order;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
}

