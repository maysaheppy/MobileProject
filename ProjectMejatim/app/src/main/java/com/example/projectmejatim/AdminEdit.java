package com.example.projectmejatim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class AdminEdit extends AppCompatActivity {

    EditText etJudulEdit;
    EditText etPelukisEdit;
    EditText etDeksripsiEdit;
    Button btSimpanEdit;
    TextView tvJudulEdit;
    DatabaseReference databaseLukisan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit);

        etJudulEdit = findViewById(R.id.etJudulEdit);
        etPelukisEdit = findViewById(R.id.etPelukisEdit);
        etDeksripsiEdit = findViewById(R.id.etDeskripsiEdit);
        btSimpanEdit = findViewById(R.id.btSimpanEdit);
        tvJudulEdit = findViewById(R.id.tvJudulEdit);

        databaseLukisan = FirebaseDatabase.getInstance().getReference("lukisans");

        Intent i = getIntent();
        String lukisanId = i.getStringExtra("id");

        databaseLukisan.child(lukisanId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Lukisan lukis = snapshot.getValue(Lukisan.class);
//                Lukisan lukis = snapshot.child(lukisanId).getValue(Lukisan.class);

                etJudulEdit.setText(lukis.getJudul());
                tvJudulEdit.setText(lukis.getJudul());
                etPelukisEdit.setText(lukis.getPelukis());
                etDeksripsiEdit.setText(lukis.getDeskripsi());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btSimpanEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newJudul = etJudulEdit.getText().toString();
                String newNama = etPelukisEdit.getText().toString();
                String newDeskripsi = etDeksripsiEdit.getText().toString();


                Lukisan lukis = new Lukisan(lukisanId, newJudul, newNama, newDeskripsi);
                databaseLukisan.child(lukisanId).setValue(lukis);

                Intent i = new Intent(AdminEdit.this, AdminDetail.class);
                startActivity(i);
            }
        });


    }
}