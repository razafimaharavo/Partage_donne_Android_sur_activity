package com.example.affectationliste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText;
    private lateinit var emailEditText: EditText;
    private lateinit var phoneEditText: EditText;
    private lateinit var AffecteButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Pour récuperer les données que j'inserte sur l'input
        nameEditText = findViewById(R.id.editTextNom);
        emailEditText = findViewById(R.id.editTextEmail);
        phoneEditText = findViewById(R.id.editTextPhone);
        AffecteButton = findViewById(R.id.buttonNext);

        AffecteButton.setOnClickListener {
            //pour inserer les données dans un variable en type string
            val name = nameEditText.text.toString();
            val email = emailEditText.text.toString();
            val phone = phoneEditText.text.toString();

            //verifier si les inputs ne sont pas vide
            if(name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty())
            {
                // Créer un Intent pour passer à SecondActivityAffecte les données inserer
                val intent = Intent(this@MainActivity, SecondActivityAffecte::class.java);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Veuillez bien remplir toutes champs s'il vous plaît!", Toast.LENGTH_LONG).show();
            }
        }
    }
}