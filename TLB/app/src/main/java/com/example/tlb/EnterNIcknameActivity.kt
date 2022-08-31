package com.example.tlb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tlb.data.Users
import com.example.tlb.databinding.ActivityEnterNicknameBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class EnterNIcknameActivity : AppCompatActivity() {
    lateinit var binding: ActivityEnterNicknameBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var arrayAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEnterNicknameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        val currenUser = firebaseAuth.currentUser

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)


        val spinner1 = arrayOf("Child", "Teenage", "Adult", "Golden ager")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinner1)
        binding.spinner.adapter = arrayAdapter


        binding.nextButton.setOnClickListener {
            val nickname = binding.nicknameTx.text.toString()
            val number = intent.getStringExtra("number")
            val ageType = binding.spinner.selectedItem.toString()
            val uid = currenUser?.uid
            val user = Users(uid!!, nickname, number.toString(), ageType)

            if (nickname.isNotBlank()) {
                reference.child(uid).setValue(user)

                val intent = Intent(this, TestActivity::class.java)
                intent.putExtra("ageType", ageType)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nickname is empty", Toast.LENGTH_SHORT).show()
            }


        }


    }
}