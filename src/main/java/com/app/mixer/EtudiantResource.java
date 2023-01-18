package com.app.mixer;

import com.app.mixer.model.Etudiant;
import com.app.mixer.service.EtudiantService;
import jdk.jshell.PersistentSnippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantResource {
    private final EtudiantService etudiantService;

    public EtudiantResource(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllEtudiants(){
        List<Etudiant> etudiants = etudiantService.findAllEtudiant();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") Long id){
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant newetudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(newetudiant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
        Etudiant updateEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updateEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Long id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
