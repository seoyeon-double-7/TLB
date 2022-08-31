package com.example.tlb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.tlb.databinding.ActivityEnterNumberBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*

import java.util.concurrent.TimeUnit


class EnterNumberActivity : AppCompatActivity() {
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    var auth: FirebaseAuth? = null
    private val TAG = "SmsActivity"

    lateinit var binding: ActivityEnterNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEnterNumberBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        auth = FirebaseAuth.getInstance()


        binding.nextButton.setOnClickListener {
            if (binding.numberTx.text.isNotBlank()) {
                binding.nextButton.visibility = View.INVISIBLE
                binding.welcomeTv.visibility = View.INVISIBLE
                binding.weAreGlad.visibility = View.INVISIBLE
                binding.numberTx.visibility = View.INVISIBLE


                binding.helloTv.visibility = View.VISIBLE
                binding.aOneTime.visibility = View.VISIBLE
                binding.codeTx.visibility = View.VISIBLE
                binding.sendAgain.visibility = View.VISIBLE



            } else {
                Toast.makeText(this, "No number entered", Toast.LENGTH_SHORT).show()
            }


            val number = binding.numberTx.text.toString()
            sendVerification(number!!)


            binding.codeTx.addTextChangedListener {
                if (it.toString().length == 6)
                    verifycode()

            }
            binding.sendAgain.setOnClickListener {
                if (this::resendToken.isInitialized) {
                    resendCode(number)
                    Toast.makeText(this, "Is being send", Toast.LENGTH_SHORT).show()
                }
            }

        }


    }

    fun resendCode(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth!!)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setForceResendingToken(resendToken)
            .setCallbacks(callbacks)          // On Verification State Changed Callbacks
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun sendVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth!!)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // On Verification State Changed Callbacks
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private var callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            Log.d(TAG, "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(TAG, "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            Log.d(TAG, "onCodeSent:$verificationId")

            storedVerificationId = verificationId
            resendToken = token
        }
    }

    private fun verifycode() {
        val code = binding.codeTx.text.toString()
        if (code.length == 6 && ::storedVerificationId.isInitialized) {
            val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
            signInWithPhoneAuthCredential(credential)
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth!!.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val intent = Intent(this, EnterNIcknameActivity::class.java)
                    intent.putExtra("number", binding.numberTx.text.toString())
                    startActivity(intent)


                } else {
                    //elsega agar yuborilgan kod xato bolasa tushadi togri bolsa ifga tuwadi
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

}