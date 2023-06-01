package com.example.qoute.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.qoute.R
import com.example.qoute.databinding.FragmentHomeBinding
import com.example.qoute.firebase.LoginUser
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class home : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

                  firebaseAuth=FirebaseAuth.getInstance()

        binding.btn1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home2_to_anime)
        }
        binding.btn2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home2_to_normalQoutes)
        }
        binding.btn3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home2_to_news)
        }

        binding.logout.setOnClickListener {
            firebaseAuth.signOut()
            val intant = Intent(requireContext(),LoginUser::class.java)
            startActivity(intant)

        }

        return binding.root

    }

}
