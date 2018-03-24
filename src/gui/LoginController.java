package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXTextField;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import entites.BCrypt;

import entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.Serviceuser;
import utils.Authentification;
import utils.ConnextionSingleton;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView imageview;

    @FXML
    private TextField username;
    @FXML
    private PasswordField pwd;
    @FXML
    private Label lbl;

    private Connection c;

    private User fos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        c = ConnextionSingleton.getInstance()
                .getConnection();
        Authentification.getSession().getUser();
    }

    public void loginaction(ActionEvent event) throws IOException {
        System.out.println(" login button");
        Serviceuser userser = new Serviceuser();
        String use = username.getText();

        String pass = pwd.getText();

        User user = userser.login(use);

        if (user.getId() == 0) {
            System.out.println("invalide");
        } else {
        if (BCrypt.checkpw(pass, user.getPassword())){

        System.out.println(username.getText() + "     /// " + pwd.getText());
        Voice voice = null;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak("Welcome " + username.getText()
                + " to our desktop application");
   
        Stage stage = new Stage();
        Parent home = FXMLLoader.load(getClass().getResource("/gui/homepage.fxml"));

        Scene hoomescene = new Scene(home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hoomescene);
        app_stage.show();}
        else{
            System.out.println("mdp invalide");}
        }
    }

}
