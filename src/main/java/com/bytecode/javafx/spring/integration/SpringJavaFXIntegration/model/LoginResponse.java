package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginResponse extends BaseResponse {

    @JsonProperty("data")
    @SerializedName("data")
    private LoginModel loginModel;

    public LoginResponse(Integer status, MessageResponse message, LoginModel loginModel) {
        super(status, message);
        this.loginModel = loginModel;
    }

}
