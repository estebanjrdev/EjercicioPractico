package com.ejrm.ejerciciopractico.data;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ejrm.ejerciciopractico.data.db.AbastecimientoDao;
import com.ejrm.ejerciciopractico.data.db.AbastecimientoDataBase;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.ejrm.ejerciciopractico.data.network.AbastecimientoApi;
import com.ejrm.ejerciciopractico.data.network.RetrofitClient;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbastecimientoRepository {
   // public static AbastecimientoRepository abastecimientoRepository;
    AbastecimientoApi abastecimientoApi;

    public AbastecimientoRepository(Application application)
    {
        abastecimientoApi = RetrofitClient.getClient().create(AbastecimientoApi.class);
    }

   /* public static AbastecimientoRepository getInstance() {

        if (abastecimientoRepository == null) {
            abastecimientoRepository = new AbastecimientoRepository();
        }
        return abastecimientoRepository;
    }*/



    @SuppressLint("CheckResult")
    public LiveData<List<AbastecimientoModel>> getAll() {

        MutableLiveData<List<AbastecimientoModel>> abastecimiento = new MutableLiveData<>();
      /*  abastecimientoApi.getAbastecimiento().enqueue(new Callback<List<AbastecimientoModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<AbastecimientoModel>> call, Response<List<AbastecimientoModel>> response) {
              if(response.isSuccessful()){
                  abastecimiento.postValue(response.body());
              }

            }

            @Override
            public void onFailure(@NonNull Call<List<AbastecimientoModel>> call, Throwable t) {
                t.printStackTrace();
                abastecimiento.setValue(null);
            }
        });*/

//

       // abastecimientoApi.getAbastecimiento().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(abastecimiento::setValue);
        abastecimientoApi.getAbastecimiento()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(post -> {
           abastecimiento.setValue(post);
        });

        return abastecimiento;
    }
}
