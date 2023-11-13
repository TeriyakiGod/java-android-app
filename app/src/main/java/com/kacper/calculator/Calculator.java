package com.kacper.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Calculator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText inputFieldA, inputFieldB;
    TextView resultField;
    Button addButton, subtractButton, multiplyButton, divideButton;

    public DrawerLayout drawerLayout;
    public ActionBar actionBar;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        inputFieldA = findViewById(R.id.inputFieldA);
        inputFieldB = findViewById(R.id.inputFieldB);
        resultField = findViewById(R.id.resultField);
        addButton = findViewById(R.id.buttonAdd);
        subtractButton = findViewById(R.id.buttonSub);
        multiplyButton = findViewById(R.id.buttonMul);
        divideButton = findViewById(R.id.buttonDiv);

        addButton.setOnClickListener(v -> add());
        subtractButton.setOnClickListener(v -> subtract());
        multiplyButton.setOnClickListener(v -> multiply());
        divideButton.setOnClickListener(v -> divide());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_calculator) {
            // Optional: Check if already on the Calculator activity to avoid restarting it
            if (!getClass().getSimpleName().equals("Calculator")) {
                startActivity(new Intent(this, Calculator.class));
            }
        } else if (itemId == R.id.nav_gallery) {
            startActivity(new Intent(this, Gallery.class));
            // Add more cases for other menu items as needed
        }

        // Close the drawer after handling the item click
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void add() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a + b;
        resultField.setText(Double.toString(result));
    }

    public void subtract() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a - b;
        resultField.setText(Double.toString(result));
    }

    public void multiply() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a * b;
        resultField.setText(Double.toString(result));
    }

    public void divide() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        if (b == 0) {
            resultField.setText(R.string.error_zero_division);
            return;
        }
        double result = a / b;
        resultField.setText(Double.toString(result));
    }


}