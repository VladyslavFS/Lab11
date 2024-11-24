package com.example.lab11;

public class Enterprise {
    private int id;
    private String name;
    private String address;
    private String foundingDate;
    private double fund;
    private double value;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getFoundingDate() { return foundingDate; }
    public void setFoundingDate(String foundingDate) { this.foundingDate = foundingDate; }

    public double getFund() { return fund; }
    public void setFund(double fund) { this.fund = fund; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
