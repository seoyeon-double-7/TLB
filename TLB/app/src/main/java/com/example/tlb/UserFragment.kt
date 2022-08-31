package com.example.tlb

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tlb.data.Users
import com.example.tlb.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.*

class UserFragment : Fragment() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        val binding = FragmentUserBinding.bind(view)

        binding.actionMenu.setOnClickListener {
            val handler = Handler(requireActivity().mainLooper)
            handler.postDelayed({
                binding.actionMenu.visibility = View.INVISIBLE
                binding.cards.visibility = View.VISIBLE


            }, 200)
        }

        auth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users").child(auth.currentUser!!.uid)

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Users>()
                Log.d(TAG, "Value is: $value")

                binding.nicknameTx.text = value?.name
                binding.numberTx.text = value?.number

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        binding.cardMenu1.setOnClickListener {
            findNavController().navigate(R.id.editUsername)
        }


        binding.cardMenu2.setOnClickListener {
            auth.signOut()
            requireActivity().finish()
        }

        return view
    }



}