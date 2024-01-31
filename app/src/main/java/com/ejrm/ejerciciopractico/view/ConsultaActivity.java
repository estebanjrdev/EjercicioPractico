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
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // abastecimientoModels=new ArrayList<>();
       // abastecimientoModels.add(new AbastecimientoModel(1, "Papel", "jbarragan", "","","07/08/2020 07:30:37 p. m.","",""));
       // abastecimientoModels.add(new AbastecimientoModel(2, "Toallas", "jbarragan","","", "07/08/2020 07:30:37 p. m.","",""));
       // abastecimientoModels.add(new AbastecimientoModel(3, "Desodorante", "jbarragan","","",  "07/08/2020 07:30:37 p. m.","",""));
     //  abastecimientoModels.add(new AbastecimientoModel(5, "Agua", "jgarciar","","",  "02/03/2023 01:43:29 p. m.","","" ));

        abastecimientoAdapter=new AbastecimientoAdapter(this,abastecimientoModels);
       // viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MainViewModel.class);
        viewModel.getAbastecimiento().observe(ConsultaActivity.this, abastecimientoModels -> {
                    recyclerView.setAdapter(abastecimientoAdapter);
                   // if (abastecimientoModels.isEmpty()){
                  //      Toast.makeText(this,"Lista Vacia",Toast.LENGTH_SHORT).show();
                  //  }else {
                  //      Toast.makeText(this,"Lista no Vacia",Toast.LENGTH_SHORT).show();
                  //  }
                   // System.out.println( abastecimientoModels.size());
                    abastecimientoAdapter.getAll(abastecimientoModels);
                }
                );

    }
    }
