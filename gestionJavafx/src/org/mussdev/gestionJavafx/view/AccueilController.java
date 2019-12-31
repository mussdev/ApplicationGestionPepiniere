package org.mussdev.gestionJavafx.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.mussdev.gestionJavafx.Main;
import org.mussdev.gestionJavafx.model.Article;
import org.mussdev.gestionJavafx.model.ArticleVendu;
import org.mussdev.gestionJavafx.model.Client;
import org.mussdev.gestionJavafx.model.Commande;
import org.mussdev.gestionJavafx.model.LigneCommande;
import org.mussdev.gestionJavafx.model.Livraison;
import org.mussdev.gestionJavafx.model.LivraisonSoldClient;
import org.mussdev.gestionJavafx.model.OracleConnexion;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AccueilController implements Initializable {
	@FXML
	public MenuItem insererArticleJardinier, menuItemconsulterArticle, supprimerArticleJardinier, insererClientCommercial,
	menuItemconsulterClient, supprimerClientCommercial, insererCommandeCom, consulterCommandeCom, supprimerCommandeCom,
	insererLivraisonCom, consulterLivraisonCom, supprimerLivraisonCom, ItemAccueil, menuItemconsulterLivraisonCom;
	
	@FXML
	public Pane paneConsulterArticle, paneConsulterClient,paneConsulterCommande,paneAccueil,
	paneLivraisonConsulter,paneInsererArticle,paneInsertClient,paneInsertCommande,
	paneInserLivraison,paneVenteParPeriode,paneSoldeClient,paneArticleVendu,panedeleteArticle,paneModSupprClient;
	
	@FXML
	public TableView<Article> tableViewArticle;
	
	@FXML
	public TableView<Article> TableViewNoArticle,tableViewModifSupprimArticle;
	
	@FXML
	public TableView<Client> tableViewConsultClient,tableViewAffichNomClientCom,tableViewModSuppClient;
	
	@FXML 
	public TableView<Commande> tableViewConsulterCommand;
	
	@FXML
	public TableView<Livraison> tableViewConsultLivraison;
	
	@FXML
	public TableView<LigneCommande> tableViewEnregistLivraison;
	
	@FXML
	public TableView<ArticleVendu> tableViewArticleVendu;
	
	@FXML 
	public TableColumn<ArticleVendu, String> tbColumnNomArtcileVendu;
	
	@FXML 
	public TableColumn<ArticleVendu, String> tbColumnQteArticleVendu;
	
	@FXML 
	public TableColumn<LigneCommande, String> tblColumnNoCommand;
	
	@FXML 
	public TableColumn<LigneCommande, String> tblColumnEnregArticle;
	
	@FXML 
	public TableColumn<LigneCommande, String> tblColumnQteDeComm;
	
	@FXML 
	public TableColumn<Article, String> tblColumnDescripArticle;
	
	@FXML 
	public TableColumn<Article, String> tblColumnPrixUniArticle;
	
	@FXML 
	public TableColumn<Article, String> tblColumnQteStockArticle;
	
	@FXML
	public TableColumn<Client, String> tbColumnNomClient;
	
	@FXML
	public TableColumn<Client, String> tbColumnTelClient;
	
	@FXML
	public TableColumn<Commande, String> tableColumnNumCom;
	
	@FXML
	public TableColumn<Commande, String> tableColumnNonClt;
	
	@FXML
	public TableColumn<Commande, String> tableColumnDescArticle;
	
	@FXML
	public TableColumn<Commande, String> tableColumPriUni;
	
	@FXML
	public TableColumn<Commande, String> tableColumnQte;
	
	@FXML
	public TableColumn<Commande, String> tableColumnDatComm;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnNomCltLivr;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnDescptArtclLivr;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnQteLivr;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnPrixU;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnDateComLivr;
	
	@FXML 
	public TableColumn<Livraison, String> tblColumnDateLivr;
	
	@FXML
	public TableColumn<Client, String> txtColumnNocltCommand; 
	
	@FXML
	public TableColumn<Client, String> txtColumNomCltCommand;
	
	@FXML
	public TableColumn<Article, String> tableColumnNoArtilceCom;
	
	@FXML
	public TableColumn<Article, String> numArtilcle;
	
	@FXML
	public TableColumn<Article, String> tbColumnDescripModSupp;
	
	@FXML
	public TableColumn<Article, String> tbColumnPrixUArticleModSupp;
	
	@FXML
	public TableColumn<Article, String> tbColumnQteArticleModSupp;
	
	@FXML 
	public TableView<LivraisonSoldClient> tbleViewSoldeClient;
	
	@FXML 
	public TableColumn<LivraisonSoldClient, String> tbColumnNomSoldCli;
	
	@FXML 
	public TableColumn<LivraisonSoldClient, String> tbColumnNomArtSold;
	
	@FXML 
	public TableColumn<LivraisonSoldClient, String> tbColumnQteSoldCli;
	
	@FXML 
	public TableColumn<LivraisonSoldClient, String> tbColumnPrixUSoldCli;
	
	@FXML 
	public TableColumn<LivraisonSoldClient, String> tbColumnSoldCli;
	
	@FXML 
	public TableColumn<Client, String> tblColumnModSupprimNomclt;
	
	@FXML 
	public TableColumn<Client, String> tblColumnModSupprimTel;
	
	@FXML
	public Button btnVoirArticle,btnClient,btnVoirCommande, btnVoirDetailLivr,btnEnregistrerArticle,btnInserClient,
	btnVoirGraphSoldeClient,btnActualiserClient,btnSeDeconnecter;
	
	@FXML
	public TextField txtFieldDescpArticle,txtFieldPrixUnitaire,txtFieldQteStock,txtFieldNomClient,txtFieldTelClient,textFieldNoClit,
	textfieldNumeroArticle,txtfieldQteCommande,txtfieldNoComm, txtfieldNoArticle,txtfieldQteLivraison,textfieldNumAritcle,
	txetfieldDescripArticle,txetfieldPrixUArticle,txetfieldQteArticle,textfieldnumClt,textfieldNomClt,textfieldTelClt;
	
	@FXML
	public Label labelTitreInserArticle, labelInfosEnregArticle,lblDescrpArticle,lblPrixUArticle,lblQteArticle,labelInfoAccueil,
	labelInfosInserClient, lblnfosInserCom,labelInfosLivraison,labelInfosVentePeriode,labelInfosModSuppArticle,labelnfosModSuppClient;
	
	@FXML
	public DatePicker datePickerCommande,datepickerLivraison,datePickerPeriode,datePickerSedPeriode;
	
	@FXML
	public BarChart<?, ?> BarchartVentePeride,barchartSoldClient,barChartArticleVendu;
	
	@FXML
	public CategoryAxis x;
	
	@FXML 
	public NumberAxis y;
	
	private ObservableList<Article>data, datNoArtCom;
	private ObservableList<Client>datacl;
	private ObservableList<Client>dataNomClient;
	private ObservableList<Commande>dataCom;
	private ObservableList<Livraison>dataLivr, dataLivrVtePer;
	private ObservableList<LivraisonSoldClient>dataLivrSoldCli;
	private ObservableList<LigneCommande>datalignCommande;
	private ObservableList<ArticleVendu> dataArticleVendu;
	private OracleConnexion oraclConn;
	private ResultSet rs, rsArtCom, rslignCom;
	private Connection con;
	private PreparedStatement pst,pstLignCom;
	private int myId;
	private AnchorPane ConnexionPane;
	
	
	 @FXML 
	 public void afficherFeneVentePeriode(javafx.event.ActionEvent event) {
		 paneVenteParPeriode.toFront(); 
	 }
	 
	 @FXML 
	 public void allerFenetreAccueil(javafx.event.ActionEvent event) {
		 paneAccueil.toFront(); 
	 }
	 
	 @FXML 
	 public void afficherFeneModSuppClient(javafx.event.ActionEvent event) {
		 paneModSupprClient.toFront(); 
	 }
	@FXML
	public void consulterArticle(javafx.event.ActionEvent event) {
		paneConsulterArticle.toFront();
	}
	
	@FXML
	public void consulterClient(javafx.event.ActionEvent event) {
		paneConsulterClient.toFront();
	}
	
	@FXML
	public void voirPaneConsulterCommande(javafx.event.ActionEvent event) {
		paneConsulterCommande.toFront();
	}
	
	@FXML
	public void consulterLivraisonCom(javafx.event.ActionEvent event) {
		paneLivraisonConsulter.toFront();
	}
	
	@FXML
	public void afficherFeneInsererArticle(javafx.event.ActionEvent event) {
		paneInsererArticle.toFront();
	}
	
	
	/*
	 * Appeler une fenêtre pour inscire un client
	 */
	@FXML
	public void appelFenetreInsererClient(javafx.event.ActionEvent event) {
		paneInsertClient.toFront();
	}
	
	/*
	 * Fenêtre inserer client
	 */
	@FXML
	public void insererCommande(javafx.event.Event event) throws SQLException {
		paneInsertCommande.toFront();
	}
	
	/*
	 * Fenêtre pour enregistrer une livraison
	 * */
	@FXML
	public void appelFenetreEnregistLivraison(javafx.event.ActionEvent event) {
		paneInserLivraison.toFront();
	}
	
	/*
	 * Fenêtre pour afficher le solde client
	 * */
	@FXML
	public void afficherFeneSoldClient(javafx.event.ActionEvent event) {
		paneSoldeClient.toFront();
	}
	
	@FXML
	public void afficherFeneVenteArticle(javafx.event.ActionEvent event) {
		paneArticleVendu.toFront();
	}
	
	@FXML
	public void afficherFeneInsererModSuppArticle(javafx.event.ActionEvent event) {
		panedeleteArticle.toFront();
	}
	
	// Methode pour afficher les articles
	@FXML
	public void voirArtcile(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		data=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("select * from ADMIN.ARTICLE");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			data.add(new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		// Mettre les valeurs dans le tableau
		tblColumnDescripArticle.setCellValueFactory(new PropertyValueFactory<>("description"));
		tblColumnPrixUniArticle.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
		tblColumnQteStockArticle.setCellValueFactory(new PropertyValueFactory<>("quantiteEnStock") );
		
		tableViewArticle.setItems(null);
		tableViewArticle.setItems(data);
	}
		
	// Methode pour afficher les clients
	@FXML
	public void btnconsulterClient(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		datacl=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("select * from ADMIN.CLIENT");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			datacl.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		// Mettre les valeurs dans le tableau
		tbColumnNomClient.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
		tbColumnTelClient.setCellValueFactory(new PropertyValueFactory<>("noTelephone"));
		
		tableViewConsultClient.setItems(null);
		tableViewConsultClient.setItems(datacl);
	}
		
		// Methode pour afficher les commandes
		
	@FXML
	public void consulterCommande(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		dataCom=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("select ADMIN.COMMANDE.NOCOMMANDE, ADMIN.CLIENT.NOMCLIENT ,ADMIN.ARTICLE.DESCRIPTION, ADMIN.ARTICLE.PRIXUNITAIRE, ADMIN.LIGNECOMMANDE.QUANTITE, ADMIN.COMMANDE.DATECOMMANDE\r\n" + 
				"from ADMIN.COMMANDE \r\n" + 
				"INNER JOIN ADMIN.LIGNECOMMANDE ON ADMIN.LIGNECOMMANDE.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.ARTICLE.NOARTICLE=ADMIN.LIGNECOMMANDE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.CLIENT ON ADMIN.CLIENT.NOCLIENT=ADMIN.COMMANDE.NOCLIENT");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			dataCom.add(new Commande(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		
		// Mettre les valeurs dans le tableau
		tableColumnNumCom.setCellValueFactory(new PropertyValueFactory<>("numCommande"));
		tableColumnNonClt.setCellValueFactory(new PropertyValueFactory<>("nomClientCom"));
		tableColumnDescArticle.setCellValueFactory(new PropertyValueFactory<>("descArticleCom"));
		tableColumPriUni.setCellValueFactory(new PropertyValueFactory<>("prixUniArtCom"));
		tableColumnQte.setCellValueFactory(new PropertyValueFactory<>("qteCom"));
		tableColumnDatComm.setCellValueFactory(new PropertyValueFactory<>("dateCom"));
		
		tableViewConsulterCommand.setItems(null);
		tableViewConsulterCommand.setItems(dataCom);
	}
	
	// Methode pour afficher la liste des commandes et les details de livraison
	
	@FXML
	public void voirLivraison(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		dataLivr=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("SELECT\r\n" + 
				"    ADMIN.CLIENT.NOMCLIENT, ADMIN.ARTICLE.DESCRIPTION, ADMIN.DETAILLIVRAISON.QUANTITELIVREE, ADMIN.ARTICLE.PRIXUNITAIRE,\r\n" + 
				"    ADMIN.COMMANDE.DATECOMMANDE, ADMIN.LIVRAISON.DATELIVRAISON\r\n" + 
				"FROM ADMIN.LIVRAISON\r\n" + 
				"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n" + 
				"INNER JOIN ADMIN.CLIENT ON ADMIN.COMMANDE.NOCLIENT=ADMIN.CLIENT.NOCLIENT");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			dataLivr.add(new Livraison(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		
		// Mettre les valeurs dans le tableau
		tblColumnNomCltLivr.setCellValueFactory(new PropertyValueFactory<>("nomClientLivr"));
		tblColumnDescptArtclLivr.setCellValueFactory(new PropertyValueFactory<>("descArticlLivr"));
		tblColumnQteLivr.setCellValueFactory(new PropertyValueFactory<>("qteLivr"));
		tblColumnPrixU.setCellValueFactory(new PropertyValueFactory<>("prixUniArtLivr"));
		tblColumnDateComLivr.setCellValueFactory(new PropertyValueFactory<>("dateComLivr"));
		tblColumnDateLivr.setCellValueFactory(new PropertyValueFactory<>("dateLivr"));
		
		tableViewConsultLivraison.setItems(null);
		tableViewConsultLivraison.setItems(dataLivr);
	}
	
	/*
	 * Methode inserer un article
	 */
	
	@FXML
	public void enregistrerArticle(javafx.event.Event event) throws SQLException {
		if(txtFieldDescpArticle.getText().isEmpty() || txtFieldPrixUnitaire.getText().isEmpty() || txtFieldQteStock.getText().isEmpty()) {
			labelInfosEnregArticle.setText("Veillez remplir les champs svp !");
		}else {
			String regExp = "[a-zA-Z ]+";
			String regExpInt = "[0-9]+";
			String regEntierDecimal = "[\\d+(\\.\\d{1,5})?]+";
			if(txtFieldDescpArticle.getText().matches(regExp)) {
				if(txtFieldPrixUnitaire.getText().matches(regEntierDecimal)) {
					if(txtFieldQteStock.getText().matches(regExpInt)) {
						oraclConn = new OracleConnexion();
						con = oraclConn.connectDB();
						String sqlId = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
						pst=con.prepareStatement(sqlId);
						rs=pst.executeQuery();
						if(rs.next()) {
							myId = Integer.parseInt(rs.getString(1));
							String sqlInsert = "INSERT INTO ADMIN.ARTICLE (NOARTICLE, DESCRIPTION, PRIXUNITAIRE, QUANTITEENSTOCK) VALUES (?, ?, ?, ?)"; 
							pst=con.prepareStatement(sqlInsert);
							// Récuperer les valeurs dans le formulaire
							pst.setInt(1, myId);
							pst.setString(2, txtFieldDescpArticle.getText());
							pst.setDouble(3, Double.parseDouble(txtFieldPrixUnitaire.getText()));
							pst.setInt(4, Integer.parseInt(txtFieldQteStock.getText()));
							pst.executeUpdate();
							pst.close();
							
							// Vider les champs
							txtFieldDescpArticle.clear();
							txtFieldPrixUnitaire.clear();
							txtFieldQteStock.clear();
							
						}				
						labelInfosEnregArticle.setText("Article enregistré !");
					}else {labelInfosEnregArticle.setText("Veillez saisir des caracteres exe: [0-9]");}
				}else {labelInfosEnregArticle.setText("Veillez saisir des nombres svp !");}
			}else{
				labelInfosEnregArticle.setText("Veillez saisir des caracteres exe: [a-z ou A-Z]");
			}
		}
	}

	/*
	 * Inserer client
	 */
	
	@FXML
	public void InsererClient(javafx.event.ActionEvent event) throws SQLException {
		if(txtFieldNomClient.getText().isEmpty() || txtFieldTelClient.getText().isEmpty() ) {
			labelInfosInserClient.setText("Remplissez tous les champs svp !");
		}else {
			String regExpNomClient = "[a-zA-Z ]+";
			String regExpTel = "[\\(\\d{3}\\)\\d{3}[-]?\\d{4}]+" ;
			if(txtFieldNomClient.getText().matches(regExpNomClient)) {
				if(txtFieldTelClient.getText().matches(regExpTel)) {
					oraclConn = new OracleConnexion();
					con = oraclConn.connectDB();
					String sqlIdClt = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
					pst=con.prepareStatement(sqlIdClt);
					rs=pst.executeQuery();
					if(rs.next()) {
						int idClt = Integer.parseInt(rs.getString(1));
						String sqlInCl = "INSERT INTO ADMIN.CLIENT VALUES (?,?,?)";
						pst=con.prepareStatement(sqlInCl);
						
						pst.setInt(1, idClt);
						pst.setString(2, txtFieldNomClient.getText());
						pst.setString(3, txtFieldTelClient.getText());
						pst.executeUpdate();
						
						pst.close();
						txtFieldNomClient.clear();
						txtFieldTelClient.clear();
					}
					labelInfosInserClient.setText("Client bien inscrit !");
				}else {labelInfosInserClient.setText("Saisissez des numéros sous format (000) 000 000");}
			}else {labelInfosInserClient.setText("Saisissez des caractères alphabetiques svp !");}
		}
	}

	/*
	 * Methode qui va mettre à jour nos composants pour le numero client
	 * */
	public void initialiseDescription(Client clt) {
		// On initialise par defaut
		textFieldNoClit.setText("");
		textfieldnumClt.setText("");
		textfieldNomClt.setText("");
		textfieldTelClt.setText("");
		
		// Si un objet est passé en paramètre, on modifie l'IHM
		if(clt!=null) {
			textFieldNoClit.setText(clt.getIdClt().get().toString());
			textfieldnumClt.setText(clt.getIdClt().get().toString());
			textfieldNomClt.setText(clt.getNomClient().get().toString());
			textfieldTelClt.setText(clt.getNoTelephone().get().toString());
		}
	}
	
	/*
	 * Methode qui va mettre à jour nos composants article
	 * */
	public void initialiseArticle(Article art) {
		// On initialise par defaut
		textfieldNumAritcle.setText("");
		txetfieldDescripArticle.setText("");
		txetfieldPrixUArticle.setText("");
		txetfieldQteArticle.setText("");
		
		// Si un objet est passé en paramètre, on modifie l'IHM
		if(art!=null) {
			textfieldNumAritcle.setText(art.getNoArtcl().get().toString());
			txetfieldDescripArticle.setText(art.getDescription().get().toString());
			txetfieldPrixUArticle.setText(art.getPrixUnitaire().get().toString());
			txetfieldQteArticle.setText(art.getQuantiteEnStock().get().toString());
		}
	}
	
	/*
	 * Methode qui va mettre à jour nos composants pour le numero de l'article
	 * */
	public void initialiseDescriptionNoArticle(Article artcl) {
		// On initialise par defaut
		textfieldNumeroArticle.setText("");
		
		// Si un objet est passé en paramètre, on modifie l'IHM
		if(artcl!=null) {
			textfieldNumeroArticle.setText(artcl.getNoArtcl().get().toString());
		}
	}
	
	/*
	 * Methode qui va mettre à jour nos composants dans l'interface d'insertion livraison
	 * */
	public void initialiseDescriptionLignComm(LigneCommande lignCom) {
		// On initialise par defaut
		txtfieldNoComm.setText("");
		txtfieldNoArticle.setText("");
		txtfieldQteLivraison.setText("");
		
		// Si un objet est passé en paramètre, on modifie l'IHM
		if(lignCom!=null) {
			txtfieldNoComm.setText(lignCom.getNoCommande().get().toString());
			txtfieldNoArticle.setText(lignCom.getNoArticle().get().toString());
			txtfieldQteLivraison.setText(lignCom.getQuantite().get().toString());
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Mettre le champ numéro client en lecture seuelement
		textfieldnumClt.setDisable(true);
		textfieldNumAritcle.setDisable(true);
		try {
			//System.out.println("Charge le controller...");
			oraclConn = new OracleConnexion();
			con = oraclConn.connectDB();
			//data=FXCollections.observableArrayList();
			dataNomClient=FXCollections.observableArrayList();
			datNoArtCom=FXCollections.observableArrayList();
			datalignCommande=FXCollections.observableArrayList();
			rslignCom=con.createStatement().executeQuery("select*from ADMIN.LIGNECOMMANDE");
			rsArtCom=con.createStatement().executeQuery("select * from  ADMIN.ARTICLE");
			rs=con.createStatement().executeQuery("select * from ADMIN.CLIENT");
			
			while(rs.next()) {
				// Récuperer les données dans la variable data
				dataNomClient.add(new Client(rs.getString(1),rs.getString(2), rs.getString(3)));
			}
			
			// Mettre les valeurs dans le tableau pour le client
			txtColumnNocltCommand.setCellValueFactory(new PropertyValueFactory<>("idClt"));
			txtColumNomCltCommand.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
			
			// Client
			tableViewAffichNomClientCom.setItems(null);
			tableViewAffichNomClientCom.setItems(dataNomClient);
			
			tableViewAffichNomClientCom.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> initialiseDescription(newvalue));
			
			// AFIICHER LES VALEURS DU CLIENTS DANS LE TABLEAU AVANT DE MODIFIER OU SUPPRIMER
			
			tblColumnModSupprimNomclt.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
			tblColumnModSupprimTel.setCellValueFactory(new PropertyValueFactory<>("noTelephone"));
			
			tableViewModSuppClient.setItems(null);
			tableViewModSuppClient.setItems(dataNomClient);
			tableViewModSuppClient.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> initialiseDescription(newvalue));
		
			while(rsArtCom.next()) {
				datNoArtCom.add(new Article(rsArtCom.getString(1), rsArtCom.getString(2), rsArtCom.getString(3), rsArtCom.getString(4)));
			}
			
			// Mettre les valeurs dans le tableau pour l'article 
			tableColumnNoArtilceCom.setCellValueFactory(new PropertyValueFactory<>("noArtcl"));
			// Article
			TableViewNoArticle.setItems(null);
			TableViewNoArticle.setItems(datNoArtCom);
			
			TableViewNoArticle.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> initialiseDescriptionNoArticle(newvalue));
			
			// Mettre les valeurs de l'article dans la table pour la modification ou la suppression
			
			numArtilcle.setCellValueFactory(new PropertyValueFactory<>("noArtcl"));
			tbColumnDescripModSupp.setCellValueFactory(new PropertyValueFactory<>("description"));
			tbColumnPrixUArticleModSupp.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
			tbColumnQteArticleModSupp.setCellValueFactory(new PropertyValueFactory<>("quantiteEnStock"));
		
			tableViewModifSupprimArticle.setItems(null);
			tableViewModifSupprimArticle.setItems(datNoArtCom);
			tableViewModifSupprimArticle.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> initialiseArticle(newvalue));
			
			/*
			 * Code pour afficher les informtions de la table ligne commande dans l'interface enregistrer une livraison
			 * */
			
			while(rslignCom.next()) {
				datalignCommande.add(new LigneCommande(rslignCom.getString(1),rslignCom.getString(2), rslignCom.getString(3)));
			}
			
			// Mettre les valeurs dans le tableau pour l'article 
			tblColumnNoCommand.setCellValueFactory(new PropertyValueFactory<>("noCommande"));
			tblColumnEnregArticle.setCellValueFactory(new PropertyValueFactory<>("noArticle"));
			tblColumnQteDeComm.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				// Article
			tableViewEnregistLivraison.setItems(null);
			tableViewEnregistLivraison.setItems(datalignCommande);
			tableViewEnregistLivraison.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> initialiseDescriptionLignComm(newvalue));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	/*
	 * Methode enregistrer une commande
	 * */
	@FXML
	public void enregistrerCommande(javafx.event.ActionEvent event) throws SQLException {
		if(datePickerCommande.getValue() != null ) {
			if(textFieldNoClit.getText().isEmpty() || textfieldNumeroArticle.getText().isEmpty() || txtfieldQteCommande.getText().isEmpty()) {
				lblnfosInserCom.setText("Veillez reigner tous champs svp !");
			}else {
				oraclConn = new OracleConnexion();
				con = oraclConn.connectDB();
				String sqlId = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
				pst=con.prepareStatement(sqlId);
				rs=pst.executeQuery();
				if(rs.next()) {
					myId = Integer.parseInt(rs.getString(1));
					String sqlInsert = "INSERT INTO ADMIN.COMMANDE (NOCOMMANDE, DATECOMMANDE, NOCLIENT) VALUES (?, ?, ?)"; 
					String sqlInsertLignComma = "INSERT INTO ADMIN.LIGNECOMMANDE (NOCOMMANDE, NOARTICLE, QUANTITE) VALUES (?, ?, ?)"; 
					pstLignCom=con.prepareStatement(sqlInsertLignComma);
					pst=con.prepareStatement(sqlInsert);
					// Récuperer les valeurs dans le formulaire
					pst.setInt(1, myId);
					// Regex for datePicker
					String pattern = "dd/MM/YYYY";
					DateTimeFormatter dateformater = DateTimeFormatter.ofPattern(pattern);
					String datecom = dateformater.format(datePickerCommande.getValue());
					//System.out.println(datecom);
					pst.setString(2, String.valueOf(datecom));
					pst.setInt(3, Integer.parseInt(textFieldNoClit.getText()));
					pst.executeUpdate();
					pst.close();
					
					pstLignCom.setInt(1, myId);
					pstLignCom.setInt(2, Integer.parseInt(textfieldNumeroArticle.getText()));
					pstLignCom.setInt(3, Integer.parseInt(txtfieldQteCommande.getText()));
					pstLignCom.executeUpdate();
					
					pstLignCom.close();
					// Vider les champs
					textfieldNumeroArticle.clear();
					txtfieldQteCommande.clear();
					textFieldNoClit.clear();
				}				
				lblnfosInserCom.setText("Commande enregistrée !");
			}
		}else {lblnfosInserCom.setText("Renseignez la date svp !");}
	}
	
	/*
	 * Methode pour enregistrer une livraison
	 * */
	@FXML
	public void enregistrerLivraison(javafx.event.ActionEvent event) throws SQLException {
		if(datepickerLivraison.getValue() != null ) {
			if(txtfieldNoComm.getText().isEmpty() || txtfieldNoArticle.getText().isEmpty() || txtfieldQteLivraison.getText().isEmpty()) {
				labelInfosLivraison.setText("Veillez reigner tous champs svp !");
			}else {
				oraclConn = new OracleConnexion();
				con = oraclConn.connectDB();
				String sqlId = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
				pst=con.prepareStatement(sqlId);
				rs=pst.executeQuery();
				if(rs.next()) {
					myId = Integer.parseInt(rs.getString(1));
					String sqlLivraison = "INSERT INTO ADMIN.LIVRAISON (NOLIVRAISON, DATELIVRAISON) VALUES (?, ?)"; 
					String sqlDetailLivr = "INSERT INTO ADMIN.DETAILLIVRAISON (NOLIVRAISON, NOCOMMANDE, NOARTICLE, QUANTITELIVREE) VALUES (?, ?, ?, ?)"; 
					pstLignCom=con.prepareStatement(sqlDetailLivr);
					pst=con.prepareStatement(sqlLivraison);
					// Récuperer les valeurs dans le formulaire
					pst.setInt(1, myId);
					// Regex for datePicker
					String pattern = "dd/MM/YYYY";
					DateTimeFormatter dateformater = DateTimeFormatter.ofPattern(pattern);
					String datecom = dateformater.format(datepickerLivraison.getValue());
					//System.out.println(datecom);
					pst.setString(2, String.valueOf(datecom));
					pst.executeUpdate();
					pstLignCom.setInt(1, myId);
					pstLignCom.setInt(2, Integer.parseInt(txtfieldNoComm.getText()));
					pstLignCom.setInt(3, Integer.parseInt(txtfieldNoArticle.getText()));
					pstLignCom.setInt(4, Integer.parseInt(txtfieldQteLivraison.getText()));
					pstLignCom.executeUpdate();
					
					// Vider les champs
					txtfieldNoComm.clear();
					txtfieldNoArticle.clear();
					txtfieldQteLivraison.clear();
				}				
				labelInfosLivraison.setText("Livraison enregistrée !");
			}
		}else {labelInfosLivraison.setText("Renseignez la date svp !");}
	}
	
	// Methode pour afficher le graphe des ventes par période
	
	@FXML
	public void afficherGraphVentePeriode(javafx.event.ActionEvent event) throws SQLException {
		if(datePickerPeriode.getValue()!=null && datePickerSedPeriode.getValue() != null) {
			oraclConn = new OracleConnexion();
			con = oraclConn.connectDB();
			String pattern = "dd/MM/YYYY";
			DateTimeFormatter dateformater = DateTimeFormatter.ofPattern(pattern);
			String datecom = dateformater.format(datePickerPeriode.getValue());
			String dateSecperiod = dateformater.format(datePickerSedPeriode.getValue());
			String reqVtePrde ="SELECT\r\n" + 
					"    ADMIN.ARTICLE.DESCRIPTION, ADMIN.DETAILLIVRAISON.QUANTITELIVREE, ADMIN.LIVRAISON.DATELIVRAISON\r\n" + 
					"FROM ADMIN.LIVRAISON\r\n" + 
					"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
					"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
					"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n" + 
					"INNER JOIN ADMIN.CLIENT ON ADMIN.COMMANDE.NOCLIENT=ADMIN.CLIENT.NOCLIENT \r\n" + 
					"WHERE ADMIN.LIVRAISON.DATELIVRAISON BETWEEN TO_DATE('"+datecom+"') AND TO_DATE('"+dateSecperiod+"')";
			dataLivrVtePer=FXCollections.observableArrayList();
			rs=con.createStatement().executeQuery(reqVtePrde);
			while(rs.next()) {
				XYChart.Series setl = new XYChart.Series<>();
				setl.getData().add(new XYChart.Data(rs.getString(1), Integer.parseInt(rs.getString(2))));
				
				BarchartVentePeride.getData().addAll(setl);
			}
			
		} else if (datePickerPeriode.getValue()!=null){
			
			  oraclConn = new OracleConnexion(); con = oraclConn.connectDB(); 
			  String pattern = "dd/MM/YYYY"; DateTimeFormatter dateformater =
			  DateTimeFormatter.ofPattern(pattern); String datecom = dateformater.format(datePickerPeriode.getValue()); 
			  String reqVtePrde ="SELECT\r\n" + " ADMIN.ARTICLE.DESCRIPTION, ADMIN.DETAILLIVRAISON.QUANTITELIVREE, ADMIN.LIVRAISON.DATELIVRAISON\r\n"
			  + "FROM ADMIN.LIVRAISON\r\n" + "INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n"
			  + "INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n"
			  + "INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n"
			  + "INNER JOIN ADMIN.CLIENT ON ADMIN.COMMANDE.NOCLIENT=ADMIN.CLIENT.NOCLIENT \r\n" + "WHERE ADMIN.LIVRAISON.DATELIVRAISON='"+datecom+"'";
			  dataLivrVtePer=FXCollections.observableArrayList();
			  rs=con.createStatement().executeQuery(reqVtePrde); 
			  while(rs.next()) {
			  XYChart.Series setl = new XYChart.Series<>(); 
			  setl.getData().add(new XYChart.Data(rs.getString(1), Integer.parseInt(rs.getString(2))));
			  
			  BarchartVentePeride.getData().addAll(setl); }
			 
		}else {labelInfosVentePeriode.setText("Sélectionné une période svp !");}
		//BarchartVentePeride.getData().clear();
	}
	
	// Methode pour afficher le solde des clients
	
	@FXML
	public void afficherSoldeClient(javafx.event.ActionEvent event) throws SQLException {
		
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		dataLivrSoldCli=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("SELECT \r\n" + 
				"    ADMIN.CLIENT.NOMCLIENT,\r\n" + 
				"    SUM(ADMIN.DETAILLIVRAISON.QUANTITELIVREE * ADMIN.ARTICLE.PRIXUNITAIRE) AS \"SOLDE CLIENT\"\r\n" + 
				"FROM ADMIN.LIVRAISON\r\n" + 
				"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n" + 
				"INNER JOIN ADMIN.CLIENT ON ADMIN.COMMANDE.NOCLIENT=ADMIN.CLIENT.NOCLIENT GROUP BY ADMIN.CLIENT.NOMCLIENT");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			dataLivrSoldCli.add(new LivraisonSoldClient(rs.getString(1),  rs.getString(2)));
		}
		
		// Mettre les valeurs dans le tableau
		tbColumnNomSoldCli.setCellValueFactory(new PropertyValueFactory<>("nomClientLivr"));
		tbColumnSoldCli.setCellValueFactory(new PropertyValueFactory<>("soldeclient"));
		
		tbleViewSoldeClient.setItems(null);
		tbleViewSoldeClient.setItems(dataLivrSoldCli);
	}
	
	// Methode pour la visualisation des soldes clients
	@FXML
	public void voirGraphSoldClient(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		String reqSoldCli ="SELECT \r\n" + 
				"    ADMIN.CLIENT.NOMCLIENT,\r\n" + 
				"    SUM(ADMIN.DETAILLIVRAISON.QUANTITELIVREE * ADMIN.ARTICLE.PRIXUNITAIRE) AS \"SOLDE CLIENT\"\r\n" + 
				"FROM ADMIN.LIVRAISON\r\n" + 
				"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE\r\n" + 
				"INNER JOIN ADMIN.CLIENT ON ADMIN.COMMANDE.NOCLIENT=ADMIN.CLIENT.NOCLIENT GROUP BY ADMIN.CLIENT.NOMCLIENT";
		dataLivrVtePer=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery(reqSoldCli);
		while(rs.next()) {
			XYChart.Series setl = new XYChart.Series<>();
			setl.getData().add(new XYChart.Data(rs.getString(1), Float.parseFloat(rs.getString(2))));
			
			barchartSoldClient.getData().addAll(setl);
		}
	}
	
	// Methode pour voir les ventes par article
	
	@FXML
	public void voirArticleVendu(javafx.event.ActionEvent event) throws SQLException {
		
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		dataArticleVendu=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("SELECT \r\n" + 
				"    ADMIN.ARTICLE.DESCRIPTION AS \"ARTICLE VENDU\", SUM(ADMIN.DETAILLIVRAISON.QUANTITELIVREE) AS \"QUANTITE VENDUE\"\r\n" + 
				"FROM ADMIN.LIVRAISON\r\n" + 
				"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE GROUP BY ADMIN.ARTICLE.DESCRIPTION");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			dataArticleVendu.add(new ArticleVendu(rs.getString(1),  rs.getString(2)));
		}
		
		// Mettre les valeurs dans le tableau
		tbColumnNomArtcileVendu.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
		tbColumnQteArticleVendu.setCellValueFactory(new PropertyValueFactory<>("qteVendu"));
		
		tableViewArticleVendu.setItems(null);
		tableViewArticleVendu.setItems(dataArticleVendu);
	}
	
	// Methode pour afficher le graphe vente par article
	
	@FXML
	public void voirGraphArticleVendu(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		String reqVenteArticle ="SELECT \r\n" + 
				"    ADMIN.ARTICLE.DESCRIPTION AS \"ARTICLE VENDU\", SUM(ADMIN.DETAILLIVRAISON.QUANTITELIVREE) AS \"QUANTITE VENDUE\"\r\n" + 
				"FROM ADMIN.LIVRAISON\r\n" + 
				"INNER JOIN ADMIN.DETAILLIVRAISON ON ADMIN.DETAILLIVRAISON.NOLIVRAISON=ADMIN.LIVRAISON.NOLIVRAISON\r\n" + 
				"INNER JOIN ADMIN.ARTICLE ON ADMIN.DETAILLIVRAISON.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
				"INNER JOIN ADMIN.COMMANDE ON ADMIN.DETAILLIVRAISON.NOCOMMANDE=ADMIN.COMMANDE.NOCOMMANDE GROUP BY ADMIN.ARTICLE.DESCRIPTION";
		dataArticleVendu=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery(reqVenteArticle);
		while(rs.next()) {
			XYChart.Series setl = new XYChart.Series<>();
			setl.getData().add(new XYChart.Data(rs.getString(1), Integer.parseInt(rs.getString(2))));
			
			barChartArticleVendu.getData().addAll(setl);
		}
	}
	
	// Methode pour actualiser les articles après suppression ou modifcation
	
	@FXML
	public void actualiserArticle(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		data=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("select * from ADMIN.ARTICLE");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			data.add(new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		// Mettre les valeurs dans le tableau
		numArtilcle.setCellValueFactory(new PropertyValueFactory<>("noArtcl"));
		tbColumnDescripModSupp.setCellValueFactory(new PropertyValueFactory<>("description"));
		tbColumnPrixUArticleModSupp.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
		tbColumnQteArticleModSupp.setCellValueFactory(new PropertyValueFactory<>("quantiteEnStock") );
		
		tableViewModifSupprimArticle.setItems(null);
		tableViewModifSupprimArticle.setItems(data);
	}
	
	// Methode modifier un article
	
	@FXML
	public void modifierArticle(javafx.event.ActionEvent event) throws SQLException {
		if(txetfieldDescripArticle.getText().isEmpty() || txetfieldPrixUArticle.getText().isEmpty() ||
				txetfieldQteArticle.getText().isEmpty() ) {
			labelInfosModSuppArticle.setText("Veillez modifier les valeurs!");
		}else {
			String regExp = "[a-zA-Z ]+";
			String regExpInt = "[0-9]+";
			String regEntierDecimal = "[\\d+(\\.\\d{1,5})?]+";
			if(txetfieldDescripArticle.getText().matches(regExp)) {
				if(txetfieldPrixUArticle.getText().matches(regEntierDecimal)) {
					if(txetfieldQteArticle.getText().matches(regExpInt)) {
						oraclConn = new OracleConnexion();
						con = oraclConn.connectDB();
						/*
						 * String sqlId = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
						 * pst=con.prepareStatement(sqlId); rs=pst.executeQuery();
						 */
							String sqlEdit = "UPDATE ADMIN.ARTICLE SET ADMIN.ARTICLE.DESCRIPTION=?, ADMIN.ARTICLE.PRIXUNITAIRE=?, ADMIN.ARTICLE.QUANTITEENSTOCK=? WHERE \r\n" + 
									"ADMIN.ARTICLE.NOARTICLE='"+textfieldNumAritcle.getText()+"'"; 
							pst=con.prepareStatement(sqlEdit);
							// Récuperer les valeurs dans le formulaire
							//pst.setInt(1, myId);
							//pst.setInt(1, Integer.parseInt(textfieldNumAritcle.getText()));
							pst.setString(1, txetfieldDescripArticle.getText());
							pst.setDouble(2, Double.parseDouble(txetfieldPrixUArticle.getText()));
							pst.setInt(3, Integer.parseInt(txetfieldQteArticle.getText()));
							pst.execute();	
							pst.close();
							// Vider les champs.
							textfieldNumAritcle.clear();
							txetfieldDescripArticle.clear();
							txetfieldPrixUArticle.clear();
							txetfieldQteArticle.clear();
							labelInfosModSuppArticle.setText("Article modifié !");
					}else {labelInfosModSuppArticle.setText("Veillez saisir des caracteres exe: [0-9]");}
				}else {labelInfosModSuppArticle.setText("Veillez saisir des nombres svp !");}
			}else{
				labelInfosModSuppArticle.setText("Veillez saisir des caracteres exe: [a-z ou A-Z]");
			}
		}
	}
	
	// Methode pour actualiser les clients
	
	@FXML
	public void actualiserClient(javafx.event.ActionEvent event) throws SQLException {
		oraclConn = new OracleConnexion();
		con = oraclConn.connectDB();
		datacl=FXCollections.observableArrayList();
		rs=con.createStatement().executeQuery("select * from ADMIN.CLIENT");
		
		while(rs.next()) {
			// Récuperer les données dans la variable data
			datacl.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		// Mettre les valeurs dans le tableau
		tblColumnModSupprimNomclt.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
		tblColumnModSupprimTel.setCellValueFactory(new PropertyValueFactory<>("noTelephone"));
		
		tableViewModSuppClient.setItems(null);
		tableViewModSuppClient.setItems(datacl);
	}
	
	// Methode pour modifier un client
	
	@FXML
	public void modifierClient(javafx.event.ActionEvent event) throws SQLException {
		if(textfieldnumClt.getText().isEmpty() || textfieldNomClt.getText().isEmpty() ||
				textfieldTelClt.getText().isEmpty() ) {
			labelnfosModSuppClient.setText("Veillez modifier les valeurs!");
		}else {
			String regExp = "[a-zA-Z ]+";
			String regExpTel = "[\\(\\d{3}\\)\\d{3}[-]?\\d{4}]+";
			if(textfieldNomClt.getText().matches(regExp)) {
				if(textfieldTelClt.getText().matches(regExpTel)) {
						oraclConn = new OracleConnexion();
						con = oraclConn.connectDB();
						/*
						 * String sqlId = "select ADMIN.NUMSEQ.NEXTVAL from DUAL";
						 * pst=con.prepareStatement(sqlId); rs=pst.executeQuery();
						 */
							String sqlEdit = "UPDATE ADMIN.CLIENT SET ADMIN.CLIENT.NOMCLIENT=?, ADMIN.CLIENT.NOTELEPHONE=? WHERE \r\n" + 
									"ADMIN.CLIENT.NOCLIENT='"+textfieldnumClt.getText()+"'"; 
							pst=con.prepareStatement(sqlEdit);
							// Récuperer les valeurs dans le formulaire
							//pst.setInt(1, myId);
							//pst.setInt(1, Integer.parseInt(textfieldNumAritcle.getText()));
							pst.setString(1, textfieldNomClt.getText());
							pst.setString(2, textfieldTelClt.getText());
							pst.execute();	
							pst.close();
							// Vider les champs.
							textfieldnumClt.clear();
							textfieldNomClt.clear();
							textfieldTelClt.clear();

							labelnfosModSuppClient.setText("Client modifié !");
				}else {labelnfosModSuppClient.setText("Veillez saisir des nombres svp !");}
			}else{
				labelnfosModSuppClient.setText("Veillez saisir des caracteres exe: [a-z ou A-Z]");
			}
		}
	}
	
	/*
	 * Supprimer une article s'il n'y a pas de coammande si celui-ci
	 * */
	
	@FXML
	public void supprimerArticle(javafx.event.ActionEvent event) throws SQLException {
		if(txetfieldDescripArticle.getText().isEmpty() || txetfieldPrixUArticle.getText().isEmpty() ||
				txetfieldQteArticle.getText().isEmpty() ) {
			labelInfosModSuppArticle.setText("Selectionnez un article svp !");
		}else {
			oraclConn = new OracleConnexion();
			con = oraclConn.connectDB();
			int idArticle = Integer.parseInt(textfieldNumAritcle.getText());
			String reqSqlCommandSurArticle = "SELECT\r\n" + 
					"    *\r\n" + 
					"FROM ADMIN.ARTICLE \r\n" + 
					"\r\n" + 
					"INNER JOIN ADMIN.LIGNECOMMANDE ON ADMIN.LIGNECOMMANDE.NOARTICLE=ADMIN.ARTICLE.NOARTICLE\r\n" + 
					"\r\n" + 
					"INNER JOIN ADMIN.COMMANDE ON ADMIN.COMMANDE.NOCOMMANDE=ADMIN.LIGNECOMMANDE.NOCOMMANDE\r\n" + 
					"\r\n" + 
					"WHERE ADMIN.ARTICLE.NOARTICLE='"+idArticle+"'";
			rs = con.createStatement().executeQuery(reqSqlCommandSurArticle);
			
			// Verifier s'il y a une commande passée sur l'article
			
			if(rs.next()) {
				labelInfosModSuppArticle.setText("Desolé Vous ne pouvez pas supprimer cet article car"
						+ " il existe des commandes sur l'article");
			}else {
				String reqSqlSuppArticle = "DELETE FROM ADMIN.ARTICLE WHERE ADMIN.ARTICLE.NOARTICLE='"+idArticle+"'";
				rs = con.createStatement().executeQuery(reqSqlSuppArticle);
				textfieldNumAritcle.clear();
				txetfieldDescripArticle.clear();
				txetfieldPrixUArticle.clear();
				txetfieldQteArticle.clear();
				labelInfosModSuppArticle.setText("Article supprimé !");
			}
		}
	}
	
	/*
	 * Supprimer un client s'il n'a pas passé de commande
	 * */
	
	@FXML
	public void supprimerClient(javafx.event.ActionEvent event) throws SQLException {
		if(textfieldnumClt.getText().isEmpty() || textfieldNomClt.getText().isEmpty() ||
				textfieldTelClt.getText().isEmpty() ) {
			labelnfosModSuppClient.setText("Selectionnez un client svp !");
		}else {
			oraclConn = new OracleConnexion();
			con = oraclConn.connectDB();
			int idClt = Integer.parseInt(textfieldnumClt.getText());
			String reqSqlClientCommanddArticle = "SELECT\r\n" + 
					"    *\r\n" + 
					"FROM ADMIN.CLIENT\r\n" + 
					"\r\n" + 
					"INNER JOIN ADMIN.COMMANDE ON ADMIN.COMMANDE.NOCLIENT = ADMIN.CLIENT.NOCLIENT"
					+ " WHERE CLIENT.NOCLIENT='"+idClt+"'";
			rs= con.createStatement().executeQuery(reqSqlClientCommanddArticle);
			// Verifier s'il y a une commande passée sur l'article
			
			if(rs.next()) {
				labelnfosModSuppClient.setText("Desolé vous ne pouvez pas supprimer le client car il a passé des commandes");
			}else {
				String reqSqlSuppClient = "DELETE FROM ADMIN.CLIENT WHERE ADMIN.CLIENT.NOCLIENT='"+idClt+"'";
				rs=con.createStatement().executeQuery(reqSqlSuppClient);
				rs.close();
				textfieldnumClt.clear();
				textfieldNomClt.clear();
				textfieldTelClt.clear();
				labelnfosModSuppClient.setText("Client supprimé !");
			}
		}
	}

	// Se deconneter de la page principale
	@FXML
	public void seDeconnecter() throws IOException {
		Stage stage = (Stage) btnSeDeconnecter.getScene().getWindow();
		stage.close();
		
		// Ouvrir la fenêtre de connexion
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/org/mussdev/gestionJavafx/view/Connexion.fxml"));
		ConnexionPane = (AnchorPane) loader.load();
		
		// Show the scene containing the Connexion
		
		Scene scene = new Scene(ConnexionPane);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		//Stage stageCon = new Stage();
		//stageCon.show();
		
	}
	
}
	
