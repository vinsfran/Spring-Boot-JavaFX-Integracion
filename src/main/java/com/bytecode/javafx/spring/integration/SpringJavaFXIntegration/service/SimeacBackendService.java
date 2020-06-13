package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.service;


import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.LoginResponse;

/**
 * @author vinsfran
 */
public interface SimeacBackendService {

    LoginResponse login(String usuario, String password) throws Exception;
}
