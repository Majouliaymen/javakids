/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Authentification;
import static utils.Authentification.user;
import utils.ConnextionSingleton;

/**
 *
 * @author SBS
 */
public class Serviceuser {

    private Connection cnx;
    public static Authentification instance;
    public static User user;

    public Serviceuser() {
        cnx = ConnextionSingleton.getInstance()
                .getConnection();

    }

    public User login(String name) {
        user = new User();

        System.out.println("hihihihi");
        String req = "SELECT * FROM `fos_user` WHERE username=?";

        try {
            System.out.println("try");

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, name);

            ResultSet r = ps.executeQuery();

            if (r.next()) {
                user = new User(r.getInt("id"), r.getString("username"), r.getString("email"), r.getString("password"), r.getString("nom"), r.getString("prenom"));
            }

        } catch (SQLException ex) {
            System.out.println("catch");

            System.out.println(ex);
            user.setId(0);
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);

        }

        return user;

    }

}
