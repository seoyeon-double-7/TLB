package com.example.tlb.ui.dashboard

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tlb.R
import com.example.tlb.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    lateinit var auth: FirebaseAuth
    lateinit var reference: DatabaseReference
    lateinit var firebaseDatabase: FirebaseDatabase
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        readBoolen()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun readBoolen() {

        auth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("user_tasks").child(auth.currentUser!!.uid)

        val database = Firebase.database.reference

        database.child("tasks").child("1 month").child("1 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.imgItem)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read img_text

        database.child("tasks").child("1 month").child("1 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.imgText.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        reference.child("1 weeek/1").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/2").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine2.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/3").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine3.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/4").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine4.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/5").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine5.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/6").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine6.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        reference.child("1 weeek/7").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Boolean>()
                Log.d(TAG, "Value is: $value")

                if (value == true){
                    binding.apply {
                        exchanegeLine7.setBackgroundResource(R.drawable.done_week)
//
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }


}