package app.db;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserBankListDBTest {

    @Test
    public void getAllAccount() {
    }

    @Test
    public void getUser() {
        try {
            String actual = UserBankListDB.getUser(78);
            String expected = null;
            assertEquals(expected, actual);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTheRichest() {
        try {
           String actual = UserBankListDB.getTheRichest();
           String expected = "Avon Lon 180";
            assertEquals(expected, actual);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWholeSum() {
        try {
            String actual = UserBankListDB.getWholeSum();
            String expected = "972";
            assertEquals(expected, actual);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}