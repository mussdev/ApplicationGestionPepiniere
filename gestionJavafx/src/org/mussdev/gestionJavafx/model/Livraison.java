package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Livraison {
	private final StringProperty nomClientLivr;
	private final StringProperty descArticlLivr;
	private final StringProperty qteLivr;
	private final StringProperty prixUniArtLivr;
	private final StringProperty dateComLivr;
	private final StringProperty dateLivr;
	
	// Constructeur avec parametres
	
	public Livraison(String nomClientLivr, String descArticlLivr, String qteLivr,
			String prixUniArtLivr, String dateComLivr, String dateLivr) {
		this.nomClientLivr = new SimpleStringProperty(nomClientLivr);
		this.descArticlLivr = new  SimpleStringProperty(descArticlLivr);
		this.qteLivr = new SimpleStringProperty(qteLivr);
		this.prixUniArtLivr = new SimpleStringProperty(prixUniArtLivr);
		this.dateComLivr = new SimpleStringProperty(dateComLivr);
		this.dateLivr = new SimpleStringProperty(dateLivr);
	}
	
	// Getters
	
	public StringProperty getNomClientLivr() {
		return nomClientLivr;
	}
	public StringProperty getDescArticlLivr() {
		return descArticlLivr;
	}
	public StringProperty getQteLivr() {
		return qteLivr;
	}
	public StringProperty getPrixUniArtLivr() {
		return prixUniArtLivr;
	}
	public StringProperty getDateComLivr() {
		return dateComLivr;
	}
	public StringProperty getDateLivr() {
		return dateLivr;
	}
	
	// setters
	
	public void setNomClientLivr(String value) {
		nomClientLivr.set(value);
	}
	
	public void setDescArticlLivr(String value) {
		descArticlLivr.set(value);
	}
	
	public void setQteLivr(String value) {
		qteLivr.set(value);
	}
	
	public void setPrixUniArtLivr(String value) {
		prixUniArtLivr.set(value);
	}
	
	public void setDateComLivr(String value) {
		dateComLivr.set(value);
	}
	
	public void setDateLivr(String value) {
		dateLivr.set(value);
	}
	
	
	public StringProperty nomClientLivrProperty() {return nomClientLivr;}
	public StringProperty descArticlLivrProperty() {return descArticlLivr;}
	public StringProperty qteLivrProperty() {return qteLivr;}
	public StringProperty prixUniArtLivrProperty() {return prixUniArtLivr;}
	public StringProperty dateComLivrProperty() {return dateComLivr;}
	public StringProperty dateLivrProperty() {return dateLivr;}
	
}
