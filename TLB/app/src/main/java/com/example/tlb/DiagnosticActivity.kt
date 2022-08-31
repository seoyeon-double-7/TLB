package com.example.tlb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tlb.databinding.ActivityDiagnosticBinding
import com.example.tlb.databinding.ActivityTestBinding

class DiagnosticActivity : AppCompatActivity() {
    lateinit var binding: ActivityDiagnosticBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityDiagnosticBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)


        binding.buttonFollowUs.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }




    }

    override fun onRestart() {
        super.onRestart()
        finishAffinity()
    }

}