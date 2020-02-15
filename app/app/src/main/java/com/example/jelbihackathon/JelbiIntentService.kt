package com.example.jelbihackathon

import android.R
import android.app.IntentService
import android.content.DialogInterface
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog



const val TAG_INTENT_SERVICE="kek"
class JelbiIntentService:IntentService("JelbiIntentService") {

    // Invoked when this intent service is started.
    override fun onHandleIntent(intent: Intent?) {
        Log.d(
            TAG_INTENT_SERVICE,
            "onhandleintent"
        )
        applicationContext.t("lol intent service")
        Toast.makeText(applicationContext,"testXD",Toast.LENGTH_LONG).show()

        SystemClock.sleep(5000)
        dialog()
        applicationContext.t("test after")
        if (intent != null) { // Get current child thread.
            val currThread = Thread.currentThread()
            // Get current thread info.


        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(
            TAG_INTENT_SERVICE,
            "MyIntentService onCreate() method is invoked."
        )
    }
    fun dialog(){
        startActivity(Intent(this,InvisibleActivity::class.java).also {
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            it.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        })
        /*
        AlertDialog.Builder(applicationContext)
            .setTitle("Delete entry")
            .setMessage("Are you sure you want to delete this entry?") // Specifying a listener allows you to take an action before dismissing the dialog.
// The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton(R.string.yes,
                { dialog, which ->
                    // Continue with delete operation
                }) // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton(R.string.no, null)
            .setIcon(R.drawable.ic_dialog_alert)
            .show()*/
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(
            TAG_INTENT_SERVICE,
            "MyIntentService onDestroy() method is invoked."
        )
    }
}