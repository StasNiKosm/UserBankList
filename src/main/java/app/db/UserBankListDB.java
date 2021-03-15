package app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserBankListDB {

    //statements
    private static final String USER_BY_ID = "SELECT name, surname FROM user WHERE userid = ?";
    private static final String ALL_ACCOUNTS = "SELECT accountid, account, name, surname FROM account JOIN user ON (account.userid = user.userid)";
    private static final String THE_RICHEST = "SELECT name, surname, sum(account) as 'sum' FROM account JOIN user ON (account.userid = user.userid) GROUP BY name, surname ORDER BY sum(account) DESC LIMIT 1";
    private static final String WHOLE_SUM = "SELECT sum(account) as 'whole_sum' FROM account";


    public static List<String> getAllAccount() throws SQLException {
        List<String> result;
        Properties properties = new Properties();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try(FileInputStream propertyFileStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\userBankList\\src\\main\\resources\\config.properties")) {
            properties.load(propertyFileStream);
            Class.forName(properties.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USER"), properties.getProperty("DB_PASSWORD"));
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ALL_ACCOUNTS);
            result = new ArrayList<>();
            while (resultSet.next()){
                String strBuilder = resultSet.getString(1) + ' ' +
                        resultSet.getString(2) + ' ' +
                        resultSet.getString(3) + ' ' +
                        resultSet.getString(4) + ' ';
                result.add(strBuilder);
            }
            return result;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static String getUser(int id) throws SQLException{
        Properties properties = new Properties();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try(FileInputStream propertyFileStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\userBankList\\src\\main\\resources\\config.properties")){
            properties.load(propertyFileStream);
            Class.forName(properties.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USER"), properties.getProperty("DB_PASSWORD"));
            preparedStatement = connection.prepareStatement(USER_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1) + ' ' + resultSet.getString(2);
            }
            if (resultSet.getFetchSize() == 0) return null;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static String getTheRichest()  throws SQLException{
        Properties properties = new Properties();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try(FileInputStream propertyFileStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\userBankList\\src\\main\\resources\\config.properties")){
            properties.load(propertyFileStream);
            Class.forName(properties.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USER"), properties.getProperty("DB_PASSWORD"));
            statement = connection.createStatement();
            resultSet = statement.executeQuery(THE_RICHEST);
            if(resultSet.next()){
                return resultSet.getString(1) + ' ' + resultSet.getString(2) + ' ' + resultSet.getString(3);
            }
            if (resultSet.getFetchSize() == 0) return null;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static String getWholeSum()  throws SQLException{
        Properties properties = new Properties();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try(FileInputStream propertyFileStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\userBankList\\src\\main\\resources\\config.properties")){
            properties.load(propertyFileStream);
            Class.forName(properties.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USER"), properties.getProperty("DB_PASSWORD"));
            statement = connection.createStatement();
            resultSet = statement.executeQuery(WHOLE_SUM);
            if(resultSet.next()){
                return resultSet.getString(1);
            }
            if (resultSet.getFetchSize() == 0) return null;
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
        return null;
    }


    public static void main(String[] args) {
        try {
            System.out.println(getWholeSum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
