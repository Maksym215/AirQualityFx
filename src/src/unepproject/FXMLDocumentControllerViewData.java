package src.unepproject;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import com.bordercloud.sparql.Endpoint;
import com.bordercloud.sparql.EndpointException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.model.AirDevice;
import src.model.Alert;


/*
 * view data controlleur 
 * MDALEL AHMED
 * ©ahmed.mdallel@esprit.tn©
 */
public class FXMLDocumentControllerViewData implements Initializable {

    @FXML
    private ImageView pdf;

    @FXML
    private ImageView menuimage;

    @FXML
    private AnchorPane opacitypane;

    @FXML
    private PieChart Piechart2;

    @FXML
    private BarChart<?, ?> Barchart3;

    @FXML
    private AnchorPane drawerpane;

    @FXML
    private BarChart<?, ?> Barchart;

    @FXML
    private JFXButton menulogout;
    public String queryInsert,queryInsert1,queryInsert2,queryInsert3,queryInsert4;
   public  String endpoint = "http://localhost:8890/sparql-auth";

   public String endpoint1 = "http://localhost:8890/sparql";
    @FXML
    private LineChart<?, ?> linechart;
		private List listno2 = new ArrayList<>();
		private List listSo2 = new ArrayList<>();
		private List list03 = new ArrayList<>();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
	     	Piechart();
	     	//RDF();
              /*
               * 
               * READ DATA FROM BLOCKCHAIN
               * CHANGER LES INFORMATION STATIQUE
               * 
               */
	     	
	     	/*
	     	 * bar chart
	     	 */
	        XYChart.Series series=new XYChart.Series();

	        series.getData().addAll(new XYChart.Data<>("NO3",100));

	        XYChart.Series series1=new XYChart.Series();

	        series1.getData().addAll(new XYChart.Data<>("SO2",400));


	        XYChart.Series series2=new XYChart.Series();

	        series2.getData().addAll(new XYChart.Data<>("O2",550));



	       Barchart3.getData().addAll(series,series1,series2);
	   
	       
	        XYChart.Series series211=new XYChart.Series();

	        series211.getData().addAll(new XYChart.Data<>("NO3",220));

	        XYChart.Series series12=new XYChart.Series();

	        series12.getData().addAll(new XYChart.Data<>("SO2",300));


	        XYChart.Series series22=new XYChart.Series();

	        series22.getData().addAll(new XYChart.Data<>("O2",890));



	       Barchart.getData().addAll(series211,series12,series22);
	       /*
	        * fin bar chart
	        */
	       
	       
	       /*
	        * 
	        * line chart
	        * 
	        */
	        XYChart.Series series11=new XYChart.Series();

	        series11.getData().addAll(new XYChart.Data("1",30));
	        series11.getData().addAll(new XYChart.Data("2",11));
	        series11.getData().addAll(new XYChart.Data("3",23));
	        series11.getData().addAll(new XYChart.Data("4",17));
	        series11.getData().addAll(new XYChart.Data("5",30));
	        series11.getData().addAll(new XYChart.Data("6",30));
	        series11.getData().addAll(new XYChart.Data("7",11));
	        series11.getData().addAll(new XYChart.Data("8",23));
	        series11.getData().addAll(new XYChart.Data("9",17));
	        series11.getData().addAll(new XYChart.Data("10",30));
	        series11.getData().addAll(new XYChart.Data("11",30));
	        series11.getData().addAll(new XYChart.Data("12",11));
	        series11.getData().addAll(new XYChart.Data("13",23));
	        series11.getData().addAll(new XYChart.Data("14",17));
	        series11.getData().addAll(new XYChart.Data("15",30));
	        series11.getData().addAll(new XYChart.Data("16",30));
	        series11.getData().addAll(new XYChart.Data("17",30));
	        series11.getData().addAll(new XYChart.Data("18",30));
	        series11.getData().addAll(new XYChart.Data("19",17));
	        series11.getData().addAll(new XYChart.Data("20",30));
	        series11.getData().addAll(new XYChart.Data("21",30));
	        series11.getData().addAll(new XYChart.Data("22",30));
	        series11.getData().addAll(new XYChart.Data("23",30));
	        series11.getData().addAll(new XYChart.Data("24",30));
	       
	        XYChart.Series series21=new XYChart.Series();

	        series21.getData().addAll(new XYChart.Data("1",20));
	        series21.getData().addAll(new XYChart.Data("2",17));
	        series21.getData().addAll(new XYChart.Data("3",13));
	        series21.getData().addAll(new XYChart.Data("4",19));
	        series21.getData().addAll(new XYChart.Data("5",50));
	        series21.getData().addAll(new XYChart.Data("6",20));
	        series21.getData().addAll(new XYChart.Data("7",17));
	        series21.getData().addAll(new XYChart.Data("8",13));
	        series21.getData().addAll(new XYChart.Data("9",19));
	        series21.getData().addAll(new XYChart.Data("10",50));
	        series21.getData().addAll(new XYChart.Data("11",20));
	        series21.getData().addAll(new XYChart.Data("12",17));
	        series21.getData().addAll(new XYChart.Data("13",13));
	        series21.getData().addAll(new XYChart.Data("14",19));
	        series21.getData().addAll(new XYChart.Data("15",50));
	        series21.getData().addAll(new XYChart.Data("16",20));
	        series21.getData().addAll(new XYChart.Data("17",17));
	        series21.getData().addAll(new XYChart.Data("18",13));
	        series21.getData().addAll(new XYChart.Data("19",19));
	        series21.getData().addAll(new XYChart.Data("20",50));
	        series21.getData().addAll(new XYChart.Data("21",20));
	        series21.getData().addAll(new XYChart.Data("22",17));
	        series21.getData().addAll(new XYChart.Data("23",13));
	        series21.getData().addAll(new XYChart.Data("24",19));
	      

	        XYChart.Series series31=new XYChart.Series();

	        series31.getData().addAll(new XYChart.Data("1",10));
	        series31.getData().addAll(new XYChart.Data("2",47));
	        series31.getData().addAll(new XYChart.Data("3",13));
	        series31.getData().addAll(new XYChart.Data("4",39));
	        series31.getData().addAll(new XYChart.Data("5",40));
	        series31.getData().addAll(new XYChart.Data("6",10));
	        series31.getData().addAll(new XYChart.Data("7",47));
	        series31.getData().addAll(new XYChart.Data("8",13));
	        series31.getData().addAll(new XYChart.Data("9",39));
	        series31.getData().addAll(new XYChart.Data("10",40));
	        series31.getData().addAll(new XYChart.Data("11",10));
	        series31.getData().addAll(new XYChart.Data("12",47));
	        series31.getData().addAll(new XYChart.Data("13",13));
	        series31.getData().addAll(new XYChart.Data("14",39));
	        series31.getData().addAll(new XYChart.Data("15",40));
	        series31.getData().addAll(new XYChart.Data("16",10));
	        series31.getData().addAll(new XYChart.Data("17",47));
	        series31.getData().addAll(new XYChart.Data("18",13));
	        series31.getData().addAll(new XYChart.Data("19",39));
	        series31.getData().addAll(new XYChart.Data("20",40));
	        series31.getData().addAll(new XYChart.Data("21",10));
	        series31.getData().addAll(new XYChart.Data("22",47));
	        series31.getData().addAll(new XYChart.Data("23",13));
	        series31.getData().addAll(new XYChart.Data("24",39));

	        linechart.getData().addAll(series11,series21,series31);
	        
	        /*
	         * end line chart
	         * 
	         */
			//	barchartSo2();
			// TODO Auto-generated method stub
			opacitypane.setVisible(false);
/*
 * 
 * animation menu
 * 
 */
			FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), opacitypane);
			fadeTransition.setFromValue(1);
			fadeTransition.setToValue(0);
			fadeTransition.play();

			TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), drawerpane);
			translateTransition.setByX(-600);
			translateTransition.play();

			menuimage.setOnMouseClicked(event -> {

				opacitypane.setVisible(true);

				FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacitypane);
				fadeTransition1.setFromValue(0);
				fadeTransition1.setToValue(0.15);
				fadeTransition1.play();

				TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerpane);
				translateTransition1.setByX(+600);
				translateTransition1.play();
			});

			opacitypane.setOnMouseClicked(event -> {

				FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacitypane);
				fadeTransition1.setFromValue(0.15);
				fadeTransition1.setToValue(0);
				fadeTransition1.play();

				fadeTransition1.setOnFinished(event1 -> {
					opacitypane.setVisible(false);
				});

				TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerpane);
				translateTransition1.setByX(-600);
				translateTransition1.play();
			});
			pdf.setOnMouseClicked(event9 -> {
				try {
					generatePDF();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

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

		/**
		 * @throws InterruptedException
		 */
		
		/*
		 * 
		 * function generation pdf
		 */
		public void generatePDF() throws InterruptedException {

			try {
				try {
					try {
						try {

							Image img2 = Image.getInstance("src/src/asset/Unep_logo.svg.png");
							img2.setAlignment(Element.ALIGN_CENTER);
							img2.setBorderWidth(2);
							img2.setCompressionLevel(5);

							String FILE = "src/src/asset/test3.pdf";
							OutputStream file = new FileOutputStream(new File(FILE));
							Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.DARK_GRAY);
							Font BlueFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLUE);
							Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.GRAY);
							Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

							Document my_pdf_report = new Document();
							PdfWriter.getInstance(my_pdf_report, file);
							my_pdf_report.open();

							PdfPTable my_report_table = new PdfPTable(4);

							PdfPCell table_cell;

							Phrase ref = new Phrase("REF", subFont);
							Phrase name = new Phrase("Name", subFont);
							Phrase description = new Phrase("Description", subFont);
							Phrase Price = new Phrase("Price", subFont);

							table_cell = new PdfPCell(ref);
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(name);
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(description);
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(Price);
							my_report_table.addCell(table_cell);

							int Somme = 0;
							// for (Product product : listProduct) {

							table_cell = new PdfPCell(new Phrase(("aaa"), smallBold));
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(new Phrase(("bb"), smallBold));
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(new Phrase(("ccc"), smallBold));
							my_report_table.addCell(table_cell);
							table_cell = new PdfPCell(new Phrase(("dd"), smallBold));
							my_report_table.addCell(table_cell);

							// }

							Paragraph sommeP = new Paragraph("Total : " + Somme + "    ", catFont);
							sommeP.setAlignment(Element.ALIGN_RIGHT);
							/*
							 * DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); String dt =
							 * df.format("2012-11-17T00:00:00.000-05:00"); DateFormat dff = new
							 * SimpleDateFormat("MM/dd/yyyy "); String dtRc = dff.format("11/11/2012");
							 */

							Paragraph preface = new Paragraph("REPORT N° ", BlueFont);
							preface.setAlignment(Element.ALIGN_CENTER);

							Paragraph preface1 = new Paragraph("Informations ", catFont);
							preface1.setAlignment(Element.ALIGN_LEFT);

							Paragraph preface2 = new Paragraph("Informations ", catFont);
							preface2.setAlignment(Element.ALIGN_LEFT);

							Paragraph preface3 = new Paragraph("Messing Air data", catFont);
							preface3.setAlignment(Element.ALIGN_LEFT);

							my_pdf_report.add(img2);
							my_pdf_report.add(new Paragraph("\n"));
							my_pdf_report.add(preface);
							my_pdf_report.add(new Paragraph("\n"));
							my_pdf_report.add(preface1);

							my_pdf_report.add(new Paragraph("Added the : " + "date1"));
							my_pdf_report.add(new Paragraph(" Date : " + "date2"));
							my_pdf_report.add(new Paragraph("Quantity  : "));
							my_pdf_report.add(new Paragraph("Description : "));
							my_pdf_report.add(new Paragraph("Type : "));
							my_pdf_report.add(preface2);
							my_pdf_report.add(new Paragraph(" Name : "));
							my_pdf_report.add(new Paragraph("Phone : "));
							my_pdf_report.add(new Paragraph("Email : "));
							my_pdf_report.add(preface3);
							my_pdf_report.add(new Paragraph("."));
							my_pdf_report.add(my_report_table);
							my_pdf_report.add(sommeP);
							Robot robot;
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							LocalDate localDate = LocalDate.now();
							try {
								robot = new Robot();
								String a = dtf.format(localDate).toString();
								BufferedImage screenShot = robot
										.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
								ImageIO.write(screenShot, "JPG", new File("src/src/asset/stat1.jpg"));
							} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Image screen = Image.getInstance("src/src/asset/stat1.jpg");
							screen.setAlignment(Element.ALIGN_CENTER);
							screen.setBorderWidth(2);
							screen.scaleToFit(600f, 600f);
							my_pdf_report.add(screen);
							my_pdf_report.close();
							file.close();

						

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					} catch (DocumentException e) {
						e.printStackTrace();
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/*
		 * 
		 * function barchart
		 */
		public void barchartSo2() {
			String csvFile = "src/src/asset/AirQuality.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ";";
			Set date = new TreeSet();
			try {

				br = new BufferedReader(new FileReader(csvFile));
				br.readLine();
				br.readLine();
				while ((line = br.readLine()) != null) {
					// use comma as separator
					
					
					/*
					 * 
					 * change data from csv
					 */
					String[] data = line.split(cvsSplitBy);
				      XYChart.Series series11=new XYChart.Series();

				        series11.getData().addAll(new XYChart.Data("1",30));
				        series11.getData().addAll(new XYChart.Data("2",11));
				        series11.getData().addAll(new XYChart.Data("3",23));
				        series11.getData().addAll(new XYChart.Data("4",17));
				        series11.getData().addAll(new XYChart.Data("5",30));
				        series11.getData().addAll(new XYChart.Data("6",30));
				        series11.getData().addAll(new XYChart.Data("7",11));
				        series11.getData().addAll(new XYChart.Data("8",23));
				        series11.getData().addAll(new XYChart.Data("9",17));
				        series11.getData().addAll(new XYChart.Data("10",30));
				        series11.getData().addAll(new XYChart.Data("11",30));
				        series11.getData().addAll(new XYChart.Data("12",11));
				        series11.getData().addAll(new XYChart.Data("13",23));
				        series11.getData().addAll(new XYChart.Data("14",17));
				        series11.getData().addAll(new XYChart.Data("15",30));
				        series11.getData().addAll(new XYChart.Data("16",30));
				        series11.getData().addAll(new XYChart.Data("17",30));
				        series11.getData().addAll(new XYChart.Data("18",30));
				        series11.getData().addAll(new XYChart.Data("19",17));
				        series11.getData().addAll(new XYChart.Data("20",30));
				        series11.getData().addAll(new XYChart.Data("21",30));
				        series11.getData().addAll(new XYChart.Data("22",30));
				        series11.getData().addAll(new XYChart.Data("23",30));
				        series11.getData().addAll(new XYChart.Data("24",30));
				       
				        XYChart.Series series21=new XYChart.Series();

				        series21.getData().addAll(new XYChart.Data("1",20));
				        series21.getData().addAll(new XYChart.Data("2",17));
				        series21.getData().addAll(new XYChart.Data("3",13));
				        series21.getData().addAll(new XYChart.Data("4",19));
				        series21.getData().addAll(new XYChart.Data("5",50));
				        series21.getData().addAll(new XYChart.Data("6",20));
				        series21.getData().addAll(new XYChart.Data("7",17));
				        series21.getData().addAll(new XYChart.Data("8",13));
				        series21.getData().addAll(new XYChart.Data("9",19));
				        series21.getData().addAll(new XYChart.Data("10",50));
				        series21.getData().addAll(new XYChart.Data("11",20));
				        series21.getData().addAll(new XYChart.Data("12",17));
				        series21.getData().addAll(new XYChart.Data("13",13));
				        series21.getData().addAll(new XYChart.Data("14",19));
				        series21.getData().addAll(new XYChart.Data("15",50));
				        series21.getData().addAll(new XYChart.Data("16",20));
				        series21.getData().addAll(new XYChart.Data("17",17));
				        series21.getData().addAll(new XYChart.Data("18",13));
				        series21.getData().addAll(new XYChart.Data("19",19));
				        series21.getData().addAll(new XYChart.Data("20",50));
				        series21.getData().addAll(new XYChart.Data("21",20));
				        series21.getData().addAll(new XYChart.Data("22",17));
				        series21.getData().addAll(new XYChart.Data("23",13));
				        series21.getData().addAll(new XYChart.Data("24",19));
				      

				        XYChart.Series series31=new XYChart.Series();

				        series31.getData().addAll(new XYChart.Data("1",10));
				        series31.getData().addAll(new XYChart.Data("2",47));
				        series31.getData().addAll(new XYChart.Data("3",13));
				        series31.getData().addAll(new XYChart.Data("4",39));
				        series31.getData().addAll(new XYChart.Data("5",40));
				        series31.getData().addAll(new XYChart.Data("6",10));
				        series31.getData().addAll(new XYChart.Data("7",47));
				        series31.getData().addAll(new XYChart.Data("8",13));
				        series31.getData().addAll(new XYChart.Data("9",39));
				        series31.getData().addAll(new XYChart.Data("10",40));
				        series31.getData().addAll(new XYChart.Data("11",10));
				        series31.getData().addAll(new XYChart.Data("12",47));
				        series31.getData().addAll(new XYChart.Data("13",13));
				        series31.getData().addAll(new XYChart.Data("14",39));
				        series31.getData().addAll(new XYChart.Data("15",40));
				        series31.getData().addAll(new XYChart.Data("16",10));
				        series31.getData().addAll(new XYChart.Data("17",47));
				        series31.getData().addAll(new XYChart.Data("18",13));
				        series31.getData().addAll(new XYChart.Data("19",39));
				        series31.getData().addAll(new XYChart.Data("20",40));
				        series31.getData().addAll(new XYChart.Data("21",10));
				        series31.getData().addAll(new XYChart.Data("22",47));
				        series31.getData().addAll(new XYChart.Data("23",13));
				        series31.getData().addAll(new XYChart.Data("24",39));

				        linechart.getData().addAll(series11,series21,series31);
					
				}
		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			}
/*
 * function pie chart
 * 
 */
		public void Piechart() {
			ObservableList<PieChart.Data> listt = FXCollections.observableArrayList();
			String csvFile1 = "src/src/asset/AirQuality.csv";
			BufferedReader br1 = null;
			String line1 = "";
			String cvsSplitBy1 = ";";
			Set date1 = new TreeSet();
			try {

				br1 = new BufferedReader(new FileReader(csvFile1));
				br1.readLine();
				br1.readLine();
				while ((line1 = br1.readLine()) != null) {
					// use comma as separator
					String[] data = line1.split(cvsSplitBy1);
							list03.add(data[5]);
							listno2.add(data[4]);
							listSo2.add(data[3]);
					
				}
				listt.addAll(new PieChart.Data("SO2", getSomme(listSo2)));
				listt.addAll(new PieChart.Data("NO2", getSomme(listno2)));
				listt.addAll(new PieChart.Data("03", getSomme(list03)));
			
				Piechart2.setData(listt);
				Piechart2.setStartAngle(90);

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
		}



		public int getSomme(List<String> list) {
			int somme = 0;
			for (int i = 0; i < list.size(); i++) {
				somme += Integer.valueOf(list.get(i));
			}
			return somme;
		}
		public int getava(String month)
		{
			String csvFile4 = "src/src/asset/AirQuality.csv";
			BufferedReader br4 = null;
			String line4 = "";
			String cvsSplitBy1 =";";
			int somme=0;	
			try {

				br4 = new BufferedReader(new FileReader(csvFile4));
				br4.readLine();
				br4.readLine();
				while ((line4 = br4.readLine()) != null) {
					// use comma as separator
					String[] data = line4.split(cvsSplitBy1);
			
							
					
				}
			

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br4 != null) {
					try {
						br4.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
			return somme;
		}
		
		/*
		 * function to share data semantique web
		 * 
		 */
		public void RDF() {
			try {
				String csvFile4 = "src/src/asset/AirQuality.csv";
				BufferedReader br4 = null;
				String line4 = "";
				String cvsSplitBy1 =";";
				int somme=0;	
				try {

					br4 = new BufferedReader(new FileReader(csvFile4));
					br4.readLine();
					br4.readLine();
					while ((line4 = br4.readLine()) != null) {
						// use comma as separator
						String[] data = line4.split(cvsSplitBy1);
				
				 queryInsert = "INSERT DATA "+
	              " {GRAPH <http://example.com/airquality>  "+
	              "   {             "+
	              "       <http://example.com/"+data[0]+"> <http://example.com/date> \""+data[1]+"\""+
	              "    }   "+
	              "}";
				 queryInsert1 = "INSERT DATA "+
			              " {GRAPH <http://example.com/airquality>  "+
			              "   {             "+
			              "       <http://example.com/"+data[0]+"> <http://example.com/heure> \""+data[2]+"\""+
			              "    }   "+
			              "}";
				 queryInsert2 = "INSERT DATA "+
			              " {GRAPH <http://example.com/airquality>  "+
			              "   {             "+
			              "       <http://example.com/"+data[0]+"> <http://example.com/SO2> \""+data[3]+"\""+
			              "    }   "+
			              "}";
				 queryInsert3 = "INSERT DATA "+
			              " {GRAPH <http://example.com/airquality>  "+
			              "   {             "+
			              "       <http://example.com/"+data[0]+"> <http://example.com/NO2> \""+data[4]+"\""+
			              "    }   "+
			              "}";
				 queryInsert4 = "INSERT DATA "+
			              " {GRAPH <http://example.com/airquality>  "+
			              "   {             "+
			              "       <http://example.com/"+data[0]+"> <http://example.com/O3> \""+data[5]+"\""+
			              "    }   "+
			              "}";
	    
			
	            // with Virtuoso
	   
	            Endpoint sp1 = new Endpoint( endpoint, false);

	            sp1.setLogin("dba");
	            sp1.setPassword("dba");
	           
	            HashMap<String, HashMap> rs1 =sp1.query(queryInsert);
	            printResult(rs1,150);
	            /*
	            HashMap<String, HashMap> rs11 =sp1.query(queryInsert1);
	            printResult(rs11,150);
	            HashMap<String, HashMap> rs12 =sp1.query(queryInsert2);
	            printResult(rs12,150);
	            HashMap<String, HashMap> rs13 =sp1.query(queryInsert3);
	            printResult(rs13,150);
	            HashMap<String, HashMap> rs14 =sp1.query(queryInsert4);
	            printResult(rs14,150);
	            */
	            
	            
		}
					
					

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br4 != null) {
						try {
							br4.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
	        
	            String querySelect = "SELECT * "
	                    +
	            "where {GRAPH <http://example.com/airquality>  "+
	            "   {             "+
	            "   ?x ?y ?z"+
	            "    }   "+
	            "}";
	   System.out.println(querySelect);
	          
	            Endpoint sp3 = new Endpoint(endpoint1, false);
	            sp3.setMethodHTTPRead("GET");
	            HashMap<String, HashMap> rs3 = sp3.query(querySelect);
	            printResult(rs3,30);  
	          

	        } catch (EndpointException eex) {
	            System.out.println(eex);
	            eex.printStackTrace();
	        } 
		}
	    public static void printResult(HashMap<String, HashMap> rs, int size) {

	        for (String variable : (ArrayList<String>) rs.get("result").get("variables")) {
	            System.out.print(String.format("%-" + size + "." + size + "s", variable) + " | ");
	        }
	        System.out.print("\n");
	        for (HashMap<String, Object> value : (ArrayList<HashMap<String, Object>>) rs.get("result").get("rows")) {
	            //System.out.print(value);
	            /* for (String key : value.keySet()) {
	         System.out.println(value.get(key));            
	         }*/
	            for (String variable : (ArrayList<String>) rs.get("result").get("variables")) {
	                //System.out.println(value.get(variable));
	                System.out.print(String.format("%-" + size + "." + size + "s", value.get(variable)) + " | ");
	            }
	            System.out.print("\n");
	        }
	    }
}
