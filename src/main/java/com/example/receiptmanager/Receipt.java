package com.example.receiptmanager;

import java.time.LocalDate;
import java.util.Date;

public class Receipt extends Quotation{

    private Boolean paid;
    private final LocalDate date;

    public Receipt(String nameCompany, String title, String details, int price, Boolean signCompany, Boolean signIntern) {
        super(nameCompany, title, details, price, signCompany, signIntern);
        this.paid = false;
        this.date = LocalDate.now();;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
