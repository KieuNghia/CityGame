package ParseFactory.Parsers;


import ParseFactory.AbstractFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBParser extends AbstractFactory{
    public static final String SQL_SELECT_ALL_CITIES = "SELECT `city_name_en` FROM `cities`";


    @Override
    public ArrayList cityParse() {
        Connection cn = null;
        Statement st = null;
        try {
            cn = DBconnection.getConnection();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_CITIES);
            while (rs.next()) {

                String town = rs.getString(1);
                cities.add(town);
            }

        } catch (SQLException e) {
            System.err.println("SQL Exeption (request or table failed):" + e);
        }
        return cities;    }
}
