package com.example.dairyapp.view;

import java.sql.Date;
//Tanggal Pengerjaan : 02 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class Diary {
     private long ID;
     private String judul;
     private String isi;
     private String date;
     private String time;

     public Diary(){}
     Diary(String judul, String isi, String date, String time){
         this.judul =   judul;
         this.isi   =   isi;
         this.date  =   date;
         this.time  =   time;
     }

    public Diary(long ID, String judul, String isi, String date, String time){
         this.ID    =   ID;
         this.judul =   judul;
        this.isi   =   isi;
        this.date  =   date;
        this.time  =   time;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
