package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageModel {

    @JsonProperty("level")
    @SerializedName("level")
    private String level;

    @JsonProperty("description")
    @SerializedName("description")
    private String description;

    public MessageModel(String level, String description) {
        this.level = level;
        this.description = description;
    }
}
