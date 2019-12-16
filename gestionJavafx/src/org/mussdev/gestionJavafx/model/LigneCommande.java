package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LigneCommande {
	private final StringProperty noCommande;
	private final StringProperty noArticle;
	private final StringProperty quantite;
	
	
	public LigneCommande(String noCommande, String noArticle, String quantite) {
		this.noCommande = new SimpleStringProperty(noCommande);
		this.noArticle = new SimpleStringProperty(noArticle);
		this.quantite = new SimpleStringProperty(quantite);
	}
	
	
	// getters
	public StringProperty getNoCommande() {
		return noCommande;
	}
	
	public StringProperty getNoArticle() {
		return noArticle;
	}
	public StringProperty getQuantite() {
		return quantite;
	}
	
	// setters
	public void setNoCommande(String value) {
		noCommande.set(value);
	}
	
	public void setNoArticle(String value) {
		noArticle.set(value);
	}
	
	public void setQuantite(String value) {
		quantite.set(value);
	}
	
	public StringProperty noCommandeProperty() {return noCommande;}
	public StringProperty noArticleProperty() {return noArticle;}
	public StringProperty quantiteProperty() {return quantite;}
	
	
}
