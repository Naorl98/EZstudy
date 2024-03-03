package com.example.myezstudy;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Meeting implements Comparable<Meeting>{

    private  String partnerUsername;
    private User partner;
    private String day;
    private String month;
    private String year;
    private String startHour;
    private String endHour;
    private int price;
    private String Available;
    public Meeting(){}
    public Meeting(String day ,String month, String year, String startHour, String endHour, int price) {
        this.partner = null;
        this.day = day;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.endHour = endHour;
        this.price = price;
        this.Available = "true";
    }
    public Meeting(User partner, String partnerUsername,String day ,String month, String year, String startHour, String endHour, int price) {
        this.partner = new User(partner.getName(), partner.getAge(), partner.getPhone(),partner.getEmail());
        this.day = day;
        this.partnerUsername = partnerUsername;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.endHour = endHour;
        this.price = price;
        this.Available = "false";
    }
    public Meeting(User partner, String partnerUsername, Meeting M) {
        this.partner = new User(partner.getName(), partner.getAge(), partner.getPhone(),partner.getEmail());;
        this.day = M.getDay();
        this.partnerUsername = partnerUsername;
        this.month = M.getMonth();
        this.year = M.getYear();
        this.startHour = M.getStartHour();
        this.endHour = M.getEndHour();
        this.price = M.getPrice();
        this.Available = "false";
    }
    public int getPrice(){return price;}
    public String getPartnerUsername(){return partnerUsername;}

    public String getDay(){return day;}
    public String getMonth(){return month;}
    public String getYear(){return year;}

    public String getStartHour(){return startHour;}

    public String getEndHour(){return endHour;}


    public String printDetails() {
        if(this.ifAvailable()){
            return
                    "Available\n"+
                            "Date: " + day + "/" + month +"/" + year + "\n"
                             + "from " + startHour +
                            " to " + endHour +
                            "\nprice: " + price;
        }
        return
                "Partner: Username " + partnerUsername + "\n" + partner.toString() +
                        "Date: " + day + "/" + month +"/" + year + "\n"
                        + "from " + startHour +
                        " to " + endHour +
                        "\nprice: " + price;

    }
    public String toString() {
        if(this.ifAvailable()){
            return
                    "Available\n"+
                            "Date: " + day + "/" + month +"/" + year +
                            " from " + startHour +
                            " to " + endHour;
        }
        return
                "Partner: " + partner.getName() +
                        ", Date: " + day + "/" + month +"/" + year +
                        " from " + startHour +
                        " to " + endHour;

    }
    public User getPartner() {return partner;}
    public boolean CompareTo(Meeting M){
        if(this.day.equals(M.getDay()) && this.month.equals(M.getMonth())
                &&this.year.equals(M.getYear()) &&
                this.startHour.equals(M.getStartHour())
                && this.endHour.equals(M.getEndHour()))
            return true;
        return false;
    }

    public void addPartner(User partner, String partnerUsername) {
        if(!ifAvailable()) return;
        this.partnerUsername = partnerUsername;
        this.Available = "false";
        this.partner = partner;
    }
    public void CancelMetting() {
        this.Available = "true";
        this.partnerUsername = null;
        this.partner = null;
    }
    public boolean ifAvailable(){
        if(this.partner == null){
            this.Available = "true";
            return true;
        }
        this.Available = "false";
        return false;
    }
    public boolean checkIfCanCancel(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(Integer.parseInt(this.year) == cal.get(Calendar.YEAR) &&
                Integer.parseInt(this.month) == cal.get(Calendar.MONTH) + 1 &&
                Integer.parseInt(this.day) == cal.get(Calendar.DAY_OF_MONTH) &&
                (Integer.parseInt(this.startHour) - (cal.get(Calendar.HOUR_OF_DAY) + 2))
            <= 4 )
            return false;
        return true;
    }

    @Override
    public int compareTo(Meeting o) {
        if (Integer.parseInt(this.year) < Integer.parseInt(o.getYear())) return -1;
        else if (Integer.parseInt(this.year) > Integer.parseInt(o.getYear())) return 1;
        else if (Integer.parseInt(this.month) < Integer.parseInt(o.getMonth())) return -1;
        else if (Integer.parseInt(this.month) > Integer.parseInt(o.getMonth())) return 1;
        else if (Integer.parseInt(this.day) < Integer.parseInt(o.getDay())) return -1;
        else if (Integer.parseInt(this.day) > Integer.parseInt(o.getDay())) return 1;
        else if (Integer.parseInt(this.startHour)
                < Integer.parseInt(o.getStartHour())) return -1;
        else if (Integer.parseInt(this.startHour)
                > Integer.parseInt(o.getStartHour())) return 1;
        else if (Integer.parseInt(this.endHour)
                < Integer.parseInt(o.getEndHour())) return -1;
        else if (Integer.parseInt(this.endHour)
                > Integer.parseInt(o.getEndHour())) return 1;
        return 0;
    }
}
