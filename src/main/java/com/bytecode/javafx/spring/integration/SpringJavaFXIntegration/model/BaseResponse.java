package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("timestamp")
    @SerializedName("timestamp")
    private Timestamp timestamp;

    @JsonProperty("status")
    @SerializedName("status")
    private Integer status;

    @JsonProperty("message")
    @SerializedName("message")
    private MessageResponse message;

    public BaseResponse(Integer status, MessageResponse message) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = status;
        this.message = message;
    }

}

