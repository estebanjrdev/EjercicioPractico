package com.ejrm.ejerciciopractico.data.network;

import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("Sanit_abastecimiento")
    private List<AbastecimientoModel> sanitAbastecimientoList;

    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    public List<AbastecimientoModel> getSanitAbastecimientoList() {
        return sanitAbastecimientoList;
    }

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
