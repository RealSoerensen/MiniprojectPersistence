package tests;

import org.junit.jupiter.api.Test;
import dal.DBConnection;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDB {

    @Test
    public void testDBConnection() throws SQLException {
        DBConnection.getInstance();
        assertTrue(DBConnection.getOpenStatus());
        DBConnection.closeConnection();
        assertFalse(DBConnection.getOpenStatus());
    }
}
