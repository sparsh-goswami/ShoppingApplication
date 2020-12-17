package com.example.shoppingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.cart:
                        Toast.makeText(MainActivity.this, "Cart Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about_us:
                        Toast.makeText(MainActivity.this, "About us Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.categories:
                        Toast.makeText(MainActivity.this, "Categories Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.licences:
                        Toast.makeText(MainActivity.this, "Licenses Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.terms:
                        Toast.makeText(MainActivity.this, "Terms and Conditions Selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MainFragment());
        transaction.commit();
    }

    private void initViews()
    {
        drawerLayout= findViewById(R.id.drawer);
        navigationView= findViewById(R.id.navigationView);
        toolbar= findViewById(R.id.toolbar);
    }
}