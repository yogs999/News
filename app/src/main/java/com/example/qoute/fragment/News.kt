package com.example.qoute.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qoute.databinding.FragmentNewsBinding
import com.example.qoute.adapter.NewsAdapter
import com.example.qoute.viewmodel.NewsView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class News : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewHolder: NewsAdapter

    private val newsView: NewsView by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)

        getNews()

        return binding.root

    }

    private fun getNews() {

     //   newsView = ViewModelProvider(this).get(NewsView::class.java)

        newsView.liveNews.observe(viewLifecycleOwner, Observer {
            binding.recyclerview.setHasFixedSize(true)
            binding.recyclerview.layoutManager = LinearLayoutManager(context)
            viewHolder = NewsAdapter(this.requireContext(),it)
            binding.recyclerview.adapter = viewHolder


        })

    }
}

