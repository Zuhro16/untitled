package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "topics")
public class TopicEntity {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private int order;

    public TopicEntity() {}

    public TopicEntity(String name, int order) {
        this.name = name;
        this.order = order;
    }

    // Геттеры и сеттеры
}