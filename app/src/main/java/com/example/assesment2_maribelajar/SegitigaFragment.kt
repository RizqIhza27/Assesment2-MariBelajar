package com.example.assesment2_maribelajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class SegitigaFragment : Fragment(), View.OnClickListener {
    private lateinit var et_alas : EditText

    private lateinit var et_lebar: EditText
    private lateinit var hasil_luas : TextView

    private lateinit var btn_hitung : Button
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_segitiga, container, false)

        view.findViewById<ImageView>(R.id.home_navbar).setOnClickListener {
            NavHostFragment.findNavController(this@SegitigaFragment)
                .navigate(R.id.action_segitigaFragment_to_HomeFragment)

        }
        view.findViewById<ImageView>(R.id.review_navbar).setOnClickListener {
            NavHostFragment.findNavController(this@SegitigaFragment)
                .navigate(R.id.action_segitigaFragment_to_reviewActivity)

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        et_alas= view.findViewById<EditText>(R.id.et_alas)
        et_lebar= view.findViewById<EditText>(R.id.et_lebar)
        hasil_luas = view.findViewById<TextView>(R.id.hasil_luas)

        view.findViewById<Button>(R.id.btn_hitung).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_hitung){
            val inputLength = et_alas.text.toString().trim()
            val inputHeight = et_lebar.text.toString().trim()
            var isEmptyFields = false

            when{
                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    et_alas.error = "Fields ini tidak boleh kosong"
                }
                inputLength.isEmpty() -> {
                    isEmptyFields = true
                    et_lebar.error = "Fields ini tidak boleh kosong"
                }

            }

            if(!isEmptyFields){

                val volume = (inputLength.toDouble() * inputHeight.toDouble())/2
                hasil_luas.text = volume.toString()
            }


        }
    }


}