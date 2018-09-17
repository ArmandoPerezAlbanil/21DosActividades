package com.example.armandoedge.a21dosactividades

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    // EditText view for the message
    private var mMessageEditText: EditText? = null
    // TextView for the reply header
    private var mReplyHeadTextView: TextView? = null
    // TextView for the reply body
    private var mReplyTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }
    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this,Main2Activity::class.java)
        val message = mMessageEditText!!.text.toString()

        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Test for the right intent reply
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(Main2Activity.EXTRA_REPLY)

                // Make the reply head visible.
                mReplyHeadTextView!!.visibility = View.VISIBLE

                // Set the reply and make it visible.
                mReplyTextView!!.text = reply
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        // Class name for Log tag
        private val LOG_TAG = MainActivity::class.java.simpleName
        // Unique tag required for the intent extra
        val EXTRA_MESSAGE = "com.example.android.DosActividades.extra.MESSAGE"
        // Unique tag for the intent reply
        val TEXT_REQUEST = 1
    }
}

