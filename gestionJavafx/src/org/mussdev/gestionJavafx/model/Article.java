package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Article {
	private final StringProperty noArtcl;
	private final StringProperty description;
	private final StringProperty prixUnitaire;
	private final StringProperty quantiteEnStock;
	
	
	public Article(String noArtcl, String description, String  prixUnitaire, String quantiteEnStock) {
		this.noArtcl = new SimpleStringProperty(noArtcl);
		this.description = new SimpleStringProperty(description);
		this.prixUnitaire = new SimpleStringProperty(prixUnitaire);
		this.quantiteEnStock = new SimpleStringProperty(quantiteEnStock);
	}
	
	public StringProperty getNoArtcl() {
		return noArtcl;
	}
	public StringProperty getDescription() {
		return description;
	}
	public StringProperty getPrixUnitaire() {
		return prixUnitaire;
	}
	public StringProperty getQuantiteEnStock() {
		return quantiteEnStock;
	}
	
	// Setters
	public void setNoArtcl(String value) {
		description.set(value);
	}
	
	public void setDescription(String value) {
		description.set(value);
	}
	
	public void setPrixUnitaire(String value) {
		prixUnitaire.set(value);
	}
	
	public void setQuantiteEnStock(String value) {
		quantiteEnStock.set(value);
	}
	
	// Property value
	public StringProperty noArtclProperty() {return noArtcl;}
	public StringProperty descriptionProperty() {return description;}
	public StringProperty prixUnitaireProperty() {return prixUnitaire;}
	public StringProperty quantiteEnStockProperty() {return quantiteEnStock;}
	
	
	
	
}
