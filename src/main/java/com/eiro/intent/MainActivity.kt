package com.eiro.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eiro.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            // Create the text message with a string.
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.editTextTextPersonName.text.toString())
                type = "text/plain"
            }

            val chooser: Intent = Intent.createChooser(sendIntent, "Chooser")

            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }
    }
}