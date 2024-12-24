package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "students")
public class StudentEntity {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private GroupEntity group;

    public StudentEntity() {
        // ORMLite requires a no-argument constructor
    }

    public StudentEntity(String name, GroupEntity group) {
        this.name = name;
        this.group = group;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }
}

