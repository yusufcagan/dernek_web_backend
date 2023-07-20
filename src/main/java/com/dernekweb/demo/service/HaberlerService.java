package com.dernekweb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dernekweb.demo.entities.Haberler;
import com.dernekweb.demo.repository.HaberlerRepository;

@Service
public class HaberlerService {
    private final HaberlerRepository haberlerRepository;

    public HaberlerService(HaberlerRepository haberlerRepository){
        this.haberlerRepository=haberlerRepository;
    }

    public List<Haberler> getAllHaberler(){
        return haberlerRepository.findAll();
    }

    public Optional<Haberler> getHaberlerById(Long id){
        return haberlerRepository.findById(id);
    }

    public Haberler createHaberler(Haberler haberler){
        return haberlerRepository.save(haberler);
    }

    public Haberler updateHaberler(Long id, Haberler updatedHaberler) {
        Optional<Haberler> existingHaberler = haberlerRepository.findById(id);
        if (existingHaberler.isPresent()) {
            Haberler haberler = existingHaberler.get();
            haberler.setKonu(updatedHaberler.getKonu());
            haberler.setIcerik(updatedHaberler.getIcerik());
            haberler.setGecerlilikTarihi(updatedHaberler.getGecerlilikTarihi());
            haberler.setHaberLinki(updatedHaberler.getHaberLinki());
            
            return haberlerRepository.save(haberler);
        }
        return null;
    }

    public void deleteHaberler(Long id) {
        haberlerRepository.deleteById(id);
    }
}
