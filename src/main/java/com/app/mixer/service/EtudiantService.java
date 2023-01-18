package com.app.mixer.service;

import com.app.mixer.exeption.UserNotFound;
import com.app.mixer.model.Etudiant;
import com.app.mixer.repo.EtudiandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private final EtudiandRepo  etudiantRepo;
    @Autowired
    public EtudiantService(EtudiandRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    }

    public List<Etudiant> findAllEtudiant(){
        return etudiantRepo.findAll();
    }

    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    }

    public Etudiant findEtudiantById(Long id){
        return etudiantRepo.findEtudiantById(id).orElseThrow(() -> new UserNotFound("User qui a l'id " + id + "n'existe pas"));
    }

    public void deleteEtudiant(Long id){
        etudiantRepo.deleteEtudiantById(id);
    }


}
