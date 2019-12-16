package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commande {
	private final StringProperty numCommande;
	private final StringProperty nomClientCom;
	private final StringProperty descArticleCom;
	private final StringProperty prixUniArtCom;
	private final StringProperty qteCom;
	private final StringProperty dateCom;
	
	// Constructeur avec parametre
	
	public Commande(String numCommande, String nomClientCom, String descArticleCom,
			String prixUniArtCom, String qteCom, String dateCom) {
		this.numCommande = new SimpleStringProperty(numCommande);
		this.nomClientCom = new SimpleStringProperty(nomClientCom);
		this.descArticleCom = new SimpleStringProperty(descArticleCom);
		this.prixUniArtCom = new SimpleStringProperty(prixUniArtCom);
		this.qteCom = new SimpleStringProperty(qteCom);
		this.dateCom = new SimpleStringProperty(dateCom);
	}
	
	// Getters
	
	public StringProperty getNumCommande() {
		return numCommande;
	}
	
	public StringProperty getNomClientCom() {
		return nomClientCom;
	}
	public StringProperty getDescArticleCom() {
		return descArticleCom;
	}
	public StringProperty getPrixUniArtCom() {
		return prixUniArtCom;
	}
	public StringProperty getQteCom() {
		return qteCom;
	}
	public StringProperty getDateCom() {
		return dateCom;
	}
	
	// setters
	
		public void setNumCommande(String value) {
			numCommande.set(value);
		}
		
		public void setNomClientCom(String value) {
			nomClientCom.set(value);
		}
		public void setDescArticleCom(String value) {
			descArticleCom.set(value);
		}
		public void setPrixUniArtCom(String value) {
			prixUniArtCom.set(value);
		}
		public void setQteCom(String value) {
			qteCom.set(value);
		}
		public void setDateCom(String value) {
			dateCom.set(value);
		}
		
		public StringProperty numCommandeProperty() {return numCommande;}
		public StringProperty nomClientComProperty() {return nomClientCom;}
		public StringProperty descArticleComProperty() {return descArticleCom;}
		public StringProperty prixUniArtComProperty() {return prixUniArtCom;}
		public StringProperty qteComProperty() {return qteCom;}
		public StringProperty dateComProperty() {return dateCom;}
	
	
}
