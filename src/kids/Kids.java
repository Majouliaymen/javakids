/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids;

import entites.User;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.Serviceuser;
import utils.Authentification;
import utils.ConnextionSingleton;


/**
 *
 * @author SBS
 */
public class Kids extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/login.fxml"));
        System.out.println("bbbbbbbbbbbbbbbb");

        Scene scene = new Scene(root);
      //  scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                System.out.println("qqqqqq");

Serviceuser s = new Serviceuser();

        User aa= s.login("bb");
        System.out.println(aa);
                launch(args);

        
    }
    
}
