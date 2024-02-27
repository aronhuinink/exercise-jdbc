import nl.han.aim.oose.dea.datasource.ItemDao;
import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.datasource.util.MySqlDatabaseProperties;
import nl.han.aim.oose.dea.datasource.util.SqlServerDatabaseProperties;

import java.util.logging.Level;
import java.util.logging.Logger;

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

        var itemDao = new ItemDao(dbProperties, app.logger);
        var items = itemDao.findAll();

        items.forEach(i -> app.log(i));
    }

    private Logger logger;

    public JdbcApp() {
        logger = Logger.getLogger(getClass().getName());
    }
    private void log(String s) {
        logger.log(Level.INFO, s);
    }

    private void log(Object o) {
        logger.log(Level.INFO, o.toString());
    }
}
