package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.util;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author vinsfran
 */
@Data
public class TicketModel implements Serializable {

    private Integer numero;
    private String letra;
    private String dependenciaNombre;

}
