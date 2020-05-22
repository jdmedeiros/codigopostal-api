/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public OpenDB() {
        try {
            String databaseUrl = "jdbc:mysql://ctt.cmwy6qjl36fn.us-east-1.rds.amazonaws.com/ctt";
            connectionSource = new JdbcConnectionSource(databaseUrl, OpenDBCredentials.userid, OpenDBCredentials.password);

            userDistritos = DaoManager.createDao(connectionSource, Distritos.class);
            userConcelhos = DaoManager.createDao(connectionSource, Concelhos.class);
            daoVConcelhos = DaoManager.createDao(connectionSource, VConcelhos.class);
            userCodigosPostais = DaoManager.createDao(connectionSource, CodigosPostais.class);

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
