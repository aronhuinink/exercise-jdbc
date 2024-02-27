import nl.han.aim.oose.dea.datasource.ItemDao;
import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.datasource.util.MySqlDatabaseProperties;
import nl.han.aim.oose.dea.datasource.util.SqlServerDatabaseProperties;

import javax.xml.crypto.Data;

public class JdbcApp {
    public static void main(String[] args) {
        System.out.println("Hello JDBC");

        var useSqlServer = true;
        DatabaseProperties dbProperties;
        if (useSqlServer) {
            dbProperties = new SqlServerDatabaseProperties();
        } else {
            dbProperties = new MySqlDatabaseProperties();
        }
        var app = new JdbcApp();
        app.log("Connection string: " + dbProperties.getConnectionString());
        app.log("Driver: " + dbProperties.getConnectionString());

        var itemDao = new ItemDao(dbProperties);
        var items = itemDao.findAll();

        items.forEach(i -> System.out.println(i));
    }

    private void log(String s) {
        // TODO: Use logger.
        System.out.println(s);
    }
}
