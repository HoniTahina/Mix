package com.app.mixer.repo;

import com.app.mixer.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiandRepo extends JpaRepository<Etudiant, Long> {

    Optional<Etudiant> findEtudiantById(Long id);

    void deleteEtudiantById(Long id);
}
