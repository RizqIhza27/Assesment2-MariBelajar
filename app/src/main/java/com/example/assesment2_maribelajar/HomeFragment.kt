package com.example.assesment2_maribelajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home,container, false)

        view.findViewById<LinearLayout>(R.id.btn_math).setOnClickListener{
            NavHostFragment.findNavController(this@HomeFragment)
                .navigate(R.id.action_HomeFragment_to_matematikaFragment)

        }
        view.findViewById<LinearLayout>(R.id.btn_bio).setOnClickListener{
            NavHostFragment.findNavController(this@HomeFragment)
                .navigate(R.id.action_HomeFragment_to_listHewanFragment)

        }
        view.findViewById<ImageView>(R.id.review_navbar).setOnClickListener{
            NavHostFragment.findNavController(this@HomeFragment)
                    .navigate(R.id.action_HomeFragment_to_reviewActivity)

        }
        return view
    }

}