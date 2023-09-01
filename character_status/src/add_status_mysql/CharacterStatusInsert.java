package add_status_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharacterStatusInsert {
    public static void main(String[] args) {
        String dbURL = "jdbc:mariadb://damage-cal-web.chkcaa405bkq.ap-northeast-1.rds.amazonaws.com:3306/character_status";
        String username = "damage-cal";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            
            String insertQuery = "INSERT INTO characters (name, hp, ad, ar, mr, tier) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "ヴィジェル");
            preparedStatement.setInt(2, 1122);
            preparedStatement.setInt(3, 287);
            preparedStatement.setInt(4, 91);
            preparedStatement.setInt(5, 0);
            preparedStatement.setInt(6, 6);
            
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows inserted.");

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}