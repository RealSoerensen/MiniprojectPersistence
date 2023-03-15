package tests;

import org.junit.jupiter.api.Test;
import dal.DBConnection;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDB {

    @Test
    public void shouldStartConnectionToDB() throws SQLException {
    	//Arrange
    	
    	//Act
        DBConnection.getInstance(); //Creates connection upon instance creation.
        
        //Assert
        assertTrue(DBConnection.getOpenStatus());
    }
    
    @Test
    public void shouldCloseConnectionToDB() throws SQLException {
    	//Arrange
    	
    	//Act
    	DBConnection.closeConnection();
    	
    	//Assert
        assertFalse(DBConnection.getOpenStatus());
    }
}
