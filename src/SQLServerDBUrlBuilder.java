public class SQLServerDBUrlBuilder {
    public static String GetDBURLFor(String serverName, String databaseName) {
        return "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName;
    }

}
