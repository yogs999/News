package com.example.qoute.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qoute.databinding.ActivityRegisterUserBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterUser : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        binding.extlogin.setOnClickListener {
            val intent = Intent(this, LoginUser::class.java)
            startActivity(intent)
        }

        binding.signup.setOnClickListener {

            val name = binding.edpass.text.toString()
            val email = binding.etemail.text.toString()
            val pass = binding.epass.text.toString()

            if (name.isEmpty() && email.isEmpty() && pass.isEmpty()) {
                Toast.makeText(this, "please fill requirement information", Toast.LENGTH_SHORT)
                    .show()
            } else {
                registerUser(email, pass)
            }
        }
    }

    private fun registerUser(email: String, pass: String) {

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {

            if (it.isSuccessful) {
                val intent = Intent(applicationContext, LoginUser::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "unsuccessful please try again..", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
