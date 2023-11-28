package MetaData;

import java.sql.*;

import static javax.management.remote.JMXConnectorFactory.connect;

public class metadata {
    public static void displayTableNamesandColumns() throws SQLException {
        Connection connection = connect();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.println(tableName);
            System.out.println();
            displayColumns(tableName);
            System.out.println();
        }
    }

    public static void displayColumns(String tableName) throws SQLException {
        Connection connection = connect();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet columns = metaData.getColumns(null, null, tableName, null);
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            System.out.println(columnName);
        }
    }

    public static void displayColumnDetails() throws SQLException {
        Connection connection = connect();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet columns = metaData.getColumns(null, null, tableName, null);
            System.out.println(tableName);
            System.out.println();
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                System.out.println(columnName + " " + columnType);
            }
            System.out.println();
        }
    }

    public static void displayPrimaryKeys() throws SQLException {
        Connection connection = connect();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
            System.out.println(tableName);
            System.out.println();
            while (primaryKeys.next()) {
                String primaryKeyColumnName = primaryKeys.getString("COLUMN_NAME");
                System.out.println(primaryKeyColumnName);
            }
            System.out.println();
        }
    }

    public static void displayForeignKeys() throws SQLException {
        Connection connection = connect();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            ResultSet foreignKeys = metaData.getImportedKeys(null, null, tableName);
            System.out.println(tableName);
            System.out.println();
            while (foreignKeys.next()) {
                String foreign_key_column = foreignKeys.getString("FKCOLUMN_NAME");
                String referenced_table_name = foreignKeys.getString("PKTABLE_NAME");
                String referenced_column_name = foreignKeys.getString("PKCOLUMN_NAME");
                System.out.print(foreign_key_column + " references " + referenced_table_name + "(" + referenced_column_name + ")");
                System.out.println();
            }
            System.out.println();
        }
    }

    public static Connection connect() {
        String url = "jdbc:postgresql://localhost/Database_Assignment2";
        String user = "postgres";
        String password = "1234";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database successfully.");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return con;
    }

}
