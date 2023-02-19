package com.example.playlist_maker_experiment

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.playlist_maker_experiment.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var searchBinding: ActivitySearchBinding
    companion object{
        const val TEXT_EDITTEXT = "TEXT_EDITTEXT"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_EDITTEXT, searchBinding.inputEditText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchBinding.inputEditText.setText(savedInstanceState.getString(TEXT_EDITTEXT))
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(searchBinding.root)

        searchBinding.backButton.setOnClickListener{
            finish()
        }

        searchBinding.clearButton.setOnClickListener{
            searchBinding.inputEditText.setText("")
            it.hideKeyboard()
        }

        val searchTextWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchBinding.clearButton.visibility = clearButtonVisibility(s)
            }

            override fun afterTextChanged(s: Editable?){}

        }
        searchBinding.inputEditText.addTextChangedListener(searchTextWatcher)

    }

    fun clearButtonVisibility(s: CharSequence?) : Int{
        return if(s.isNullOrEmpty()){
            View.GONE
        }else{
            View.VISIBLE
        }
    }
    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

}