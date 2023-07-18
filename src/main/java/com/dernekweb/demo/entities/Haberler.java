package com.dernekweb.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class Haberler extends Etkinlik {
    private String haberLinki;

    public Haberler(){
        
    }

    public String getHaberLinki() {
        return haberLinki;
    }

    public void setHaberLinki(String haberLinki) {
        this.haberLinki = haberLinki;
    }

    @Override
    public String toString() {
        return "Haberler [id=" + getId() + ", konu=" + getKonu() + ", icerik=" + getIcerik() +
                ", gecerlilikTarihi=" + getGecerlilikTarihi() + ", haberLinki=" + haberLinki + "]";
    }
}
