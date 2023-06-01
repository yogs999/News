package com.example.qoute.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.qoute.databinding.FragmentNormalQoutesBinding
import com.example.qoute.adapter.AdapterQoute
import com.example.qoute.viewmodel.QoutesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NormalQoutes : Fragment() {

    val viewModel: QoutesViewModel by viewModels()
    private lateinit var recyclerAdapter: AdapterQoute
    private lateinit var binding: FragmentNormalQoutesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=FragmentNormalQoutesBinding.inflate(inflater,container,false)


      //  viewModel = ViewModelProvider(this).get(QoutesViewModel::class.java)

        viewModel.qoutes.observe(viewLifecycleOwner, Observer {
            recyclerAdapter = AdapterQoute(requireContext(),it)

            binding.recycle.adapter = recyclerAdapter
            binding.recycle.apply {
                set3DItem(true)
                setInfinite(true)
                setAlpha(true)
                setFlat(true)
                setIsScrollingEnabled(true)
            }

        })


        return binding.root

    }




}
