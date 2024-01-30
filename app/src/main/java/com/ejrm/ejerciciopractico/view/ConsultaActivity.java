package com.ejrm.ejerciciopractico.view;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;
import com.ejrm.ejerciciopractico.view.adapters.AbastecimientoAdapter;
import com.ejrm.ejerciciopractico.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {
    MainViewModel viewModel;
    private RecyclerView recyclerView;
    private List<AbastecimientoModel> abastecimientoModels;
    private AbastecimientoAdapter abastecimientoAdapter;
    public Tabla tabla;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_activity);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        abastecimientoModels=new ArrayList<>();
        abastecimientoAdapter=new AbastecimientoAdapter(this,abastecimientoModels);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        /*viewModel.getAbastecimiento().observe(ConsultaActivity.this, abastecimientoModels -> {
                    recyclerView.setAdapter(actorAdapter);
                    actorAdapter.getAllActors(actorList);

                }
                );*/
        viewModel.getAbastecimiento().observe(this, new Observer<List<AbastecimientoModel>>() {
            @Override
            public void onChanged(List<AbastecimientoModel> actorList) {
                recyclerView.setAdapter(abastecimientoAdapter);
                abastecimientoAdapter.getAll(actorList);
            }
        });
    }
    }
