package com.example.tlb

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tlb.databinding.FragmentHomeItemClickBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class HomeItemClickFragment : Fragment() {
    lateinit var binding: FragmentHomeItemClickBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var reference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_item_click, container, false)
        binding = FragmentHomeItemClickBinding.bind(view)

        var card1 = arguments?.getBoolean("card1")
//        var card2 = arguments?.getBoolean("card2")
//        var card3 = arguments?.getBoolean("card3")
//        var card4 = arguments?.getBoolean("card4")


        if (card1 == true) {
            readItemData()
        }
//        if (card2 == true) {
//            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//        }
//        if (card3 == true) {
//            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//        }
//        if (card4 == true) {
//            Toast.makeText(requireContext(), "Do previous tasks", Toast.LENGTH_SHORT).show()
//        }



        return view
    }


    fun readItemData() {
        var day1 = false
        var day2 = false
        var day3 = false
        var day4 = false
        var day5 = false
        var day6 = false
        var day7 = false
        val database = Firebase.database.reference

        firebaseAuth = FirebaseAuth.getInstance()
        val currenUser = firebaseAuth.currentUser

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("user_tasks")

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

        binding.btn1.setOnClickListener {

            database.child("tasks").child("1 month").child("1 week").child("1")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("1")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            binding.buttonStart.setOnClickListener {
                day1 = true
                if (day1) {
                    findNavController().popBackStack(R.id.homeFragment, false)
                    reference.child(currenUser?.uid!!).child("1 weeek/1").setValue(day1)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn2.setOnClickListener {
            day2 = true

            database.child("tasks").child("1 month").child("1 week").child("2")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("2")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day2) {
                    reference.child(currenUser?.uid!!).child("1 weeek/2").setValue(day2)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn3.setOnClickListener {

            day3 = true
            database.child("tasks").child("1 month").child("1 week").child("3")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("3")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day3) {
                    reference.child(currenUser?.uid!!).child("1 weeek/3").setValue(day3)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn4.setOnClickListener {
            day4 = true
            database.child("tasks").child("1 month").child("1 week").child("4")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("4")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day4) {
                    reference.child(currenUser?.uid!!).child("1 weeek/4").setValue(day4)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn5.setOnClickListener {
            day5 = true

            database.child("tasks").child("1 month").child("1 week").child("5")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("5")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day5) {
                    reference.child(currenUser?.uid!!).child("1 weeek/5").setValue(day5)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn6.setOnClickListener {
            day6 = true
            database.child("tasks").child("1 month").child("1 week").child("6")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("6")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day6) {
                    reference.child(currenUser?.uid!!).child("1 weeek/6").setValue(day6)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

        binding.btn7.setOnClickListener {

            day6 = true
            database.child("tasks").child("1 month").child("1 week").child("7")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("1 week").child("7")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day7) {
                    reference.child(currenUser?.uid!!).child("1 weeek/7").setValue(day7)
                    findNavController().popBackStack(R.id.homeFragment, false)
                    reference.child(currenUser?.uid!!).child("1 weeek").setValue(day7)

                }


            }


        }

        binding.buttonStart.setOnClickListener {
            binding.aboutTx.text = "No daily task selected.Please check again"
        }

    }

    fun readItem2Data() {
        var day1 = false
        var day2 = false
        var day3 = false
        var day4 = false
        var day5 = false
        var day6 = false
        var day7 = false
        val database = Firebase.database.reference

        firebaseAuth = FirebaseAuth.getInstance()
        val currenUser = firebaseAuth.currentUser

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("user_tasks")


        database.child("tasks").child("1 month").child("2 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.imgItem)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read img_text

        database.child("tasks").child("1 month").child("2 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.imgText.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        binding.btn1.setOnClickListener {
            day1 = true
            database.child("tasks").child("1 month").child("2 week").child("1")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("1")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            binding.buttonStart.setOnClickListener {

                if (day1) {
                    reference.child(currenUser?.uid!!).child("2 weeek/1").setValue(day1)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn2.setOnClickListener {
            day2 = true

            database.child("tasks").child("1 month").child("2 week").child("2")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("2")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day2) {
                    reference.child(currenUser?.uid!!).child("2 weeek/2").setValue(day2)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn3.setOnClickListener {

            day3 = true
            database.child("tasks").child("1 month").child("2 week").child("3")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("3")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day3) {
                    reference.child(currenUser?.uid!!).child("2 weeek/3").setValue(day3)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn4.setOnClickListener {
            day4 = true
            database.child("tasks").child("1 month").child("2 week").child("4")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("4")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day4) {
                    reference.child(currenUser?.uid!!).child("2 weeek/4").setValue(day4)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn5.setOnClickListener {
            day5 = true

            database.child("tasks").child("1 month").child("2 week").child("5")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("5")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day5) {
                    reference.child(currenUser?.uid!!).child("2 weeek/5").setValue(day5)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn6.setOnClickListener {
            day6 = true
            database.child("tasks").child("1 month").child("2 week").child("6")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("6")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day6) {
                    reference.child(currenUser?.uid!!).child("2 weeek/6").setValue(day6)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

        binding.btn7.setOnClickListener {

            day6 = true
            database.child("tasks").child("1 month").child("2 week").child("7")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("2 week").child("7")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day7) {
                    reference.child(currenUser?.uid!!).child("2 weeek/7").setValue(day7)
                    findNavController().popBackStack(R.id.homeFragment, false)

                }


            }


        }

        binding.buttonStart.setOnClickListener {
            binding.aboutTx.text = "No daily task selected.Please check again"
        }

    }

    fun readItem3Data() {
        var day1 = false
        var day2 = false
        var day3 = false
        var day4 = false
        var day5 = false
        var day6 = false
        var day7 = false
        val database = Firebase.database.reference

        firebaseAuth = FirebaseAuth.getInstance()
        val currenUser = firebaseAuth.currentUser

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("user_tasks")


        database.child("tasks").child("1 month").child("3 week").child("image_url").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val image = it.value

                Glide.with(this).load(image).into(binding.imgItem)

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        //Read img_text

        database.child("tasks").child("1 month").child("3 week").child("theme").get()
            .addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
                val theme = it.value

                binding.imgText.text = theme.toString()

            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        binding.btn1.setOnClickListener {
            day1 = true
            database.child("tasks").child("1 month").child("3 week").child("1")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("1")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            binding.buttonStart.setOnClickListener {

                if (day1) {
                    reference.child(currenUser?.uid!!).child("3 weeek/1").setValue(day1)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn2.setOnClickListener {
            day2 = true

            database.child("tasks").child("1 month").child("3 week").child("2")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("2")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day2) {
                    reference.child(currenUser?.uid!!).child("3 weeek/2").setValue(day2)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn3.setOnClickListener {

            day3 = true
            database.child("tasks").child("1 month").child("3 week").child("3")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("3")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day3) {
                    reference.child(currenUser?.uid!!).child("3 weeek/3").setValue(day3)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn4.setOnClickListener {
            day4 = true
            database.child("tasks").child("1 month").child("3 week").child("4")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("4")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day4) {
                    reference.child(currenUser?.uid!!).child("3 weeek/4").setValue(day4)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn5.setOnClickListener {
            day5 = true

            database.child("tasks").child("1 month").child("3 week").child("5")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("5")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day5) {
                    reference.child(currenUser?.uid!!).child("3 weeek/5").setValue(day5)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }

        binding.btn6.setOnClickListener {
            day6 = true
            database.child("tasks").child("1 month").child("3 week").child("6")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("6")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day6) {
                    reference.child(currenUser?.uid!!).child("3 weeek/6").setValue(day6)
                    findNavController().popBackStack(R.id.homeFragment, false)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "No daily task selected.Please check again",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

        binding.btn7.setOnClickListener {

            day6 = true
            database.child("tasks").child("1 month").child("3 week").child("7")
                .child("task").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }

            database.child("tasks").child("1 month").child("3 week").child("7")
                .child("task2").get()
                .addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                    val about = it.value

                    binding.aboutTx2.text = about.toString()

                }.addOnFailureListener {
                    Log.e("firebase", "Error getting data", it)
                }


            binding.buttonStart.setOnClickListener {

                if (day7) {
                    reference.child(currenUser?.uid!!).child("3 weeek/7").setValue(day7)
                    findNavController().popBackStack(R.id.homeFragment, false)

                }


            }


        }

        binding.buttonStart.setOnClickListener {
            binding.aboutTx.text = "No daily task selected.Please check again"
        }

    }

}




