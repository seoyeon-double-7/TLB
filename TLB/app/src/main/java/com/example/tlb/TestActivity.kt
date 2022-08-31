package com.example.tlb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tlb.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestBinding
    private var quizCounter = 0
    private var isChesked = false
    private var testTx = 0
    private var clickable = false
    private val childQuestions = mutableListOf(
        mutableListOf("How many hours do you sleep everyday?", "6-7", "8-9", "10+"),
        mutableListOf("What is your the most important meal of the day?", "Breakfast", "Lunch", "Dinner"),
        mutableListOf("How do you start your day?", "By walking after breakfast", "By walking before breakfast", "By working/studying after breakfast"),
        mutableListOf("How many hours a day do you use the phone?", "1-2 hours", "2-3 hours", "3-5 hours"),
        mutableListOf("How many liters of water do you drink in 1 day?", "1-1,5 litres", "2-2,5 litres", "3 litres"))
    private val teenAgeQuestions = mutableListOf(
        mutableListOf("How many hours do you sleep everyday?", "6-7", "8-9", "10+"),
        mutableListOf("What is your the most important meal of the day?", "Breakfast", "Lunch", "Dinner"),
        mutableListOf("How do you start your day?", "By walking after breakfast", "By walking before breakfast", "By working/studying after breakfast"),
        mutableListOf("How many hours a day do you use the phone?", "1-2 hours", "2-3 hours", "3-5 hours"),
        mutableListOf("How many liters of water do you drink in 1 day?", "1-1,5 litres", "2-2,5 litres", "3 litres"))
    private val AdultQuestions = mutableListOf(
        mutableListOf("How many hours do you sleep everyday?", "5-6", "6-7", "8-9"),
        mutableListOf("What is your the most important meal of the day?", "Breakfast", "Lunch", "Dinner"),
        mutableListOf("How do you start your day?", "By walking after breakfast", "By walking before breakfast", "By working/studying after breakfast"),
        mutableListOf("How many hours a day do you use the phone?", "1-2 hours", "2-3 hours", "3-5 hours"),
        mutableListOf("How many liters of water do you drink in 1 day?", "1-1,5 litres", "2-2,5 litres", "3 litres"))
    private val OldQuestions = mutableListOf(
        mutableListOf("How many hours do you sleep everyday?", "6-7", "8-9", "10+"),
        mutableListOf("What is your the most important meal of the day?", "Breakfast", "Lunch", "Dinner"),
        mutableListOf("How do you start your day?", "By walking after breakfast", "By walking before breakfast", "By working/studying after breakfast"),
        mutableListOf("How many hours a day do you use the phone?", "1-2 hours", "2-3 hours", "3-5 hours"),
        mutableListOf("How many liters of water do you drink in 1 day?", "1-1,5 litres", "2-2,5 litres", "3 litres"))

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTestBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        val ageType = intent.getStringExtra("ageType")

        if (ageType == "Child") {
            showNextQuizChild()
        }
        if(ageType == "Teenage"){
            showNextQuizTeenage()
        }
        if(ageType == "Adult"){
            showNextQuizAdult()
        }
        if(ageType == "Golden ager"){
            showNextQuizOld()
        }




    }

    fun showNextQuizChild() {

        //Bosilgan button ni olish

        binding.firtAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked
                binding.firtAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }

        binding.secondAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked


                binding.secondAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }
        binding.thirdAnswer.setOnClickListener {
            if (isChesked == true) {
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked

                binding.thirdAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }


        //question berish

        binding.buttonNext.setOnClickListener {

            if (clickable) {
                testTx++
                quizCounter++

                val quizChild = childQuestions[testTx]

                binding.questionTx.text = quizChild[0]

                binding.firtAnswerTx.text = quizChild[1]
                binding.secondAnswerTx.text = quizChild[2]
                binding.thirdAnswerTx.text = quizChild[3]


                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))

                clickable = false

                if (quizCounter == 1) {
                    binding.tab1.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab2.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 2) {
                    binding.tab2.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab3.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 3) {
                    binding.tab3.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab4.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 4) {
                    binding.tab4.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab5.setBackgroundResource(R.drawable.shape_select)
                    binding.buttonNext.visibility = View.INVISIBLE
                    binding.buttonNext2.visibility = View.VISIBLE


                }

            }
            clickable = false
            binding.buttonNext2.setOnClickListener {
                if (clickable){
                    val intent = Intent(this, DiagnosticActivity::class.java)
                    startActivity(intent)
                }


            }
        }
    }
    fun showNextQuizTeenage(){
        //Bosilgan button ni olish

        binding.firtAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked
                binding.firtAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }

        binding.secondAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked


                binding.secondAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }
        binding.thirdAnswer.setOnClickListener {
            if (isChesked == true) {
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked

                binding.thirdAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }


        //question berish

        binding.buttonNext.setOnClickListener {

            if (clickable) {
                testTx++
                quizCounter++

                val quizTeenage = teenAgeQuestions[testTx]

                binding.questionTx.text = quizTeenage[0]

                binding.firtAnswerTx.text = quizTeenage[1]
                binding.secondAnswerTx.text = quizTeenage[2]
                binding.thirdAnswerTx.text = quizTeenage[3]


                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))

                clickable = false

                if (quizCounter == 1) {
                    binding.tab1.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab2.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 2) {
                    binding.tab2.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab3.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 3) {
                    binding.tab3.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab4.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 4) {
                    binding.tab4.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab5.setBackgroundResource(R.drawable.shape_select)
                    binding.buttonNext.visibility = View.INVISIBLE
                    binding.buttonNext2.visibility = View.VISIBLE


                }

            }
            clickable = false
            binding.buttonNext2.setOnClickListener {
                if (clickable){
                    val intent = Intent(this, DiagnosticActivity::class.java)
                    startActivity(intent)
                }


            }
        }
    }
    fun showNextQuizAdult(){
        //Bosilgan button ni olish

        binding.firtAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked
                binding.firtAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }

        binding.secondAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked


                binding.secondAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }
        binding.thirdAnswer.setOnClickListener {
            if (isChesked == true) {
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked

                binding.thirdAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }


        //question berish

        binding.buttonNext.setOnClickListener {

            if (clickable) {
                testTx++
                quizCounter++

                val quizAdult = AdultQuestions[testTx]

                binding.questionTx.text = quizAdult[0]

                binding.firtAnswerTx.text = quizAdult[1]
                binding.secondAnswerTx.text = quizAdult[2]
                binding.thirdAnswerTx.text = quizAdult[3]


                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))

                clickable = false

                if (quizCounter == 1) {
                    binding.tab1.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab2.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 2) {
                    binding.tab2.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab3.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 3) {
                    binding.tab3.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab4.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 4) {
                    binding.tab4.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab5.setBackgroundResource(R.drawable.shape_select)
                    binding.buttonNext.visibility = View.INVISIBLE
                    binding.buttonNext2.visibility = View.VISIBLE


                }

            }
            clickable = false
            binding.buttonNext2.setOnClickListener {
                if (clickable){
                    val intent = Intent(this, DiagnosticActivity::class.java)
                    startActivity(intent)
                }


            }
        }
    }
    fun showNextQuizOld(){
        //Bosilgan button ni olish

        binding.firtAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked
                binding.firtAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }

        binding.secondAnswer.setOnClickListener {

            if (isChesked == true) {

                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked


                binding.secondAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }
        binding.thirdAnswer.setOnClickListener {
            if (isChesked == true) {
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            } else {
                clickable = true
                !isChesked

                binding.thirdAnswer.setBackgroundResource(R.drawable.aswer_selector)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.new_color))
                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
            }
        }


        //question berish

        binding.buttonNext.setOnClickListener {

            if (clickable) {
                testTx++
                quizCounter++

                val quizOld = OldQuestions[testTx]

                binding.questionTx.text = quizOld[0]

                binding.firtAnswerTx.text = quizOld[1]
                binding.secondAnswerTx.text = quizOld[2]
                binding.thirdAnswerTx.text = quizOld[3]


                binding.firtAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.firtAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.secondAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.secondAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))
                binding.thirdAnswer.setBackgroundResource(R.drawable.bg_rounded_input_field)
                binding.thirdAnswerTx.setTextColor(getResources().getColor(R.color.siyoh))

                clickable = false

                if (quizCounter == 1) {
                    binding.tab1.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab2.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 2) {
                    binding.tab2.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab3.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 3) {
                    binding.tab3.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab4.setBackgroundResource(R.drawable.shape_select)

                }
                if (quizCounter == 4) {
                    binding.tab4.setBackgroundResource(R.drawable.shape_unselect)
                    binding.tab5.setBackgroundResource(R.drawable.shape_select)
                    binding.buttonNext.visibility = View.INVISIBLE
                    binding.buttonNext2.visibility = View.VISIBLE


                }

            }
            clickable = false
            binding.buttonNext2.setOnClickListener {
                if (clickable){
                    val intent = Intent(this, DiagnosticActivity::class.java)
                    startActivity(intent)
                }


            }
        }
    }


}