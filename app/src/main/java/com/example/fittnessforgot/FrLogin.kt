package com.example.fittnessforgot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class FrLogin : Fragment() {
    lateinit var forgotPasswordTextView: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forgotPasswordTextView=view.findViewById(R.id.forgotPasswordTextView)

        forgotPasswordTextView.setOnClickListener {
            val action=FrLoginDirections.actionFrLoginToFrForgot()
            findNavController().navigate(action)
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fr_login, container, false)
    }

}