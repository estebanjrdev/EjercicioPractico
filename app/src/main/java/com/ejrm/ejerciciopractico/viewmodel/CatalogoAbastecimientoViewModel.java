package com.ejrm.ejerciciopractico.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoDao;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoEntity;
import com.ejrm.ejerciciopractico.data.model.CatalogoAbastecimiento;

import java.util.List;

public class CatalogoAbastecimientoViewModel extends ViewModel {
    private CatalogoAbastecimientoDao catalogoAbastecimientoDao;
    private LiveData<List<CatalogoAbastecimientoEntity>> catalogoAbastecimientos;

    public CatalogoAbastecimientoViewModel() {
       // catalogoAbastecimientoDao = MyApp.database.catalogoAbastecimientoDao();
        catalogoAbastecimientos = (LiveData<List<CatalogoAbastecimientoEntity>>) catalogoAbastecimientoDao.getAllCatalogoAbastecimientos();

    }

    public LiveData<List<CatalogoAbastecimientoEntity>> getCatalogoAbastecimientos() {
        return catalogoAbastecimientos;
    }

    public void insertCatalogoAbastecimiento(CatalogoAbastecimientoEntity catalogoAbastecimiento) {
            catalogoAbastecimientoDao.insert(catalogoAbastecimiento);
    }
}
