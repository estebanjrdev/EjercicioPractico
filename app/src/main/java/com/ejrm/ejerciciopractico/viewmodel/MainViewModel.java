package com.ejrm.ejerciciopractico.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ejrm.ejerciciopractico.data.AbastecimientoRepository;
import com.ejrm.ejerciciopractico.data.db.AbastecimientoDao;
import com.ejrm.ejerciciopractico.data.db.AbastecimientoDataBase;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class MainViewModel extends AndroidViewModel {
    //private AbastecimientoDataBase abastecimientoDataBase;
    //private AbastecimientoDao abastecimientoDao;
    private AbastecimientoRepository abastecimientoRepository;
    private LiveData<List<AbastecimientoModel>> getAll;
    public MainViewModel(@NonNull Application application) {
        super(application);
        abastecimientoRepository=new AbastecimientoRepository(application);
        getAll=abastecimientoRepository.getAll();
    }
  //  public Single<Boolean> insertPost(AbastecimientoModel abastecimientoModel) {
  //      return AbastecimientoRepository.getInstance().insert(abastecimientoDao, abastecimientoModel);
  //  }

    public LiveData<List<AbastecimientoModel>> getAbastecimiento() {
        return getAll;
    }

  //  public Single<List<AbastecimientoModel>> getLocalPosts() {
  //      return AbastecimientoRepository.getInstance().getAllLocalPosts(abastecimientoDao);
  //  }
}
