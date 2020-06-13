package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponse {

    @JsonProperty("code")
    @SerializedName("code")
    private String code;

    @JsonProperty("messages")
    @SerializedName("messages")
    private List<MessageModel> messages;

    public MessageResponse(String code, List<MessageModel> messages) {
        this.code = code;
        this.messages = messages;
    }
}
