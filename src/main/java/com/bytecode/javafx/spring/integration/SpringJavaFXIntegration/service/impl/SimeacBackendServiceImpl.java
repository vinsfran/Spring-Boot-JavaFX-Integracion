package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.service.impl;

import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.BaseResponse;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.LoginResponse;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.service.SimeacBackendService;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinsfran
 */
@Service("simeacBackendServiceImpl")
public class SimeacBackendServiceImpl implements SimeacBackendService {

    private static final Log LOG = LogFactory.getLog(SimeacBackendServiceImpl.class);

    @Value("${app.url.base.simeac-backend}")
    private String urlBaseSimeacBackend;

    @Override
    public LoginResponse login(String usuario, String password) throws Exception {
        LoginResponse baseResponse = null;
        Gson gson = new Gson();
        HttpResponse<JsonNode> response;
        try {
            Map<String, String> loginData = new HashMap<>();
            loginData.put("username", usuario);
            loginData.put("password", password);
            LOG.info("login: " + loginData.toString());
            response = Unirest.post(urlBaseSimeacBackend + "auth/login")
                    .header("Content-Type", "application/json")
                    .header("system", "sirec")
                    .body(gson.toJson(loginData))
                    .asJson();
            if (response.getStatus() == 200) {
                baseResponse = gson.fromJson(response.getBody().toString(), LoginResponse.class);
            } else {
                throw new Exception("SimeacBackendService authorized code: " + response.getStatus());
            }
        } catch (UnirestException ex) {
            throw new Exception("SimeacBackendService authorized: " + ex.getMessage());
        }
        return baseResponse;
    }

}
