package com.dernekweb.demo.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dernekweb.demo.entities.Duyurular;
import com.dernekweb.demo.service.DuyurularService;


@RestController
@RequestMapping("/api/duyurular")
public class DuyurularController {
    
    private final DuyurularService duyurularService;

    public DuyurularController(DuyurularService duyurularService) {
        this.duyurularService=duyurularService;
    }

    @GetMapping
    public ResponseEntity<List<Duyurular>> getAllDuyurular() {
        List<Duyurular> duyurular = duyurularService.getAllDuyurular();
        return ResponseEntity.ok(duyurular);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duyurular> getDuyurularById(@PathVariable Long id) {
        Optional<Duyurular> duyuru = duyurularService.getDuyurularById(id);
        if (duyuru.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(duyuru.get());
    }

    @PostMapping
    public ResponseEntity<Duyurular> createDuyurular(@RequestBody Duyurular duyuru) {
        Duyurular createdDuyuru = duyurularService.createDuyurular(duyuru);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDuyuru);
    }

    @PostMapping("/resim-yukle")
public ResponseEntity<String> yukleResim(@RequestParam("resim") MultipartFile resim) {
    try {
        if (!resim.isEmpty()) {
            String projeDizini = System.getProperty("user.dir");
            String resimYolu = projeDizini + File.separator + "uploads" + File.separator + resim.getOriginalFilename();
            File file = new File(resimYolu);
            resim.transferTo(file);
            return ResponseEntity.ok(resimYolu);
        } else {
            return ResponseEntity.badRequest().body("Resim boş olamaz.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resim yüklenirken bir hata oluştu.");
    }
}

    @PutMapping("/{id}")
    public ResponseEntity<Duyurular> updateDuyurular(@PathVariable Long id, @RequestBody Duyurular duyuru) {
        Duyurular updatedDuyuru = duyurularService.updateDuyurular(id, duyuru);
        if (updatedDuyuru == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDuyuru);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDuyurular(@PathVariable Long id) {
        duyurularService.deleteDuyurular(id);
        return ResponseEntity.noContent().build();
    }

}
