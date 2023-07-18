package com.dernekweb.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class Duyurular extends Etkinlik {

    private String resim;

    public Duyurular(){
        
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    @Override
    public String toString() {
        return "Duyurular{" +
                "id=" + getId() +
                ", konu='" + getKonu() + '\'' +
                ", icerik='" + getIcerik() + '\'' +
                ", gecerlilikTarihi=" + getGecerlilikTarihi() +
                ", resim='" + resim + '\'' +
                '}';
    }
}
