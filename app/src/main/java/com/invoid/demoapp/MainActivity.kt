package com.invoid.demoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.invoid.androidsdk.StartSDK
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this ,  StartSDK::class.java)

        startSDK.setOnClickListener {
            startActivityForResult(intent , REQUEST_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_CODE -> {
                var success: Boolean
                try {
                    success = data!!.getBooleanExtra("success" , false);
                    Log.d("MainActivity", "Response " + success)
                    textView.text = resources.getString(R.string.respText)
                    textView.textSize = 20F
                    textView3.visibility = View.GONE
                    imageView3.setImageResource(R.drawable.success)
                    startSDK.visibility = View.GONE
                } catch (e: NullPointerException) {
                    e.printStackTrace()
                }
            }
        }
    }

}