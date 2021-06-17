package com.example.assesment2_maribelajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class MatematikaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_matematika,container, false)

        view.findViewById<Button>(R.id.btn_segitiga).setOnClickListener{
            NavHostFragment.findNavController(this@MatematikaFragment)
                .navigate(R.id.action_matematikaFragment_to_segitigaFragment)

        }
        view.findViewById<Button>(R.id.btn_persegi).setOnClickListener{
            NavHostFragment.findNavController(this@MatematikaFragment)
                .navigate(R.id.action_matematikaFragment_to_persegiPanjang)

        }
        view.findViewById<ImageView>(R.id.review_navbar).setOnClickListener{
            NavHostFragment.findNavController(this@MatematikaFragment)
                .navigate(R.id.action_matematikaFragment_to_reviewActivity)

        }
        view.findViewById<ImageView>(R.id.home_navbar).setOnClickListener{
            NavHostFragment.findNavController(this@MatematikaFragment)
                .navigate(R.id.action_matematikaFragment_to_HomeFragment)

        }
        return view
    }

}