package com.example.sem7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_acceso.setOnClickListener(){
            var saltarGPS:Intent= Intent(this, login::class.java)
            startActivity(saltarGPS)
        }

        btn_accesoPet.setOnClickListener() {
            var saltarGPS: Intent = Intent(this, RegistrarPet::class.java)
            startActivity(saltarGPS)
        }
    }
}