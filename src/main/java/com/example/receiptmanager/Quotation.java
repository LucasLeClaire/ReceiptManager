package com.example.receiptmanager;

public class Quotation {
    private String nameCompany; //TODO list companies
    private String title;
    private String details;
    private int price; //en centimes, pour éviter des storer après des conversions par sécu, et ne convertir que les affichages si besoin avec convertisseurs
    private Boolean signCompany;
    private Boolean signIntern;

    public Quotation(String nameCompany, String title, String details, int price, Boolean signCompany, Boolean signIntern) {
        this.nameCompany = nameCompany;
        this.title = title;
        this.details = details;
        this.price = price;
        this.signCompany = signCompany;
        this.signIntern = signIntern;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "nameCompany='" + nameCompany + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", signCompany=" + signCompany +
                ", signIntern=" + signIntern +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getSignCompany() {
        return signCompany;
    }

    public void setSignCompany(Boolean signCompany) {
        this.signCompany = signCompany;
    }

    public Boolean getSignIntern() {
        return signIntern;
    }

    public void setSignIntern(Boolean signIntern) {
        this.signIntern = signIntern;
    }
}
