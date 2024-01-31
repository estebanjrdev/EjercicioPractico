package com.ejrm.ejerciciopractico.data.network;


import io.reactivex.Single;
import retrofit2.http.GET;

public interface AbastecimientoApi {
    @GET("catalogos/Sanit_abastecimiento")
    Single<ApiResponse> getAbastecimiento();

}
