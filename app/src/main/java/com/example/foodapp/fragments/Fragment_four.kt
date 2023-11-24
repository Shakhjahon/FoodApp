package com.example.foodapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentFourBinding

class fragment_four : Fragment() {

    private val binding: FragmentFourBinding by lazy {
        FragmentFourBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_four_to_addIcon
            )
        }
        binding.buttons.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragment_four_to_vectorIcon
            )
        }
    }
}

