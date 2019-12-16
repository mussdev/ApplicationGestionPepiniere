package org.mussdev.gestionJavafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	private final StringProperty idClt;
	private final StringProperty nomClient;
	private final StringProperty noTelephone;
	
	
	public Client(String idClt, String nomClient, String noTelephone) {
		this.idClt = new SimpleStringProperty(idClt);
		this.nomClient = new SimpleStringProperty(nomClient);
		this.noTelephone = new SimpleStringProperty(noTelephone);
	}
	
	
	// getters
	public StringProperty getIdClt() {
		return idClt;
	}
	
	public StringProperty getNomClient() {
		return nomClient;
	}
	public StringProperty getNoTelephone() {
		return noTelephone;
	}
	
	// setters
	public void setIdClt(String value) {
		idClt.set(value);
	}
	
	public void setNomClient(String value) {
		nomClient.set(value);
	}
	
	public void setNoTelephone(String value) {
		noTelephone.set(value);
	}
	
	public StringProperty idCltProperty() {return idClt;}
	public StringProperty nomClientProperty() {return nomClient;}
	public StringProperty noTelephoneProperty() {return noTelephone;}
	
	
}
