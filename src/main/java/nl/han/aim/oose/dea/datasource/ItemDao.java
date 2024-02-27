package nl.han.aim.oose.dea.datasource;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.domain.Item;

public class ItemDao {

    private DatabaseProperties dbProperties;

    private Logger logger;

    public ItemDao(DatabaseProperties dbProperties, Logger logger) {
        this.dbProperties = dbProperties;
        this.logger = logger;
    }

    public List<Item> findAll() {
        var resultItems = new ArrayList<Item>();
        Connection cnItems = null;
        try {
            cnItems = DriverManager.getConnection(dbProperties.getConnectionString());
            ResultSet rsItems = null;
            var st = cnItems.prepareStatement("SELECT * FROM Items;");
            rsItems = st.executeQuery();
            while (rsItems.next() != false) {
                String sku = rsItems.getString("sku");
                String category = rsItems.getString("category");
                String title = rsItems.getString("title");
                resultItems.add(new Item(sku, category, title));
            }
        } catch (SQLException e) {
            logger.log(Level.INFO, "Database error: " + e);
            throw new RuntimeException(e);
        }
        return resultItems;
    }
}
