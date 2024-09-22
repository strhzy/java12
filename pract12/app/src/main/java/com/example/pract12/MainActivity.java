package com.example.pract12;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Kitty> kitties = new ArrayList<Kitty>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        KittyAdapter.OnStateClickListener stateClickListener = new KittyAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Kitty kitty, int position) {

                onKittyClick(kitty, position);
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        KittyAdapter adapter = new KittyAdapter(stateClickListener,this, kitties);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        kitties.add(new Kitty("Вася", "Рыжий", R.drawable.vasya));
        kitties.add(new Kitty("Вьетнамец", "Черный с белым", R.drawable.vietnam));
        kitties.add(new Kitty("Жоски", "В полоску", R.drawable.joski));
        kitties.add(new Kitty("Вася", "Рыжий", R.drawable.vasya));
        kitties.add(new Kitty("Вьетнамец", "Черный с белым", R.drawable.vietnam));
        kitties.add(new Kitty("Жоски", "В полоску", R.drawable.joski));
        kitties.add(new Kitty("Вася", "Рыжий", R.drawable.vasya));
        kitties.add(new Kitty("Вьетнамец", "Черный с белым", R.drawable.vietnam));
        kitties.add(new Kitty("Жоски", "В полоску", R.drawable.joski));
    }

    public void onKittyClick(Kitty kitty, int position) {
        Intent intent = new Intent(MainActivity.this, CommonActivity.class);

        intent.putExtra("pic",kitty.getPicResource());
        intent.putExtra("name", kitty.getName());
        intent.putExtra("color", kitty.getColor());

        startActivity(intent);
    }

}