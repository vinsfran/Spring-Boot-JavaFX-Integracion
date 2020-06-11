package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona", uniqueConstraints={@UniqueConstraint(columnNames={"ci"})})
@Data
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ci;
    private String nombre;
    private String apellido;
    private Integer edad;
}
