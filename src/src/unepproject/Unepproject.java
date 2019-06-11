/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.unepproject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONObject;

import com.sun.jna.platform.win32.Netapi32Util.User;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 *
 * @author mdallelahmed
 */
public class Unepproject extends Application {
	 private static Unepproject instance;
	    
	   private src.model.User loggedUser;
	   public Unepproject() throws IOException
	    {
	        instance = this;
	       
	    }
	   
	    public static Unepproject getInstance()
	    {
	        return instance;
	    }
	
	   
	    public void setLoggedUser(src.model.User loggedUser) {
	        this.loggedUser = loggedUser;
	    }
	    
	    public src.model.User  getLoggedUser() {
	        return loggedUser;
	    }
    @Override
    public void start(Stage stage) throws Exception {
    	
    	/*
    	 * 
    	 * Block chain function
    	 * 
    	 */
    	
    	/*
    	JSONObject json = new JSONObject();

    	json.put("indexblock",3);
    	json.put("timestamp", "test");
    	json.put("hash", "hash");
    	json.put("previousHash", "phash");
    	json.put("data", "data");
    	// creation blockchain
    	Blockchain blockchain= new Blockchain(1);
    	//changer lire les information du capteur !!
    	String csvFile1 = "src/src/asset/Clarity.csv";
		BufferedReader br1 = null;
		String line1 = "";
		String cvsSplitBy1 = ",";
		Set date1 = new TreeSet();
		
		try {

			br1 = new BufferedReader(new FileReader(csvFile1));
			br1.readLine();
			br1.readLine();
			while ((line1 = br1.readLine()) != null) {
				// use comma as separator
				String[] data = line1.split(cvsSplitBy1);
String a;
a="nodeId : "+data[0]+" timeUtc : "+data[1]+" aqi : "+data[2]+" pm1MassConc[ug/m3] : "+data[3]+" pm2_5MassConc[ug/m3] : "+data[4]+" pm10MassConc[ug/m3] : "+data[5]+" no2Conc[ppb] : "+data[6]+ " temperature[degC] : "+data[7]+" relHumidity[%] : "+data[7]+" latitude : "+data[8]+" longitude: "+data[9];

		    	blockchain.addBlock(blockchain.newBlock(a));

			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br1 != null) {
				try {
					br1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	//blockchain.addBlock(blockchain.newBlock("block 1"));
    	System.out.println();
    	//blockchain.addBlock(blockchain.newBlock("block 3"));
    	System.out.println(blockchain.isBlockChainValid());
    	System.out.println(blockchain);
    	*/
        URL url = getClass().getResource("FXMLDocumentLogin.fxml");
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLDocumentLogin.fxml"));
        Parent root = FXMLLoader.load(url);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
