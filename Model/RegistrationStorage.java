package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RegistrationStorage {
    public static void create(RegistrationModel model) {
        final String query = "INSERT INTO matricula (name, fullAge, email, adress, cep, phone, obs" +
                ", active, user, password, course) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConexao();

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getName());
            statement.setInt(2, model.getFullAge());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getAdress());
            statement.setString(5, model.getCep());
            statement.setString(6, model.getPhone());
            statement.setString(7, model.getObs());
            statement.setBoolean(8, model.isActive());
            statement.setString(9, model.getUser());
            statement.setString(10, model.getPassword());
            statement.setString(11, model.getCourse());
            statement.execute();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                model.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();

                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(RegistrationModel model) {
        final String query = "UPDATE matricula SET name = ?, fullAge = ?, email = ?, adress = ?, cep = ?" +
                ", phone = ?, obs = ?, active = ?, user = ?, password = ?, course = ? WHERE idmatricula = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConexao();

            statement = connection.prepareStatement(query);
            statement.setString(1, model.getName());
            statement.setInt(2, model.getFullAge());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getAdress());
            statement.setString(5, model.getCep());
            statement.setString(6, model.getPhone());
            statement.setString(7, model.getObs());
            statement.setBoolean(8, model.isActive());
            statement.setString(9, model.getUser());
            statement.setString(10, model.getPassword());
            statement.setString(11, model.getCourse());
            statement.setInt(12, model.getId());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(RegistrationModel model) {
        final String query = "DELETE FROM matricula WHERE idmatricula = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConexao();

            statement = connection.prepareStatement(query);
            statement.setInt(1, model.getId());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<RegistrationModel> retrieve() {
        ArrayList<RegistrationModel> models = new ArrayList<RegistrationModel>();

        final String query = "SELECT * FROM matricula";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConexao();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RegistrationModel model = new RegistrationModel();
                model.setId(resultSet.getInt("idmatricula"));
                model.setName(resultSet.getString("name"));
                model.setFullAge(resultSet.getInt("fullAge"));
                model.setEmail(resultSet.getString("email"));
                model.setAdress(resultSet.getString("adress"));
                model.setCep(resultSet.getString("cep"));
                model.setPhone(resultSet.getString("phone"));
                model.setObs(resultSet.getString("obs"));
                model.setActive(resultSet.getBoolean("active"));
                model.setUser(resultSet.getString("user"));
                model.setPassword(resultSet.getString("password"));
                model.setCourse(resultSet.getString("course"));

                models.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();

                if (resultSet != null)
                    resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return models;
    }
}
