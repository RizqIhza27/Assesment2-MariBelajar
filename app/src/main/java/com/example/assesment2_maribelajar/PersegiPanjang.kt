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

class PersegiPanjang : Fragment(), View.OnClickListener {
    private lateinit var et_panjang : EditText

    private lateinit var et_tinggi: EditText
    private lateinit var et_lebar: EditText
    private lateinit var hasil_luas : TextView

    private lateinit var btn_hitung : Button
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_persegi_panjang, container, false)

        view.findViewById<ImageView>(R.id.home_navbar).setOnClickListener {
            NavHostFragment.findNavController(this@PersegiPanjang)
                .navigate(R.id.action_persegiPanjang_to_HomeFragment)

        }
        view.findViewById<ImageView>(R.id.review_navbar).setOnClickListener {
            NavHostFragment.findNavController(this@PersegiPanjang)
                .navigate(R.id.action_persegiPanjang_to_reviewActivity)

        }
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        et_panjang= view.findViewById<EditText>(R.id.et_panjang)
        et_lebar= view.findViewById<EditText>(R.id.et_lebar)
        hasil_luas = view.findViewById<TextView>(R.id.hasil_luas)

        view.findViewById<Button>(R.id.btn_hitung).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_hitung){
            val inputLength = et_panjang.text.toString().trim()

            val inputWidth = et_lebar.text.toString().trim()

            var isEmptyFields = false

            when{
                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    et_lebar.error = "Fields ini tidak boleh kosong"
                }
                inputLength.isEmpty() -> {
                    isEmptyFields = true
                    et_panjang.error = "Fields ini tidak boleh kosong"
                }

            }

            if(!isEmptyFields){

                val volume = inputLength.toDouble() * inputWidth.toDouble()
                hasil_luas.text = volume.toString()
            }


        }
    }


}