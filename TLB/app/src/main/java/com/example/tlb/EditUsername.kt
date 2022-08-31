package com.example.tlb

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tlb.data.Users
import com.example.tlb.databinding.FragmentEditUsernameBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class EditUsername : Fragment() {
    lateinit var firebaseAuth : FirebaseAuth
    lateinit var firebaseDatabase : FirebaseDatabase
    lateinit var reference : DatabaseReference
    lateinit var arrayAdapter : ArrayAdapter<String>
    private  val TAG = "EditUsername"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_username, container, false)
        val binding = FragmentEditUsernameBinding.bind(view)

        firebaseAuth = FirebaseAuth.getInstance()
        val currenUser = firebaseAuth.currentUser

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users").child(currenUser?.uid!!)


        val spinner1 = arrayOf("Child", "Teenage", "Adult", "Golden ager")
        arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, spinner1)
        binding.spinner.adapter = arrayAdapter

//        val database = Firebase.database.reference

        binding.saveBtn.setOnClickListener {

            val id = currenUser?.uid
            val name = binding.nicknameTx.text.toString()
            val number = currenUser?.phoneNumber
            val ageType = binding.spinner.selectedItem.toString()
            val user = Users(currenUser?.uid,name,number,ageType)

            reference.child(id!!).child("about_user").setValue(user)
            findNavController().popBackStack()
        }


        return view
    }






}