module I.P.T.D {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires eclipselink;
	requires jakarta.persistence;
	requires org.apache.derby.engine;
	
	opens model to eclipselink;
	opens controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
