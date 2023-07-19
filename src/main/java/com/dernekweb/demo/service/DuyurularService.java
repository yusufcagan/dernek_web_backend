package com.dernekweb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dernekweb.demo.entities.Duyurular;
import com.dernekweb.demo.repository.DuyurularRepository;

@Service
public class DuyurularService {
    private final DuyurularRepository duyurularRepository;

    @Autowired
    public DuyurularService(DuyurularRepository duyurularRepository){
        this.duyurularRepository=duyurularRepository;
    }

    public List<Duyurular> getAllDuyurular(){
        return duyurularRepository.findAll();
    }

    public Optional<Duyurular> getDuyurularById(Long id){
        return duyurularRepository.findById(id);
    }

    public Duyurular createDuyurular(Duyurular duyurular){
        return duyurularRepository.save(duyurular);
    }

    public Duyurular updateDuyurular(Long id, Duyurular updatedDuyurular) {
        Optional<Duyurular> existingDuyurular = duyurularRepository.findById(id);
        if (existingDuyurular.isPresent()) {
            Duyurular duyurular = existingDuyurular.get();
            duyurular.setKonu(updatedDuyurular.getKonu());
            duyurular.setIcerik(updatedDuyurular.getIcerik());
            duyurular.setGecerlilikTarihi(updatedDuyurular.getGecerlilikTarihi());
            duyurular.setResimYolu(updatedDuyurular.getResimYolu());
            
            return duyurularRepository.save(duyurular);
        }
        return null;
    }

    public void deleteDuyurular(Long id) {
        duyurularRepository.deleteById(id);
    }
}
