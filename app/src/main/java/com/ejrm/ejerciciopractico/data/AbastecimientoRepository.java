package com.ejrm.ejerciciopractico.data;


import android.app.Application;

import com.ejrm.ejerciciopractico.data.network.AbastecimientoApi;
import com.ejrm.ejerciciopractico.data.network.ApiResponse;
import com.ejrm.ejerciciopractico.data.network.RetrofitClient;

import io.reactivex.Single;

public class AbastecimientoRepository {
    private AbastecimientoApi abastecimientoApi;
    public static AbastecimientoRepository abastecimientoRepository;
    public AbastecimientoRepository(Application application)
    {
        abastecimientoApi = RetrofitClient.getClient().create(AbastecimientoApi.class);
    }
    /*public static AbastecimientoRepository getInstance() {

        if (abastecimientoRepository == null) {
            abastecimientoRepository = new AbastecimientoRepository();
        }
        return abastecimientoRepository;
    }*/
    public Single<ApiResponse> getAll() {
        return  abastecimientoApi.getAbastecimiento();
    }
}
