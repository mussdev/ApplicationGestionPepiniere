package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ArticleVendu {
	private final StringProperty nomArticle;
	private final StringProperty qteVendu;
	
	// Constructeur avec parametres
	
	public ArticleVendu(String nomArticle, String qteVendu) {
		this.nomArticle = new SimpleStringProperty(nomArticle);
		this.qteVendu = new SimpleStringProperty(qteVendu);
	}
	
	// Getters
	
	public StringProperty getNomArticle() {
		return nomArticle;
	}
	public StringProperty getQteVendu() {
		return qteVendu;
	}
	
	// setters
	
	public void setNomArticle(String value) {
		nomArticle.set(value);
	}
	
	
	public void setQteVendu(String value) {
		qteVendu.set(value);
	}
	
	
	public StringProperty nomArticleProperty() {return nomArticle;}
	public StringProperty qteVenduProperty() {return qteVendu;}
}
