package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginModel {

    @JsonProperty("username")
    @SerializedName("username")
    private String username;

    @JsonProperty("identification_document")
    @SerializedName("identification_document")
    private String identificationDocument;

    @JsonProperty("lastname")
    @SerializedName("lastname")
    private String lastname;

    @JsonProperty("name")
    @SerializedName("name")
    private String name;

    @JsonProperty("email")
    @SerializedName("email")
    private String email;

    @JsonProperty("dependency")
    @SerializedName("dependency")
    private String dependency;

    @JsonProperty("session_time")
    @SerializedName("session_time")
    private Integer sessionTime;

    @JsonProperty("session_id")
    @SerializedName("session_id")
    private String sessionId;

    @JsonProperty("system")
    @SerializedName("system")
    private String system;

}
