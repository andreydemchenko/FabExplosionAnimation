package ru.turbopro.fabexplosionanim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import ru.turbopro.fabexplosionanim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explosion_anim).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.floatingActionButton.setOnClickListener {
            binding.floatingActionButton.isVisible = false
            binding.view.isVisible = true
            binding.view.startAnimation(animation) {
                //binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
                binding.view.isVisible = false
                startActivity(Intent(this, SecondActivity::class.java))
                binding.floatingActionButton.isVisible = true
            }
        }
    }
}