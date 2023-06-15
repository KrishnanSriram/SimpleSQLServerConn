public class Main {
    public static void main(String[] args) {
        System.out.println("Try connect to SQL Server .....");
        if (args.length < 4) {
            System.out.println("Usage: java SQLServerExample <serverName> <databaseName> <username> <password>");
            return;
        }

        String serverName = args[0];
        String databaseName = args[1];
        String username = args[2];
        String password = args[3];

        String dburl = SQLServerDBUrlBuilder.GetDBURLFor(serverName, databaseName);
    }
}