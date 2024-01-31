package com.ejrm.ejerciciopractico.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ejrm.ejerciciopractico.R;
import com.ejrm.ejerciciopractico.data.db.AppDatabase;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoDao;
import com.ejrm.ejerciciopractico.data.db.CatalogoAbastecimientoEntity;
import com.ejrm.ejerciciopractico.viewmodel.CatalogoAbastecimientoViewModel;
import com.ejrm.ejerciciopractico.viewmodel.MainViewModel;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

public class CatalogoActivity extends AppCompatActivity {
    CatalogoAbastecimientoEntity catalogoAbastecimientoEntity;
    private CatalogoAbastecimientoDao catalogoAbastecimientoDao;
    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private ImageView img;
    private CatalogoAbastecimientoEntity nuevoCatalogo;
    private Button btnverCatalogos, btnCatalogos, btnPsi, btnPno, btnPna, btnTsi, btnTno, btnTna, btnDsi, btnDno, btnDna, btnJsi, btnJno, btnJna, btnAsi, btnAno, btnAna;
    private String papel, toalla, desorodante, jabon, agua;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogo_activity);
        AppDatabase database = AppDatabase.getInstance(getApplication());
        catalogoAbastecimientoDao = database.catalogoAbastecimientoDao();
        btnverCatalogos = findViewById(R.id.verCatalogos);
        btnPsi = findViewById(R.id.papelSI);
        btnPno = findViewById(R.id.papelNO);
        btnPna = findViewById(R.id.papelNA);
        btnTsi = findViewById(R.id.toallaSI);
        btnTno = findViewById(R.id.toallaNO);
        btnTna = findViewById(R.id.toallaNA);
        btnDsi = findViewById(R.id.desorodanteSI);
        btnDno = findViewById(R.id.desorodanteNO);
        btnDna = findViewById(R.id.desorodanteNA);
        btnJsi = findViewById(R.id.jabonSI);
        btnJno = findViewById(R.id.jabonNO);
        btnJna = findViewById(R.id.jabonNA);
        btnAsi = findViewById(R.id.aguaSI);
        btnAno = findViewById(R.id.aguaNO);
        btnAna = findViewById(R.id.aguaNA);
        btnCatalogos = findViewById(R.id.buttonCatalogos);

        img = findViewById(R.id.imageView);
        btnverCatalogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(CatalogoActivity.this, VerCatalogos.class);
                startActivity(inte);
            }
        });
        btnPsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(papel, "")) {
                    papel = btnPsi.getText().toString();
                } else {
                    papel = "";
                    papel = btnPsi.getText().toString();
                }

            }
        });
        btnPno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(papel, "")) {
                    papel = btnPno.getText().toString();
                } else {
                    papel = "";
                    papel = btnPno.getText().toString();
                }

            }
        });
        btnPna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(papel, "")) {
                    papel = btnPna.getText().toString();
                } else {
                    papel = "";
                    papel = btnPna.getText().toString();
                }

            }
        });
        /////////////////////////////////////////////////////////////////
        btnTsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(toalla, "")) {
                    toalla = btnTsi.getText().toString();
                } else {
                    toalla = "";
                    toalla = btnTsi.getText().toString();
                }
            }
        });
        btnTno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(toalla, "")) {
                    toalla = btnTno.getText().toString();
                } else {
                    toalla = "";
                    toalla = btnTno.getText().toString();
                }
            }
        });
        btnTna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(toalla, "")) {
                    toalla = btnTna.getText().toString();
                } else {
                    toalla = "";
                    toalla = btnTna.getText().toString();
                }
            }
        });
        /////////////////////////////////////////////////////////////////
        btnDsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(desorodante, "")) {
                    desorodante = btnDsi.getText().toString();
                } else {
                    desorodante = "";
                    desorodante = btnDsi.getText().toString();
                }
            }
        });
        btnDno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(desorodante, "")) {
                    desorodante = btnDno.getText().toString();
                } else {
                    desorodante = "";
                    desorodante = btnDno.getText().toString();
                }
            }
        });
        btnDna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(desorodante, "")) {
                    desorodante = btnDna.getText().toString();
                } else {
                    desorodante = "";
                    desorodante = btnDna.getText().toString();
                }
            }
        });
        /////////////////////////////////////////////////////////////////
        btnJsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(jabon, "")) {
                    jabon = btnJsi.getText().toString();
                } else {
                    jabon = "";
                    jabon = btnJsi.getText().toString();
                }
            }
        });
        btnJno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(jabon, "")) {
                    jabon = btnJno.getText().toString();
                } else {
                    jabon = "";
                    jabon = btnJno.getText().toString();
                }
            }
        });
        btnJna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(jabon, "")) {
                    jabon = btnJna.getText().toString();
                } else {
                    jabon = "";
                    jabon = btnJna.getText().toString();
                }
            }
        });
        /////////////////////////////////////////////////////////////////
        btnAsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(agua, "")) {
                    agua = btnAsi.getText().toString();
                } else {
                    agua = "";
                    agua = btnAsi.getText().toString();
                }
            }
        });
        btnAno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(agua, "")) {
                    agua = btnAno.getText().toString();
                } else {
                    agua = "";
                    agua = btnAno.getText().toString();
                }
            }
        });
        btnCatalogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (/*imgByte(img).length==0 ||*/ Objects.equals(papel, "") || Objects.equals(toalla, "") || Objects.equals(desorodante, "") || Objects.equals(jabon, "") || Objects.equals(agua, "")) {
                //    Toast.makeText(CatalogoActivity.this,"Selecciona si aplican",Toast.LENGTH_SHORT).show();

                // } else {
                catalogoAbastecimientoEntity = new CatalogoAbastecimientoEntity(imgByte(img), papel, toalla, desorodante, jabon, agua);
                catalogoAbastecimientoDao.insert(catalogoAbastecimientoEntity);
                //}
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CatalogoActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CatalogoActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSION);
                } else {
                    openCamera();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            int maxWidth = img.getWidth();
            int maxHeight = img.getHeight();
            Bitmap scaledBitmap = scaleBitmap(imageBitmap, maxWidth, maxHeight);
            img.setImageBitmap(scaledBitmap);
        }
    }

    public byte[] imgByte(ImageView imageView) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private Bitmap scaleBitmap(Bitmap originalBitmap, int maxWidth, int maxHeight) {
        int width = originalBitmap.getWidth();
        int height = originalBitmap.getHeight();

        float scale = Math.min(((float) maxWidth) / width, ((float) maxHeight) / height);

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(originalBitmap, 0, 0, width, height, matrix, true);
    }


}
