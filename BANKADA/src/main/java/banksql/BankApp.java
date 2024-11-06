package banksql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BankApp {
    public static void main(String[] args) {
        try (Connection connection = Connections.getConnection()) {
            System.out.println("Połączenie z bazą danych zostało nawiązane!");

            List<Client> clients = fetchClients(connection);
            clients.forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println("Błąd przy połączeniu z bazą danych: " + e.getMessage());
        }
    }

    private static List<Client> fetchClients(Connection connection) throws SQLException {
        String query = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                clients.add(new Client(id, firstName, lastName));

            }
        }
        return clients;
    }
}