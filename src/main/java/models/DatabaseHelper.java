package models;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:sqlite:student.db";
    private ConnectionSource connectionSource;

    public DatabaseHelper() {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setupDatabase() throws SQLException {
        // Create tables
        TableUtils.createTableIfNotExists(connectionSource, StudentEntity.class);
        TableUtils.createTableIfNotExists(connectionSource, GroupEntity.class);
        TableUtils.createTableIfNotExists(connectionSource, GradeEntity.class);
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public void close() {
        try {
            if (connectionSource != null) {
                connectionSource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
