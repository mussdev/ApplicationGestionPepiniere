module org.mussdev.gestionJavafx {
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.media;
	requires javafx.swing;
	/* requires javafx.swt; */
	requires javafx.web;
	requires java.sql;
	exports org.mussdev.gestionJavafx.view;
	exports org.mussdev.gestionJavafx.model;
	exports org.mussdev.gestionJavafx;
}