package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LivraisonSoldClient {
	private final StringProperty nomClientLivr;
	/*
	 * private final StringProperty descArticlLivr; private final StringProperty
	 * qteLivr; private final StringProperty prixUniArtLivr;
	 */
	private final StringProperty soldeclient;
	
	// Constructeur avec parametres
	
	public LivraisonSoldClient(String nomClientLivr, String soldeclient) {
		this.nomClientLivr = new SimpleStringProperty(nomClientLivr);
		/*
		 * this.descArticlLivr = new SimpleStringProperty(descArticlLivr); this.qteLivr
		 * = new SimpleStringProperty(qteLivr); this.prixUniArtLivr = new
		 * SimpleStringProperty(prixUniArtLivr);
		 */
		this.soldeclient = new SimpleStringProperty(soldeclient);
	}
	
	// Getters
	
	public StringProperty getNomClientLivr() {
		return nomClientLivr;
	}

	/*
	 * public StringProperty getDescArticlLivr() { return descArticlLivr; } public
	 * StringProperty getQteLivr() { return qteLivr; } public StringProperty
	 * getPrixUniArtLivr() { return prixUniArtLivr; }
	 */
	public StringProperty getSoldeclient() {
		return soldeclient;
	}
	
	// setters
	
	public void setNomClientLivr(String value) {
		nomClientLivr.set(value);
	}
	
	/*
	 * public void setDescArticlLivr(String value) { descArticlLivr.set(value); }
	 * 
	 * public void setQteLivr(String value) { qteLivr.set(value); }
	 * 
	 * public void setPrixUniArtLivr(String value) { prixUniArtLivr.set(value); }
	 */
	
	public void setSoldeclient(String value) {
		soldeclient.set(value);
	}
	
	
	public StringProperty nomClientLivrProperty() {return nomClientLivr;}

	/*
	 * public StringProperty descArticlLivrProperty() {return descArticlLivr;}
	 * public StringProperty qteLivrProperty() {return qteLivr;} public
	 * StringProperty prixUniArtLivrProperty() {return prixUniArtLivr;}
	 */
	public StringProperty soldeclientProperty() {return soldeclient;}
}
