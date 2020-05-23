package com.serpamedeiros.postal;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enta
 */
public class OpenDB {

    public static JdbcConnectionSource connectionSource;
    public static Dao<Distritos, String> userDistritos;
    public static Dao<Concelhos, String> userConcelhos;
    public static Dao<VConcelhos, String> daoVConcelhos;
    public static Dao<CodigosPostais, String> userCodigosPostais;

    public OpenDB(String userid, String password, String databaseUrl) {
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl, userid, password);
            userDistritos = DaoManager.createDao(connectionSource, Distritos.class);
            userConcelhos = DaoManager.createDao(connectionSource, Concelhos.class);
            daoVConcelhos = DaoManager.createDao(connectionSource, VConcelhos.class);
            userCodigosPostais = DaoManager.createDao(connectionSource, CodigosPostais.class);

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
