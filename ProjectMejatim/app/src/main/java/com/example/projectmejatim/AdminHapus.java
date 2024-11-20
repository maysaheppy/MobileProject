package com.example.projectmejatim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminHapus extends AppCompatActivity {

    Button btConfirmHapus;
    DatabaseReference databaseLukisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hapus);

        btConfirmHapus = findViewById(R.id.btConfirmHapus);
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        databaseLukisan = FirebaseDatabase.getInstance().getReference("lukisans");

        btConfirmHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseLukisan.child(id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Intent i = new Intent(AdminHapus.this, HalamanAdmin.class);
                        startActivity(i);
                    }
                });
            }
        });




    }
}