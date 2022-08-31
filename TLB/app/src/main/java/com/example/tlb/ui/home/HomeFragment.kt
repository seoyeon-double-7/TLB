package com.example.tlb.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tlb.R
import com.example.tlb.databinding.ActivityDiagnosticBinding.inflate
import com.example.tlb.databinding.FragmentHomeBinding
import com.example.tlb.databinding.FragmentHomeItemClickBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference
    private var card1 = false
    private var card2 = false
    private var card3 = false
    private var card4 = false
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("tasks")


        getItemData()


        binding.card1.setOnClickListener {
            card1 = true
            var bundle = Bundle().apply {
                putBoolean("card1",card1)
            }
            findNavController().navigate(R.id.action_homeFragment_to_homeItemClickFragment,bundle)
        }
        binding.card2.setOnClickListener {
            card2 = true
            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//            var bundle = Bundle().apply {
//                putBoolean("card2",card2)
//            }
//            findNavController().navigate(R.id.action_homeFragment_to_homeItemClickFragment,bundle)
        }
        binding.card3.setOnClickListener {
            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//            card3 = true
//            var bundle = Bundle().apply {
//                putBoolean("card3",card3)
//            }
//            findNavController().navigate(R.id.action_homeFragment_to_homeItemClickFragment,bundle)
        }
        binding.card4.setOnClickListener {
            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//            card4 = true
//            var bundle = Bundle().apply {
//                putBoolean("card4",card4)
//            }
//            findNavController().navigate(R.id.action_homeFragment_to_homeItemClickFragment,bundle)
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getItemData(){

        //Read 1-item

        val database = Firebase.database.reference
        database.child("tasks").child("1 month").child("1 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.img1)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        database.child("tasks").child("1 month").child("1 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.img1Text.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read 2-item

        database.child("tasks").child("1 month").child("2 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.img2)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        database.child("tasks").child("1 month").child("2 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.img2Text.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read 3- item

        database.child("tasks").child("1 month").child("3 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.img3)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        database.child("tasks").child("1 month").child("3 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.img3Text.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read 4- item

        database.child("tasks").child("1 month").child("4 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.img4)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        database.child("tasks").child("1 month").child("4 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.img4Text.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }
    }



}