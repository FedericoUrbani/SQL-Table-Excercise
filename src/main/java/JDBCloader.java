import java.sql.*;

public class JDBCloader {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet= null;
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user= "developer";
        String password="developer1";

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS students (student_id int NOT NULL PRIMARY KEY AUTO_INCREMENT, last_name varchar(30) ,firstname varchar(30))");

            System.out.println("query fatta");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.execute("INSERT INTO newdb.students (last_name, firstname) VALUES ('mario', 'rossi')");
            System.out.println("eseguita aggiunta di mario rossi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
