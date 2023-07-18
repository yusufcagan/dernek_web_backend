package com.dernekweb.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etkinlik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String konu;
    private String icerik;
    private String gecerlilikTarihi;

    public Etkinlik() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getGecerlilikTarihi() {
        return gecerlilikTarihi;
    }

    public void setGecerlilikTarihi(String gecerlilikTarihi) {
        this.gecerlilikTarihi = gecerlilikTarihi;
    }

    @Override
    public String toString() {
        return "Etkinlik{" +
                "id=" + id +
                ", konu='" + konu + '\'' +
                ", icerik='" + icerik + '\'' +
                ", gecerlilikTarihi='" + gecerlilikTarihi + '\'' +
                '}';
    }
}
