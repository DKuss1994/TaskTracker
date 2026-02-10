package org.example.Login;

import org.example.Login.Interface.FakePasswordService;
import org.example.Login.Interface.FakePasswordServiceFalse;
import org.example.Login.Interface.FakeUserMaxRepository;
import org.example.Login.Interface.FakeUserNotFoundRepository;
import org.example.SQL.Interface.DatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTest {
       @Test
    void testLoginTrueIfUserAndPasswordTrue(){
           UserService userService = new UserService(new FakeUserMaxRepository(),new FakePasswordService());

           Assertions.assertNotNull(userService.login("Max","123456"));

    }
    @Test
    void testLoginFalseIfUserNotFound(){
        UserService userService = new UserService(new FakeUserNotFoundRepository(),new FakePasswordService());
        Assertions.assertNull(userService.login("Max","123456"));
    }
    @Test
    void testLoginFalseIfPasswordFalse(){
        UserService userService = new UserService(new FakeUserMaxRepository(),new FakePasswordServiceFalse());
        Assertions.assertNull(userService.login("Max","123456"));
    }
    @Test
    void shouldReturnUserWhenUsernameExists ()throws SQLException{
           ResultSet fakeResultSet = mock(ResultSet.class);
           when(fakeResultSet.next()).thenReturn(true);
           when(fakeResultSet.getInt("userId")).thenReturn(0);
           when(fakeResultSet.getString("userName")).thenReturn("Max");
           when(fakeResultSet.getString("password")).thenReturn("123456");

        PreparedStatement fakeStatement = mock(PreparedStatement.class);
        when(fakeStatement.executeQuery()).thenReturn(fakeResultSet);

        Connection fakeConnection = mock(Connection.class);
        when(fakeConnection.prepareStatement(anyString())).thenReturn(fakeStatement);

        DatabaseConnection fakeDBConnection = mock(DatabaseConnection.class);
        when(fakeDBConnection.getConnection()).thenReturn(fakeConnection);

        SqlUserRepository repo = new SqlUserRepository(fakeDBConnection);

        User user = repo.findePasswordUserIDByUserName("Max");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(0,user.id());
        Assertions.assertEquals("Max",user.user());
        Assertions.assertEquals("123456",user.passwordHash());
       }
}
