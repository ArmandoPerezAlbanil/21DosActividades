package com.example.armandoedge.a21dosactividades

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText



class Main2Activity : AppCompatActivity() {

    // EditText for the reply.
    private var mReply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Initialize view variables.
        mReply = findViewById(R.id.editText_second)

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        val intent = intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        // Put that message into the text_message TextView
        val textView = findViewById<View>(R.id.text_message) as TextView
        if (textView != null) {
            textView.text = message
        }
    }

    fun returnReply(view: View) {
        // Get the reply message from the edit text.
        val reply = mReply!!.text.toString()

        // Create a new intent for the reply, add the reply message to it as an extra,
        // set the intent result, and close the activity.
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        // Unique tag for the intent reply.
        val EXTRA_REPLY = "com.example.android.DosActividades.extra.REPLY"
    }
}
