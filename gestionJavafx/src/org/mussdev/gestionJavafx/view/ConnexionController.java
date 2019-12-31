package org.mussdev.gestionJavafx.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.mussdev.gestionJavafx.model.OracleConnexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ConnexionController {
	@FXML 
	public TextField txtLogin;
	@FXML 
	public PasswordField fieldPassword;
	@FXML 
	public Button buttonFermer;
	@FXML
	public Button buttonValider;
	@FXML
	public Label labelInfos;
	
	private OracleConnexion oracl_con;
	private ResultSet rs;
	private PreparedStatement pst;
	private Connection con;
	
	
	@FXML
	public void handleButtonAction(javafx.event.ActionEvent event) {
		try {	
			
			if(txtLogin.getText().isEmpty() && fieldPassword.getText().isEmpty()) {
				labelInfos.setText("Veillez remplir les champs svp !");
			}else {
					OracleConnexion.utilisateur  = txtLogin.getText();
					OracleConnexion.motpass = fieldPassword.getText();
				
				if(OracleConnexion.connectDB()!=null) {
					JOptionPane.showMessageDialog(null, "Vous êtes connecté");
					// Récuperer les rôles des utilisatuers dans la base de donnée oracle
					oracl_con = new OracleConnexion();
					con = oracl_con.connectDB();
					String reqSqlRoles = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
					pst=con.prepareStatement(reqSqlRoles);
					rs=pst.executeQuery();
					while(rs.next()) {
						
						if(rs.getString(1).contains("ROLEJARDINIER")) {
							FXMLLoader pagePrincipal = new FXMLLoader(getClass().getResource("PagePrincipale.fxml"));
							Parent root1 = (Parent) pagePrincipal.load();
							Stage stage = new Stage();
							
							// 
						    stage.setTitle("APPLICATION GESTION");
						    stage.setScene(new Scene(root1));
						    stage.setResizable(false);
						    AccueilController accCon=pagePrincipal.getController();
						    // Restreindre les fonctionnalités jardinier
						    
						    accCon.insererClientCommercial.setDisable(true);
						    accCon.insererCommandeCom.setDisable(true);
						    accCon.insererLivraisonCom.setDisable(true);
						    accCon.supprimerClientCommercial.setDisable(true);
						   // accCon.supprimerCommandeCom.setDisable(true);
						   // accCon.supprimerLivraisonCom.setDisable(true);
						    accCon.labelInfoAccueil.setText("Bonjour "+txtLogin.getText()+" ! \nVous êtes connecté !");
						    // Fermer la fenêtre de connexion
						    Stage stageCon = (Stage) buttonValider.getScene().getWindow();
						    stageCon.close();
						 // Afficher notre stage
						    stage.show();
						    break;
						 
						}else if(rs.getString(1).contains("ROLECOMMERCIAL")) {
							FXMLLoader pagePrincipal = new FXMLLoader(getClass().getResource("PagePrincipale.fxml"));
							Parent root1 = (Parent) pagePrincipal.load();
							Stage stage = new Stage();
						    stage.setTitle("APPLICATION GESTION");
						    stage.setScene(new Scene(root1));
						    stage.setResizable(false);
						    // Recuperer le controller de la page accueil
						    AccueilController accConComer=pagePrincipal.getController();
						    
						    // Restreindre les fonctionnalités du commercial
						    accConComer.insererArticleJardinier.setDisable(true);
						    accConComer.supprimerArticleJardinier.setDisable(true);
						    accConComer.labelInfoAccueil.setText("Bonjour "+txtLogin.getText()+" ! \nVous êtes connecté !");
						 // Fermer la fenêtre de connexion
						    Stage stageCon = (Stage) buttonValider.getScene().getWindow();
						    stageCon.close();
						    // Afficher notre fenetre principal
						    stage.show();
						    break;
						}else if(rs.getString(1).contains("ROLEGERANT")) {
							// Le gerant
							FXMLLoader pagePrincipal = new FXMLLoader(getClass().getResource("PagePrincipale.fxml"));
							Parent root1 = (Parent) pagePrincipal.load();
							 AccueilController roleGeran=pagePrincipal.getController();
							Stage stage = new Stage();
						    stage.setTitle("APPLICATION GESTION");
						    stage.setScene(new Scene(root1));
						    stage.setResizable(false);
						    roleGeran.insererClientCommercial.setDisable(true);
						    roleGeran.insererCommandeCom.setDisable(true);
						    roleGeran.insererLivraisonCom.setDisable(true);
						    roleGeran.supprimerClientCommercial.setDisable(true);
						   // roleGeran.supprimerCommandeCom.setDisable(true);
						    //roleGeran.supprimerLivraisonCom.setDisable(true);
						    roleGeran.insererArticleJardinier.setDisable(true);
						    roleGeran.supprimerArticleJardinier.setDisable(true);
						    roleGeran.labelInfoAccueil.setText("Bonjour "+txtLogin.getText()+" ! \nVous êtes connecté !");
						 // Fermer la fenêtre de connexion
						    Stage stageCon = (Stage) buttonValider.getScene().getWindow();
						    stageCon.close();
						    stage.show();
						    break;
						}else if(rs.getString(1).contains("DBA")) {
							// Le gerant
							FXMLLoader pagePrincipal = new FXMLLoader(getClass().getResource("PagePrincipale.fxml"));
							Parent root1 = (Parent) pagePrincipal.load();
							 AccueilController roleGeran=pagePrincipal.getController();
							Stage stage = new Stage();
						    stage.setTitle("APPLICATION GESTION");
						    stage.setScene(new Scene(root1));
						    stage.setResizable(false);
						    roleGeran.labelInfoAccueil.setText("Bonjour "+txtLogin.getText()+" ! \nVous êtes connecté !");
						 // Fermer la fenêtre de connexion
						    Stage stageCon = (Stage) buttonValider.getScene().getWindow();
						    stageCon.close();
						    stage.show();
						    break;
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "username ou password invalide", "Accès refusé", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch(Exception e) {
			// JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void btnFermer() {
		Stage stage = (Stage) buttonFermer.getScene().getWindow();
		stage.close();
	}
	
}
