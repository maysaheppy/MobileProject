package com.example.room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btInsert;
    Button btView;
    EditText etName;
    EditText etNim;
    TextView tv1;
    private AppDatabase appDb;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDb = AppDatabase.getInstance(getApplicationContext());
        btInsert = findViewById(R.id.btInsert);
        btView = findViewById(R.id.btView);
        tv1 = findViewById(R.id.tv1);
        etName = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Item item = new Item();
                item.setId(i);
                item.setNama(etName.getText().toString());
                item.setNim(etNim.getText().toString());
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        appDb.itemDao().insertAll(item);
                    }
                });
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<Item> list = appDb.itemDao().getAll();
                        String s = "";
                        for (Item item : list) {
                            s = s + item.getNama() + '\n' + item.getNim() + '\n';
                        }
                        tv1.setText(s);
                    }
                });
            }
        });

    }
}