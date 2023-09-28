package com.example.receiptmanager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Popup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HelloController {
    @FXML
    private DatePicker QDate;
    @FXML
    private TextField QPrice;
    @FXML
    private Button QCreate;
    @FXML
    private Button ECreate;
    @FXML
    private TextField ECompany;
    @FXML
    private TextField EAddress;
    @FXML
    private TextField EContact;
    @FXML
    private TextField RCompany;
    @FXML
    private TextField RTitle;
    @FXML
    private TextField RDetails;
    @FXML
    private CheckBox RSignCompany;
    @FXML
    private CheckBox RSignIntern;
    @FXML
    private TextField RServices;
    @FXML
    private Label welcomeText;

    @FXML
    private TextField QCompany;
    @FXML
    private TextField QTitle;
    @FXML
    private TextField QDetails;
    @FXML
    private CheckBox QSignCompany;
    @FXML
    private CheckBox QSignIntern;

    protected Company createCompany(String name, String address, String contact) {
        return new Company(name,address,contact);
    }

    protected Quotation createQuotation(String name, String title, String details, int price, Boolean signCompany, Boolean signIntern){

        Map<String, String> data = new HashMap<>();
        data.put("QCompany",QCompany.getText());
        data.put("QTitle",QTitle.getText());
        data.put("QDetails",QDetails.getText());
        data.put("QSignCompany", String.valueOf(QSignCompany.isSelected()));
        data.put("QSignIntern", String.valueOf(QSignIntern.isSelected()));
        data.put("QPrice", String.valueOf(Integer.parseInt(QPrice.getText())));

        PDFHelper pdf = new PDFHelper(data);
        pdf.create();
        return new Quotation(name,title,details,price,signCompany,signIntern);
    }

    protected Receipt createReceipt(Quotation quotation){
        Receipt receipt = new Receipt(quotation.getNameCompany(), quotation.getTitle(), quotation.getDetails(), quotation.getPrice(),quotation.getSignCompany(),quotation.getSignIntern());
        System.out.println(receipt);
        return receipt;
    }

    @FXML
    protected void initialize() throws InterruptedException {
        List<Company> Companies = new ArrayList<>();
        List<Quotation> Quotations = new ArrayList<>();
        List<Receipt> Receipts = new ArrayList<>();

        Label popupLabel = new Label("This is a popup with text.");
        Popup popup = new Popup();
        popup.getContent().addAll(popupLabel);

        ECreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Company company = createCompany(ECompany.getText(),EAddress.getText(),EContact.getText());
                Companies.add(company);


                Stream.of(Companies) //debug
                        .forEach(System.out::println);

            }
        });
        QCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Quotation quotation = createQuotation(QCompany.getText(),QTitle.getText(),QDetails.getText(), Integer.parseInt(QPrice.getText()),QSignCompany.isSelected(),QSignIntern.isSelected());
                Quotations.add(quotation);

                Receipt receipt = createReceipt(quotation);
                Receipts.add(receipt);

                Stream.of(Quotations) //debug
                        .forEach(System.out::println);

                System.out.println("__");

                Stream.of(Receipts)
                        .forEach(System.out::println);

            }
        });
    }
}