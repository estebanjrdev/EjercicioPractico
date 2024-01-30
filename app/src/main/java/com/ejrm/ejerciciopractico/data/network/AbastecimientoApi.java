package com.ejrm.ejerciciopractico.data.network;

import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AbastecimientoApi {
    @GET("/Sanit_abastecimiento/")
    Observable<List<AbastecimientoModel>> getAbastecimiento();

}
