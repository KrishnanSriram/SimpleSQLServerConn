import java.sql.*;

public class SimpleSQLServerOps {
    final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DB_URL;
    private String username;
    private String password;

    public SimpleSQLServerOps(String dburl, String username, String password) {
        this.DB_URL = dburl;
        this.username = username;
        this.password = password;
    }

    public void checkBasicOps(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, username, password);
            stmt = conn.createStatement();
            // Create table
            createNewTable(stmt);
            // Insert data
            insertData(stmt);
            // Fetch data
            fetchData(stmt);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close connections and resources...

        }
    }

    private void createNewTable(Statement stmt) throws SQLException {
        String createTableSql = "CREATE TABLE YourTableName (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
        stmt.executeUpdate(createTableSql);
        System.out.println("Table created successfully.");
    }

    private void insertData(Statement stmt) throws SQLException {
        String sql;
        System.out.println("Inserting data into table...");
        sql = "INSERT INTO YourTableName (name, age) VALUES ('John', 25)";
        stmt.executeUpdate(sql);
        System.out.println("Data inserted successfully.");
    }

    private void fetchData(Statement stmt) throws SQLException {
        System.out.println("Fetching data from table...");
        String sql = "SELECT id, name, age FROM YourTableName";
        ResultSet rs = stmt.executeQuery(sql);

        // Process the fetched data
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            // Print or use the retrieved data
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
        rs.close();
    }
}
