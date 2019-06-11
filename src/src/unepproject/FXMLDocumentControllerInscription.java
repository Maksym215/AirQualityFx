package src.unepproject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
/*
 * inscription controlleur 
 * ZOUARI EYA
 * ©eya.zouari@esprit.tn©
 */
public class FXMLDocumentControllerInscription implements Initializable {

	@FXML
	private JFXTextField emailTF;

	@FXML
	private JFXTextField fristnameTF;

	@FXML
	private JFXTextField lastnameTF1;

	@FXML
	private JFXPasswordField passwordTF;

	@FXML
	private AnchorPane authenificationpane;

	@FXML
	private MediaView mediaView;

	@FXML
	private JFXButton submitbtn;
	

	Media media = new Media(new File("src/src/asset/unep_video_inscription.mp4").toURI().toString());
	MediaPlayer player = new MediaPlayer(media);
    UserService us = new UserService();
    public boolean test()
    {
        if ((!emailTF.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" ))||(emailTF.getText().equals(""))) {
            us.notf_false("PROBLEM","INVALID EMAIL");
            return false;
        }
        return true;
    }
    
	@FXML
	void submitbtn(ActionEvent event) throws IOException, JSONException {
		
		boolean test = test();
		if(test==true)
		{
 us.Inscription(fristnameTF.getText(), lastnameTF1.getText(), emailTF.getText(), passwordTF.getText());   
 Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentLogin.fxml"));
 Scene scene = new Scene(root);
 Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
 app_stage.setScene(scene);	        app_stage.setMaximized(true);

 app_stage.show();
		
		}
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		mediaView.setMediaPlayer(player);
		player.play();
		player.setCycleCount(MediaPlayer.INDEFINITE);
	}

}
