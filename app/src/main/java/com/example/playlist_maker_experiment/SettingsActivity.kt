package com.example.playlist_maker_experiment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playlist_maker_experiment.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var settingsBinding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(settingsBinding.root)

        settingsBinding.backButtonSettingsActivity.setOnClickListener {
            finish()
        }

        settingsBinding.shareAppButton.setOnClickListener {
            Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app_link))
                type = "plain/text"
                startActivity(this)
            }
        }
        settingsBinding.writeSupportButton.setOnClickListener {
            Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.extra_text_write_email)))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.extra_text_write_support))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.extra_text_write_subject))
                startActivity(this)
            }
        }
        settingsBinding.termsUseButton.setOnClickListener {
            val termsUseButtonIntent = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    getString(R.string.terms_use_link)
                )
            )
            startActivity(termsUseButtonIntent)
        }
    }

}