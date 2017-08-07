package com.example.syauqi.myapplication;

/**
 * Created by syauqi on 07/08/17.
 */

public class ProductController {
    private String isi;

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String toString(){
        return (getIsi());
    }
}
