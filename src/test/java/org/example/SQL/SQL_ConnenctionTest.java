package org.example.SQL;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SQL_ConnenctionTest {
    @Test
    void  getConnection_shouldReturnConnection(){
        DatabaseConnection db = new SqlServerConnection();
        Connection connection = db.getConnection();
        assertNotNull(connection);
    }
}
