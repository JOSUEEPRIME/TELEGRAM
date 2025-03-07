package com.example.telegramview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private boolean isDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargar las preferencias del tema
        sharedPreferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);

        // Aplicar el tema al iniciar
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        setContentView(R.layout.activity_main);

        // Configurar el botón de cambio de tema
        setupThemeButton();
    }

    private void setupThemeButton() {
        ImageView themeButton = findViewById(R.id.theme_button);

        themeButton.setOnClickListener(v -> {
            // Alternar entre temas
            isDarkMode = !isDarkMode;
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            // Guardar la preferencia del usuario
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isDarkMode", isDarkMode);
            editor.apply();
        });
    }
}
