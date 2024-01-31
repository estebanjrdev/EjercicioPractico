package com.ejrm.ejerciciopractico.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.db.AppDatabase;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoDao;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoEntity;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.ejrm.ejerciciopractico.view.adapters.AbastecimientoAdapter;
import com.ejrm.ejerciciopractico.view.adapters.CatalogoAdapter;

import java.util.List;

public class VerCatalogos extends AppCompatActivity {
    private CatalogoAbastecimientoDao catalogoAbastecimientoDao;
    private RecyclerView recyclerView;
    private List<CatalogoAbastecimientoEntity> catalogoAbastecimientoEntities;
    private CatalogoAdapter catalogoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_catalogos);
        recyclerView=findViewById(R.id.recyclercatalogo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AppDatabase database = AppDatabase.getInstance(getApplication());
        catalogoAbastecimientoDao = database.catalogoAbastecimientoDao();
        catalogoAbastecimientoEntities=catalogoAbastecimientoDao.getAllCatalogoAbastecimientos();
        catalogoAdapter=new CatalogoAdapter(this,catalogoAbastecimientoEntities);
        recyclerView.setAdapter(catalogoAdapter);
    }
}
