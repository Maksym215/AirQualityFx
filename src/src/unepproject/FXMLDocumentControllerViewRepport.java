package src.unepproject;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.model.AirDevice;
import src.model.Alert;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
/*
 * view repport controlleur 
 * MDALEL AHMED
 * ©ahmed.mdallel@esprit.tn©
 */
public class FXMLDocumentControllerViewRepport implements Initializable {

	@FXML
	private BarChart<?, ?> Barchart1;

	@FXML
	private JFXComboBox<String> datecombo;

	@FXML
	private ImageView menuimage;

	@FXML
	private BarChart<?, ?> Barchart3;

	@FXML
	private AnchorPane opacitypane;

	@FXML
	private PieChart Piechart2;

	@FXML
	private ImageView pdf;

	@FXML
	private AnchorPane drawerpane;

	@FXML
	private BarChart<?, ?> Barchart;

	@FXML
	private JFXButton menulogout;
	private Set datelist = new TreeSet();
	private List listno2 = new ArrayList<>();
	private List listSo2 = new ArrayList<>();
	private List list03 = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		datelist = readcsv();
		System.out.println(datelist.size());
		datecombo.getItems().addAll(datelist);
		// TODO Auto-generated method stub
		opacitypane.setVisible(false);

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
		app_stage.setScene(scene);
        app_stage.setMaximized(true);

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

						PdfPTable my_report_table = new PdfPTable(5);

						PdfPCell table_cell;
						Phrase city = new Phrase("City", subFont);
						Phrase indice = new Phrase("Indicator", subFont);
						Phrase so2 = new Phrase("SO2 Avg", subFont);
						Phrase no2 = new Phrase("NO2 Avg", subFont);
						Phrase o3 = new Phrase("O3 Avg", subFont);

						
						table_cell = new PdfPCell(city);
						my_report_table.addCell(table_cell);
						
						table_cell = new PdfPCell(indice);
						my_report_table.addCell(table_cell);

						table_cell = new PdfPCell(so2);
						my_report_table.addCell(table_cell);
						
						table_cell = new PdfPCell(no2);
						my_report_table.addCell(table_cell);
						
						table_cell = new PdfPCell(o3);
						my_report_table.addCell(table_cell);

						//int Somme = 0;
						// for (Product product : listProduct) {

						table_cell = new PdfPCell(new Phrase(("Paris"), smallBold));
						my_report_table.addCell(table_cell);
//(calcul.NO2>40||calcul.SO2>50||calcul.O3>24)?"Tres eleve":((calcul.NO2>20||calcul.SO2>35||calcul.O3>18)?"Eleve":((calcul.NO2>10||calcul.SO2>10||calcul.O3>12)?"Moyen":"Faible"))
	if ((Float.parseFloat(averagePollutant(4)) > 40 ) || (Float.parseFloat(averagePollutant(3)) > 50) || (Float.parseFloat(averagePollutant(5))>24) )
						{table_cell = new PdfPCell(new Phrase(("very high pollution"), smallBold));
						my_report_table.addCell(table_cell);
						}
	else if ((Float.parseFloat(averagePollutant(4)) > 20 ) || (Float.parseFloat(averagePollutant(3)) > 35) || (Float.parseFloat(averagePollutant(5))>18) )
	{table_cell = new PdfPCell(new Phrase(("high pollution"), smallBold));
	my_report_table.addCell(table_cell);
	}
	else if ((Float.parseFloat(averagePollutant(4)) > 10 ) || (Float.parseFloat(averagePollutant(3)) > 10) || (Float.parseFloat(averagePollutant(5))>12) )
	{table_cell = new PdfPCell(new Phrase(("medium level of pollution"), smallBold));
	my_report_table.addCell(table_cell);
	}
	else {
		table_cell = new PdfPCell(new Phrase(("low pollution"), smallBold));
		my_report_table.addCell(table_cell);
	}
						
						table_cell = new PdfPCell(new Phrase((averagePollutant(3)), smallBold));
						my_report_table.addCell(table_cell);
						
						table_cell = new PdfPCell(new Phrase((averagePollutant(4)), smallBold));
						my_report_table.addCell(table_cell);
						
						table_cell = new PdfPCell(new Phrase((averagePollutant(5)), smallBold));
						my_report_table.addCell(table_cell);			

						// }

						//Paragraph sommeP = new Paragraph("Total : " + Somme + "    ", catFont);
						//sommeP.setAlignment(Element.ALIGN_RIGHT);
						/*
						 * DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); String dt =
						 * df.format("2012-11-17T00:00:00.000-05:00"); DateFormat dff = new
						 * SimpleDateFormat("MM/dd/yyyy "); String dtRc = dff.format("11/11/2012");
						 */

						Paragraph preface = new Paragraph("REPORT", BlueFont);
						preface.setAlignment(Element.ALIGN_CENTER);

						Paragraph preface1 = new Paragraph("Informations ", catFont);
						preface1.setAlignment(Element.ALIGN_LEFT);

						
						my_pdf_report.add(img2);
						my_pdf_report.add(new Paragraph("\n"));
						my_pdf_report.add(preface);
						my_pdf_report.add(new Paragraph("\n"));
						my_pdf_report.add(preface1);

						my_pdf_report.add(new Paragraph("Added the : " + LocalDate.now() ));
						
						
						my_pdf_report.add(new Paragraph("."));
						my_pdf_report.add(my_report_table);
						//my_pdf_report.add(sommeP);
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

public String averagePollutant(int param) {
	
	String csvFile = "src/src/asset/AirQuality.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
	 double total = 0;
	 int n=0;
	 float avg = 0;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		br.readLine();
		br.readLine();
		
		while ((line = br.readLine()) != null) {
			// use comma as separator
			String[] data = line.split(cvsSplitBy);

			// System.out.println(" [id= " + data[0] + " , date=" + data[1] +"time=" +
			 //data[2] +"SO2=" + data[3] +"NO2=" + data[4] +"O3=" + data[5] +"]");
			
			   
			    	total = total + Float.parseFloat(data[param]);
			    n++;

		}
	     avg = (float) (total / n);
System.out.println(avg);
	
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

	return Float.toString(avg);

}
	public Set readcsv() {
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
				String[] data = line.split(cvsSplitBy);

				// System.out.println(" [date= " + data[0] + " , time=" + data[1] +"SO2=" +
				// data[2] +"NO2=" + data[3] +"time=" + data[4] +"]");
				date.add(data[1]);

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
		return date;

	}
	
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
				String[] data = line.split(cvsSplitBy);
				if (data[1].equals(datecombo.getSelectionModel().getSelectedItem().toString())) {
						 XYChart.Series series1=new XYChart.Series();
					        series1.getData().addAll(new XYChart.Data<>(data[2],Integer.parseInt(data[3])));
					        Barchart.getData().addAll(series1);
						 XYChart.Series series3=new XYChart.Series();
					        series3.getData().addAll(new XYChart.Data<>(data[2],Integer.parseInt(data[4])));
					        Barchart1.getData().addAll(series3);

						 XYChart.Series series4=new XYChart.Series();
					        series4.getData().addAll(new XYChart.Data<>(data[2],Integer.parseInt(data[5])));
					        Barchart3.getData().addAll(series4);
				
				}
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
				if (data[1].equals(datecombo.getSelectionModel().getSelectedItem().toString())) {
						list03.add(data[5]);
						listno2.add(data[4]);
						listSo2.add(data[3]);
				}
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

	@FXML
	public void generaterepport(ActionEvent event) {
     	Piechart();
		barchartSo2();
		
       
	}

	public int getSomme(List<String> list) {
		int somme = 0;
		for (int i = 0; i < list.size(); i++) {
			somme += Integer.valueOf(list.get(i));
		}
		return somme;
	}

}
