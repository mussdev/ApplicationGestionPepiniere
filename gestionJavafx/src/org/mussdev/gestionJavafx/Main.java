package org.mussdev.gestionJavafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private AnchorPane ConnexionPane;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Connexion");
		initConnexion();
	}
	
	/**
	 * Initializes the connexion
	 */
	public void initConnexion() {
		try {
			
			// Création d'un objet qi va nous permettre de charger la fenêtre connexion
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/org/mussdev/gestionJavafx/view/Connexion.fxml"));
			ConnexionPane = (AnchorPane) loader.load();
			
			// Show the scene containing the Connexion
			
			Scene scene = new Scene(ConnexionPane);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Returns the main stage.
     * @return
     */
	
	public static void main(String[] args) {
		launch(args);
	}

}
