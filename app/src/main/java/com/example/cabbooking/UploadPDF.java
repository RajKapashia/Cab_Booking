package com.example.cabbooking;

public class UploadPDF {
  public String place;
    public String placet;

    public String dest;
    public String destt;
    public String bill;
    public String currencys;
    public UploadPDF() {
    }

    public UploadPDF(String place, String placet, String dest, String destt, String bill,String currencys) {
        this.place=place;
        this.placet=placet;

        this.dest=dest;
        this.destt=destt;
        this.bill=bill;
        this.currencys=currencys;
    }

    public String getPlace() {
        return place;
    }

    public String getPlacet() {
        return placet;
    }

    public String getDest() {
        return dest;
    }
    public String getDestt() {
        return destt;
    }

    public String getBill() {
        return bill;
    }
    public void setPlace(String from)
    {
        this.place=from;
    }

    public void setPlacet(String fromt)
    {
       this.placet=fromt;
    }

    public void setDest(String to)
    {
        this.dest=to;
    }
    public void setDestt(String to_time)
    {
       this.destt=to_time;
    }

    public void setBill(String value) {
        this.bill=value;
    }

    public void setCurrency(String currency) {
        this.currencys=currency;
    }



}
