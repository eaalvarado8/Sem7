package com.example.sem7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login_user.*
import kotlinx.android.synthetic.main.activity_registrar_pet.*

enum class ProviderType{
    BASIC,
    GOOGLE,
    FACEBOOK
}

class RegistrarPet : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_pet)
        val bundle:Bundle?=intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")


        setup(email?:"", provider?:"")

    }
    private fun setup(email:String, provider:String){
        title ="Inicio"
        tv_correo1.text=email
        tv_provider1.text=provider

        btn_guardarPet.setOnClickListener(){
            db.collection("pets").document(email).set(
                hashMapOf("provider" to provider, "namePet" to et_nombrePet.text.toString(),
                    "edadPet" to et_edadPet.text.toString(), "raza" to et_razaPet.text.toString(),
                    "numVac" to et_numVac.text.toString(), "dateVac" to et_ultVac.text.toString(),
                    "diseases" to et_enfermedades.text.toString())
            )
        }
        btn_recuperarPet.setOnClickListener(){
            db.collection("pets").document(email).get().addOnSuccessListener {
                et_nombrePet.setText(it.get("namePet") as String?)
                et_edadPet.setText(it.get("edadPet") as String?)
                et_razaPet.setText(it.get("raza") as String?)
                et_numVac.setText(it.get("numVac") as String?)
                et_ultVac.setText(it.get("dateVac") as String?)
                et_enfermedades.setText(it.get("diseases") as String?)
            }
        }
    }

}