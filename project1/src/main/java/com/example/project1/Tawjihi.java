package com.example.project1;

public class Tawjihi implements Comparable<Tawjihi>{
    private String branch;
    private double avg;
    private long seatNumber;

    Tawjihi() {

    }

    Tawjihi (long s,String b,double a){
        branch=b;
        avg=a;
        seatNumber=s;
    }


    public long getSeatNumber() {
        return seatNumber;
    }

    public double getAvg() {
        return avg;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "{" +
                "seatNumber=" + seatNumber +
                ", branch='" + branch + '\'' +
                ", avg=" + avg +

                "}\n";
    }

    @Override
    public int compareTo(Tawjihi o) {
       if(this.avg>o.avg)return -1;
       else if (this.avg<o.avg)return 1;
       else return 0;
    }
}
