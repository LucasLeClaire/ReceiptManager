module com.example.receiptmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires annotations;
    requires pdfbox.app;

    opens com.example.receiptmanager to javafx.fxml;
    exports com.example.receiptmanager;
}