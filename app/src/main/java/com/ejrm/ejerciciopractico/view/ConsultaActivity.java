package com.ejrm.ejerciciopractico.view;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.AbastecimientoRepository;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.ejrm.ejerciciopractico.view.adapters.AbastecimientoAdapter;
import com.ejrm.ejerciciopractico.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ConsultaActivity extends AppCompatActivity {
    MainViewModel viewModel;
    private AbastecimientoRepository abastecimientoRepository;
    private CompositeDisposable disposables = new CompositeDisposable();
    private RecyclerView recyclerView;
    private List<AbastecimientoModel> abastecimientoModels;
    private AbastecimientoAdapter abastecimientoAdapter;
    public Tabla tabla;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_activity);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        abastecimientoAdapter = new AbastecimientoAdapter(this, abastecimientoModels);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MainViewModel.class);
        viewModel.getAbastecimiento().observe(ConsultaActivity.this, abastecimientoModels -> {
                    recyclerView.setAdapter(abastecimientoAdapter);
                    abastecimientoAdapter.getAll(abastecimientoModels);
                }
        );

    }
}
