package com.example.tlb

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tlb.data.Users
import com.example.tlb.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var reference : DatabaseReference
    lateinit var firebaseDatabase : FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")



        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var auth = FirebaseAuth.getInstance()

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        var users = ArrayList<Users>()
        //O'qivolish
//         Read from the database
        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.children
                value.forEach {
                    users.add(it.getValue(Users::class.java)!!)
                }
                var isHave = false
                users.forEach{
                    if (auth.currentUser != null){
                        if (it.id == auth.currentUser?.uid){
                            if (it.name!!.isNotBlank()){
                                isHave = true
                                val handler = Handler(mainLooper)
                                handler.postDelayed({

                                    val intent = Intent(this@MainActivity, HomeActivity::class.java)

                                    startActivity(intent)

                                }, 800)
                            }
                        }
                    }
                }


                if (!isHave){
                    val handler = Handler(mainLooper)
                    handler.postDelayed({

                        val intent = Intent(this@MainActivity, EnterNumberActivity::class.java)

                        startActivity(intent)

                    }, 800)
                }
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

//        val database = Firebase.database.reference
        //Yaratish
//        val myRef = database.getReference("tasks").child("1 month").child("2 week")
//
//        myRef.setValue("998")


//O'qivolish
        // Read from the database
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val value = dataSnapshot.getValue<String>()
//                Log.d(TAG, "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException())
//            }
//        })


//        database.child("tasks").child("1 month").child("3 week").get().addOnSuccessListener {
//            Log.i("firebase", "Got value ${it.value}")
//        }.addOnFailureListener {
//            Log.e("firebase", "Error getting data", it)
//        }
        // Firebaseda yozgan narsani o'qib olish


    }
}