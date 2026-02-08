package org.example.SQL;
import java.sql.Connection;
import java.sql.SQLException;

import org.example.SQL.Interface.ConnectionProvider;
import org.example.SQL.Interface.DatabaseConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class DatabaseConnectionTest {
    @Test
    void  getConnection_shouldReturnConnection() throws SQLException {
        Connection fakeConnection = mock(Connection.class);
        ConnectionProvider provider = mock(ConnectionProvider.class);
        when(provider.getConnection()).thenReturn(fakeConnection);

        DatabaseConnection db = new SqlServerConnection(provider);
        Connection connection =db.getConnection();
        assertNotNull(connection);

    }
    @Test
    void getConnection_shouldThrowException_whenProviderFails()throws SQLException{
        ConnectionProvider provider = mock(ConnectionProvider.class);
        when(provider.getConnection()).thenThrow(new SQLException("Connection to the database failed"));
        DatabaseConnection db = new SqlServerConnection(provider);
        RuntimeException exception = assertThrows(RuntimeException.class,db::getConnection);
        assertTrue(exception.getMessage().contains("Connection"));
    }

}
