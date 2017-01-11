package ru.aakifiev.servicesDao;

import ru.aakifiev.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakifiev on 28.12.2016.
 */
public class PlainContactDao implements ContactDao {

    static {
        try {
            Class.forName("com.postgresql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ChIp16OK88");
    }

    private void closeConnection(Connection connection){
        if (connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<Contact>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from contact");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setBirthDate(resultSet.getDate("Ьirth_date"));
                result.add(contact);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return null;
    }

    public List<Contact> findByFirstName() {
        return null;
    }

    public String findLastNameById(Long id) {
        return null;
    }

    public String findFirstNameById(Long id) {
        return null;
    }

    public void insert(Contact contact) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Contact (first_name, last_name, birth_date) values (?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setDate(3, contact.getBirthDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contact.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            closeConnection(connection);
        }
    }

    public void update(Contact contact) {

    }

    public void delete(Long contactId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                connection.prepareStatement("delete from contact where id=?");
            statement.setLong(1, contactId);
            statement.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }
}
