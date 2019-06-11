package src.unepproject;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.model.AirDevice;
import src.model.Alert;



public class FXMLDocumentControllerCrudAlert implements Initializable {

    @FXML
    private JFXTextField descriptionTF;

    @FXML
    private AnchorPane drawerpane;

    @FXML
    private Label iddeviceLB;

    @FXML
    private TableColumn<Alert, Integer> iddevicecol;

    @FXML
    private JFXTextField iddeviceTF;

    @FXML
    private Label dateLB;

    @FXML
    private TableColumn<Alert, String> statuscol;

    @FXML
    private ImageView menuimage;

    @FXML
    private JFXTextField DateTF;

    @FXML
    private Label descriptionLB;

    @FXML
    private TableColumn<Alert, Integer> idusercol;

    @FXML
    private JFXButton addairdevicebtn;

    @FXML
    private JFXTextField searchairdeviceTF;

    @FXML
    private TableColumn<Alert, Integer> idalertcol;

    @FXML
    private Label iduserLB;

    @FXML
    private JFXButton editairdevicebtn;

    @FXML
    private TableColumn<Alert, String> despcriptioncol;

    @FXML
    private JFXTextField iduserTF;

    @FXML
    private JFXTextField statusF11;

    @FXML
    private Label statusLB;

    @FXML
    private JFXButton clearbtn;

    @FXML
    private AnchorPane opacitypane;

    @FXML
    private JFXButton deleteairdevicebtn;

    @FXML
    private TableView<Alert> tabView;
    
    @FXML
	private JFXButton menulogout;

    @FXML
    private TableColumn<Alert, String> datecol1;

    @FXML
    void searchairdevice(ActionEvent event) {

    }

    @FXML
    void ajouterButtonAction(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {

    }


    @FXML
    void showairdevice(ActionEvent event) {

    }



    @FXML
    void gomanagedevice(ActionEvent event) throws IOException {
    	Parent root4 = FXMLLoader.load(getClass().getResource("FXMLDocumentCrudAirDevice.fxml"));
        Scene scene = new Scene(root4);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);	        app_stage.setMaximized(true);

        app_stage.show();
    }

    @FXML
    void goviewdata(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentViewData.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);	        app_stage.setMaximized(true);

        app_stage.show();
    }

    @FXML
    void gomanagealert(ActionEvent event) throws IOException {
    	Parent root3 = FXMLLoader.load(getClass().getResource("FXMLDocumentCrudAlert.fxml"));
        Scene scene = new Scene(root3);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);	        app_stage.setMaximized(true);

        app_stage.show();
    }

    @FXML
    void goviewrepport(ActionEvent event) throws IOException {
    	Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocumentViewRepport.fxml"));
        Scene scene = new Scene(root2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);
        app_stage.setMaximized(true);

        app_stage.show();
    }
    @FXML
    void logout(ActionEvent event) {
    	Stage stage = (Stage) menulogout.getScene().getWindow();
		stage.close();
    }
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 opacitypane.setVisible(false);

	        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),opacitypane);
	        fadeTransition.setFromValue(1);
	        fadeTransition.setToValue(0);
	        fadeTransition.play();

	        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),drawerpane);
	        translateTransition.setByX(-600);
	        translateTransition.play();


	        menuimage.setOnMouseClicked(event -> {


	            opacitypane.setVisible(true);

	            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacitypane);
	            fadeTransition1.setFromValue(0);
	            fadeTransition1.setToValue(0.15);
	            fadeTransition1.play();

	            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),drawerpane);
	            translateTransition1.setByX(+600);
	            translateTransition1.play();
	        });

	        opacitypane.setOnMouseClicked(event -> {



	            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),opacitypane);
	            fadeTransition1.setFromValue(0.15);
	            fadeTransition1.setToValue(0);
	            fadeTransition1.play();

	            fadeTransition1.setOnFinished(event1 -> {
	                opacitypane.setVisible(false);
	            });


	            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),drawerpane);
	            translateTransition1.setByX(-600);
	            translateTransition1.play();
	        });

	}

}
