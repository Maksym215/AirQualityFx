package src.unepproject;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import src.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
 * login controlleur 
 * ZOUARI EYA
 * ©eya.zouari@esprit.tn©
 */
public class FXMLDocumentControllerLogin implements Initializable {

	@FXML
	private JFXTextField usernameTF;

	@FXML
	private JFXButton loginbtn;

	@FXML
	private JFXButton signbtn;

	@FXML
	private JFXPasswordField passwordTF;

	@FXML
	private AnchorPane authenificationpane;

	@FXML
	private JFXButton fbbtn;

	@FXML
	private MediaView mediaView;
    UserService us = new UserService();
	Media media = new Media(new File("src/src/asset/unep_video.mp4").toURI().toString());
	MediaPlayer player = new MediaPlayer(media);

	@FXML
	void loginbtn(ActionEvent event) throws IOException, JSONException {
		JSONArray obj;
		int exist=0;
		String email;
		String password;
		obj = us.getUsers();
		System.out.print(obj.length());
		for(int i=0;i<obj.length();i++)
		{
			JSONObject row = obj.getJSONObject(i);
			System.out.println(row.getString("email"));
			System.out.println(row.getString("password"));
			email=row.getString("email");
			password=row.getString("password");
			System.out.println(usernameTF.getText());
			System.out.println(passwordTF.getText());
			if((email.equals(usernameTF.getText()))&&(password.equals(passwordTF.getText())))
			{
				User loggedUser = new User();
				loggedUser.setEmail(row.getString("email"));
				loggedUser.setFirstName(row.getString("first_name"));
				loggedUser.setLastName(row.getString("last_name"));
				loggedUser.setPassword(row.getString("password"));
				loggedUser.setUserId(row.getInt("user_id"));
				
				Unepproject.getInstance().setLoggedUser(loggedUser);
					exist=1;
			
			}
		    
		}
		System.out.println(exist);
		if(exist==1)
		{
			
			us.notf_right("Login successful", "Welcome");
		
			Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocumentCrudAirDevice.fxml"));
	        Scene scene = new Scene(root2);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
	        app_stage.setScene(scene);
	        app_stage.setMaximized(true);
	        app_stage.show();
	        player.stop();
		}else
		{
			us.notf_false("Login failed", "Please check your email or password");
		}
	
	}

	@FXML
	void signupbtn(ActionEvent event) throws IOException {
	        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentInscription.fxml"));
	        Scene scene = new Scene(root);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
	        app_stage.setScene(scene);
	        app_stage.setMaximized(true);
	        app_stage.show();
	       
	}

	@FXML
	void motdepasseoub(ActionEvent event) {

	}

	@FXML
	void facebookaccess(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		mediaView.setMediaPlayer(player);
		player.play();
		player.setCycleCount(MediaPlayer.INDEFINITE);
	}

}
