package com.ejrm.ejerciciopractico.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ejrm.ejerciciopractico.data.AbastecimientoRepository;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    private AbastecimientoRepository abastecimientoRepository;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<List<AbastecimientoModel>> sanitAbastecimientoLiveData = new MutableLiveData<>();


    public MainViewModel(@NonNull Application application) {
        super(application);
        abastecimientoRepository = new AbastecimientoRepository(application);
        fetchSanitAbastecimiento();
    }

    public LiveData<List<AbastecimientoModel>> getAbastecimiento() {
        return sanitAbastecimientoLiveData;
    }

    private void fetchSanitAbastecimiento() {
        disposables.add(abastecimientoRepository.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        apiResponse -> sanitAbastecimientoLiveData.setValue(apiResponse.getSanitAbastecimientoList()),

                        throwable -> {

                        }
                )
        );
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }
}
