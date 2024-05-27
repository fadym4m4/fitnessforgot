package com.example.fittnessforgot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class FrForgot : Fragment() {
    lateinit var auth: FirebaseAuth
    lateinit var emailEditText: EditText
    lateinit var resetPasswordButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        emailEditText = view.findViewById(R.id.emailEditText)
        resetPasswordButton = view.findViewById(R.id.resetPasswordButton)
        auth = FirebaseAuth.getInstance()

        resetPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                emailEditText.requestFocus()
                return@setOnClickListener
            }else {

                sendPasswordResetEmail(email)
            }
        }
    }

    fun sendPasswordResetEmail(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { m ->
                if (m.isSuccessful) {
                    Toast.makeText(context, "Password reset email sent", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Error: ${m.exception?.message}", Toast.LENGTH_SHORT).show()
                }
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
        return inflater.inflate(R.layout.fragment_fr_forgot, container, false)
    }

}