package com.dernekweb.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class Duyurular extends Etkinlik {

    private String resimYolu;

    public Duyurular(){
        
    }

    public String getResimYolu() {
        return resimYolu;
    }

    public void setResimYolu(String resimYolu) {
        this.resimYolu = resimYolu;
    }

    @Override
    public String toString() {
        return "Duyurular{" +
                "id=" + getId() +
                ", konu='" + getKonu() + '\'' +
                ", icerik='" + getIcerik() + '\'' +
                ", gecerlilikTarihi=" + getGecerlilikTarihi() +
                ", resimYolu='" + resimYolu + '\'' +
                '}';
    }
}
