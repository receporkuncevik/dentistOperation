/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RecepOrkun
 */
public abstract class DBConnection {
    private Connection connection;
    
    public Connection connect() {
        String driver = "org.mariadb.jdbc.Driver";
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:8000/dentist_data", "root", "12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.connection;
    }
}
