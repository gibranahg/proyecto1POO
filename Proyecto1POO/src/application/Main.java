package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;


public class Main extends Application {


	public void start(Stage primaryStage) {

		CategoryAxis yAxis = new CategoryAxis();
		yAxis.setLabel("Palabras");

		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Frecuencia");


		BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
		chart.setTitle("Proyecto 1 ");
		// agregamos datos 
		chart.setData(obtenerDatos());

		// Paneles
		StackPane root = new StackPane();
		root.getChildren().add(chart);

		// Tamaño del Frame
		Scene scene = new Scene(root, 640, 427);

		primaryStage.setTitle("Proyecto 1");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	@SuppressWarnings("unchecked")
	public static ObservableList<XYChart.Series<Number, String>> obtenerDatos() {
		metodos obj=new metodos();

		ArrayList<String> lista;
		ArrayList<String> listaLimpia;
		ArrayList<String> listaNumeros;
		ArrayList<String> listaPalabras;
		String tempArray[];
		int num;

		lista=obj.regresaRuta("/Users/gibranalberto/Downloads/archive/Booking_Jobs_All_220218.csv");
		listaPalabras=obj.regresaRuta("/Users/gibranalberto/Downloads/palabras30.txt");

		String[][] lista1=new String[lista.size()][];

		for(int i=0;i<lista.size();i++) {
			lista1[i]=lista.get(i).split(",");
		}

		for(int i=0;i<lista1.length;i++) {
			for(int j=0;j<lista1[i].length;j++) {
				//System.out.println(lista1[i][j] + "|");
			}
		}


		listaLimpia=obj.limpiar(lista);

		listaNumeros=obj.contar(listaLimpia,"/Users/gibranalberto/Downloads/palabras30.txt");
		for(String txt : listaNumeros) {
			//System.out.println(txt);
		}


		XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();

		frecuenciasPalabras.setName("Cantidad Palabras");

		for(int i=0;i<listaPalabras.size();i++) {

			num=Integer.parseInt(listaNumeros.get(i));

			frecuenciasPalabras.getData().addAll(

					new XYChart.Data<>(num, listaPalabras.get(i)));

		}



		ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
		data.addAll(frecuenciasPalabras);

		return data;
	}


	public static void main(String[] args) {
		launch(args);
	}
}