package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.repo;

import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRep extends JpaRepository<Persona, String> {

    Persona findByCi(String ci);
}
