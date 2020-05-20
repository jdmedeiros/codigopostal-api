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

public class Main implements SparkApplication {

    @Override
    public void init() {
        
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

        OpenDB openDB = new OpenDB();
        UserController userController = new UserController(new UserService());
    }
}
