/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

/**
 *
 * @author enta
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.servlet.SparkApplication;
import static com.serpamedeiros.postal.OpenDB.connectionSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main implements SparkApplication {

    @Override
    public void init() {
        try {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        connectionSource.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            Context env = (Context) new InitialContext().lookup("java:comp/env");
            String userid = (String) env.lookup("userid");
            String password = (String) env.lookup("password");
            String databaseUrl = (String) env.lookup("databaseUrl");
            OpenDB openDB = new OpenDB(userid, password, databaseUrl);
            UserController userController = new UserController(new UserService());
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
