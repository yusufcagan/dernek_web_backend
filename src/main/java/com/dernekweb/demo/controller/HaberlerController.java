package com.dernekweb.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dernekweb.demo.entities.Haberler;
import com.dernekweb.demo.service.HaberlerService;

@RequestMapping("/api/haberler")
public class HaberlerController {
    
    private HaberlerService haberlerService;

    @GetMapping
    public ResponseEntity<List<Haberler>> getAllHaberler() {
        List<Haberler> haberler = haberlerService.getAllHaberler();
        return ResponseEntity.ok(haberler);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Haberler> getHaberlerById(@PathVariable Long id) {
        Optional<Haberler> haber = haberlerService.getHaberlerById(id);
        if (haber.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(haber.get());
    }

    @PostMapping
    public ResponseEntity<Haberler> createHaberler(@RequestBody Haberler haber) {
        Haberler createdHaber = haberlerService.createHaberler(haber);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHaber);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Haberler> updateHaberler(@PathVariable Long id, @RequestBody Haberler haber) {
        Haberler updatedHaber = haberlerService.updateHaberler(id, haber);
        if (updatedHaber == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedHaber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHaberler(@PathVariable Long id) {
        haberlerService.deleteHaberler(id);
        return ResponseEntity.noContent().build();
    }

}
