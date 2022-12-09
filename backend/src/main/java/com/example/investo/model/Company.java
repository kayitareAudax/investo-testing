package com.example.investo.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long shareValue;
    private int myShares;
    @Transient
    private long myAmount;
    private long myPercentage;
    private int companyTotalFunds;

    public Company() {
    }

    public Company(String name, long shareValue, int myShares, int companyTotalFunds) {
        this.name = name;
        this.shareValue = shareValue;
        this.myShares = myShares;
        this.companyTotalFunds = companyTotalFunds;
    }

    public Company(long id, String name, long shareValue, int myShares, int companyTotalFunds) {
        this.id = id;
        this.name = name;
        this.shareValue = shareValue;
        this.myShares = myShares;
        this.companyTotalFunds = companyTotalFunds;
    }

    public int getCompanyTotalFunds() {
        return companyTotalFunds;
    }

    public void setCompanyTotalFunds(int companyTotalFunds) {
        this.companyTotalFunds = companyTotalFunds;
    }

    public long getMyPercentage() {
        return shareValue * myShares * 100 / companyTotalFunds;
    }

    public void setMyPercentage(long myPercentage) {
        this.myPercentage = myPercentage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getShareValue() {
        return shareValue;
    }

    public void setShareValue(long shareValue) {
        this.shareValue = shareValue;
    }

    public int getMyShares() {
        return myShares;
    }

    public void setMyShares(int myShares) {
        this.myShares = myShares;
    }

    public long getMyAmount() {
        return myShares * shareValue;
    }

    public void setMyAmount(long myAmount) {
        this.myAmount = myAmount;
    }
}