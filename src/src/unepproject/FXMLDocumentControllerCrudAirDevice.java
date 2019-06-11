package src.unepproject;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import com.jfoenix.controls.JFXButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.model.AirDevice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/*
 * CRUD AIR DEVICE
 * BEN JEMMA OTHMAN
 * ©Medothman.Benjemaa@esprit.tn©
 */
public class FXMLDocumentControllerCrudAirDevice implements Initializable {
	 @FXML
	    private TableColumn<AirDevice, String> latitudecol;
	 
	    @FXML
	    private TableColumn<AirDevice, String> longitudecol;
	    
    @FXML
    private TableColumn<AirDevice, Integer> numbercol;

    @FXML
    private JFXTextField stateTF;

    @FXML
    private JFXButton editairdevicebtn;

    @FXML
    private Label stateLB;

    @FXML
    private AnchorPane drawerpane;

    @FXML
    private Label numberLB;

    @FXML
    private TableColumn<AirDevice, String> countrycol;

    @FXML
    private Label countryLB;

    @FXML
    private TableColumn<AirDevice, Integer> idcol;

    @FXML
    private JFXTextField numberTF;

    @FXML
    private JFXButton clearbtn;

    @FXML
    private Label dateLB;

    @FXML
    private TableColumn<AirDevice, String> datecol;

    @FXML
    private ImageView menuimage;

    @FXML
    private JFXTextField DateTF;

    @FXML
    private JFXTextField countryTF;

    @FXML
    private AnchorPane opacitypane;

    @FXML
    private JFXButton deleteairdevicebtn;

    @FXML
    private JFXButton addairdevicebtn;

    @FXML
    private JFXTextField searchairdeviceTF;

    @FXML
    private TableView<AirDevice> tabView;

    @FXML
    private TableColumn<AirDevice, String> statecol;


    @FXML
    private JFXTextField stateTF11;

    @FXML
    private Label latitudeLB;

    @FXML
    private TableColumn<AirDevice, String> statuscol;

    @FXML
	private JFXButton menulogout;
    
    @FXML
    private JFXTextField statusTF11;

    @FXML
    private Label longitudeLB;

    @FXML
    private Label statusLB;

    @FXML
    private TableColumn<AirDevice, String>datecol1;
    
    
    @FXML
    void searchairdevice(ActionEvent event) {
    	 ObservableList tableairdevices = tabView.getItems();
         searchairdeviceTF.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
             if (oldValue != null && (newValue.length() < oldValue.length())) {
                 tabView.setItems(tableairdevices);
             }
             String value = newValue.toLowerCase();
             ObservableList<AirDevice> subentries = FXCollections.observableArrayList();

             long count = tabView.getColumns().stream().count();
             for (int i = 0; i < tabView.getItems().size(); i++) {
                 for (int j = 0; j < count; j++) {
                     String entry = "" + tabView.getColumns().get(j).getCellData(i);
                     if (entry.toLowerCase().contains(value)) {
                         subentries.add(tabView.getItems().get(i));
                         break;
                     }
                 }
             }
             tabView.setItems(subentries);
         });
    }

    @FXML
    void ajouterButtonAction(ActionEvent event) throws IOException, JSONException {
    	JSONArray jsonArr;

    	AirDeviceService ad_service=new AirDeviceService();
        AirDevice a = new AirDevice(countryTF.getText(),stateTF.getText(),Integer.parseInt(numberTF.getText()),DateTF.getText());
       //numberTF est la latitude fel fxml ya ahmed :D
        System.out.println("****"+a.getNumber());
        System.out.println(a);
    	jsonArr = ad_service.addAirDevice(a);
    	init_table();

    }

    @FXML
    void supprimer(ActionEvent event) throws IOException, JSONException {
    	AirDeviceService ad_service=new AirDeviceService();

    
    	 
             Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
             alerte.setTitle("confirmation");
             alerte.setHeaderText("voulez vous vraiment supprimer?");
             Optional<ButtonType> result = alerte.showAndWait();
             if (result.get() == ButtonType.OK) {
            	 ad_service.deleteAirDevice(tabView.getSelectionModel().getSelectedItem().getIdDevice());
            	 init_table();
             }
    
    }

    @FXML
    void modifier(ActionEvent event) throws IOException, JSONException {
    	
    	AirDeviceService ad_service=new AirDeviceService();

    	Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle("confirmation"); 
        alerte.setHeaderText("voulez vous vraiment modifier?");
        Optional<ButtonType> result = alerte.showAndWait();
        if (result.get() == ButtonType.OK) {
            TableRow<AirDevice> row = new TableRow<>();
//
            AirDevice a = new AirDevice(tabView.getSelectionModel().getSelectedItem().getIdDevice(),countryTF.getText(),stateTF.getText(),Integer.parseInt(numberTF.getText()),DateTF.getText());
            ad_service.updateAirDevice(a);
       	 init_table();
        }
    }

    @FXML
    void clear(ActionEvent event) {
    	countryTF.setText("");
    	countryLB.setText("");
    	stateTF.setText("");
    	stateLB.setText("");
    	dateLB.setText("");
    	DateTF.setText("");
    	numberLB.setText("");
    	numberTF.setText("");
    	latitudeLB.setText("");
    	longitudeLB.setText("");
    	
    }

   
    
    
    @FXML
    void showairdevice(ActionEvent event) throws SQLException, IOException, JSONException {
    	
////
		////
				// JSONArray jsonArr = new JSONArray("[JSON Stirng]");
			
				///

	        
    }



    @FXML
    void gomanagedevice(ActionEvent event) throws IOException {
    	Parent root4 = FXMLLoader.load(getClass().getResource("FXMLDocumentCrudAirDevice.fxml"));
        Scene scene = new Scene(root4);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);
        app_stage.setMaximized(true);

        app_stage.show();
    }

    @FXML
    void goviewdata(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentViewData.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);
        app_stage.setMaximized(true);

        app_stage.show();
    }

    @FXML
    void gomanagealert(ActionEvent event) throws IOException {
    	Parent root3 = FXMLLoader.load(getClass().getResource("FXMLDocumentCrudAlert.fxml"));
        Scene scene = new Scene(root3);
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
    @FXML
    void goviewrepport(ActionEvent event) throws IOException {
    	Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocumentViewRepport.fxml"));
        Scene scene = new Scene(root2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        app_stage.setScene(scene);
        app_stage.setMaximized(true);

        app_stage.show();
    }
	
    
 
    public List showListAirDevices() throws IOException, JSONException{
    	JSONArray jsonArr;
    	AirDeviceService ad_service=new AirDeviceService();

    	jsonArr = ad_service.getAirDevices();
		System.out.print(jsonArr.length());
		//
			List<AirDevice>  dataList = new ArrayList<>();
		
	    for (int i = 0; i < jsonArr.length(); i++) {

	        JSONObject jsonObj = jsonArr.getJSONObject(i);
	    	AirDevice data = new AirDevice();

	       data.setIdDevice(jsonObj.getInt(("id_device")));
	        data.setCountry(jsonObj.getString("country"));
	        data.setState(jsonObj.getString("state"));
	        data.setDate(jsonObj.getString("date"));
	        
	        dataList.add(data);
	       // System.out.println(data.getIdDevice());
	    }
	   return dataList; 
	   //
    }
    public void init_table() {
    	//init table
   	 idcol.setCellValueFactory(new PropertyValueFactory<AirDevice,Integer>("idDevice"));
           countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
           statecol.setCellValueFactory(new PropertyValueFactory<>("state"));
           datecol1.setCellValueFactory(new PropertyValueFactory<>("date"));
           datecol1.setCellValueFactory(new PropertyValueFactory<>("number"));

           List<AirDevice> list = null;
               try {
   				List<AirDevice> showListAirDevices = (List<AirDevice>) showListAirDevices();
   				list = showListAirDevices;
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			} catch (JSONException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
           
           ObservableList<AirDevice> items = FXCollections.observableArrayList(list);


           tabView.setItems(items);

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		//init table
		init_table();
		setmouseclick(); // when clicking on bookings
 
        
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

	//
	public void setmouseclick() {
		tabView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				AirDevice a = (AirDevice) tabView.getItems().get(tabView.getSelectionModel().getSelectedIndex());
			System.err.println("id*******"+a.getIdDevice());	
				/*
				image_event.setImage(img);
				event_txt.setText(e.getEvent().getName());
				location_txt.setText(e.getEvent().getLocation());
				date_txt.setText(e.getEvent().getDateEvent().toString());
				time_txt.setText(e.getEvent().getStartsAt());
				*/
				
				//statusTF11.setText(a.get);
	            countryTF.setText(a.getCountry());
	        stateTF.setText(a.getState());

	        DateTF.setText(a.getDate());
	        //
	        stateLB.setText(tabView.getSelectionModel().getSelectedItem().getState());
	        countryLB.setText(tabView.getSelectionModel().getSelectedItem().getCountry());
	        dateLB.setText(tabView.getSelectionModel().getSelectedItem().getDate());



	        	}
		});

	}

	
}
