package com.example.qoute.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qoute.MainActivity
import com.example.qoute.databinding.ActivityLoginUserBinding
import com.google.firebase.auth.FirebaseAuth

class LoginUser : AppCompatActivity() {

    private lateinit var binding: ActivityLoginUserBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        firebaseAuth = FirebaseAuth.getInstance()

        binding.edregister.setOnClickListener() {
            val intent = Intent(this, RegisterUser::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener() {
            val email = binding.etemail1.text.toString()
            val pass = binding.edpass1.text.toString()
            loginUser(email, pass)
        }
    }

    private fun loginUser(email: String, pass: String) {

        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "invalid user please enter valid user", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currenUser = firebaseAuth.currentUser
        if (currenUser != null) {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
