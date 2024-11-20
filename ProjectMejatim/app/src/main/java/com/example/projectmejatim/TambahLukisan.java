package com.example.projectmejatim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class TambahLukisan extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private View btTambahGambar;
    private TextView etJudulLukisan;
    private TextView etNamaPelukis;
    private TextView etDeskripsi;
    private Button btSimpan;
//    private Uri imageUri;
//    StorageReference storageRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lukisan);

        btTambahGambar = findViewById(R.id.btTambahGambar);
        etJudulLukisan = findViewById(R.id.etJudulLukisan);
        etNamaPelukis = findViewById(R.id.etNamaPelukis);
        etDeskripsi = findViewById(R.id.etDeskripsi);
        btSimpan = findViewById(R.id.btSimpan);
//        storageRef = FirebaseStorage.getInstance().getReference();
//        StorageReference imagesRef = storageRef.child("images");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference();

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference lukisReference = dbRef.child("lukisans");
                String judul = etJudulLukisan.getText().toString();
                String penulis = etNamaPelukis.getText().toString();
                String deskripsi = etDeskripsi.getText().toString();
                Lukisan lukisan = new Lukisan();
                lukisan.setJudul(judul);
                lukisan.setPelukis(penulis);
                lukisan.setDeskripsi(deskripsi);

                String key = lukisReference.push().getKey();
                lukisan.setId(key);
                lukisReference.child(key).setValue(lukisan);
                Intent i = new Intent(getApplicationContext(), HalamanAdmin.class);
                startActivity(i);
                finish();
            }
        });


    }
}