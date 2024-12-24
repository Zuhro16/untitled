package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "groups")
public class GroupEntity {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    // Constructor, getters, and setters
    public GroupEntity() {}

    public GroupEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
