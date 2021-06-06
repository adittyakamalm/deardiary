package com.example.dairyapp.model;
//Tanggal Pengerjaan : 02 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class Diary implements iDiary {
    private long ID;
    private String judul;
    private String isi;
    private String date;
    private String time;


    Diary(){}
    Diary(String judul, String isi, String date, String time){
        this.judul =   judul;
        this.isi   =   isi;
        this.date  =   date;
        this.time  =   time;
    }

    Diary(long ID, String judul, String isi, String date, String time){
        this.ID    =   ID;
        this.judul =   judul;
        this.isi   =   isi;
        this.date  =   date;
        this.time  =   time;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getJudul() {
        return null;
    }

    @Override
    public String getIsi() {
        return null;
    }

    @Override
    public String getDate() {
        return null;
    }

    @Override
    public String getTime() {
        return null;
    }

    @Override
    public String setID() {
        return null;
    }

    @Override
    public String setJudul() {
        return null;
    }

    @Override
    public String setIsi() {
        return null;
    }

    @Override
    public String setDate() {
        return null;
    }

    @Override
    public String setTime() {
        return null;
    }
}
