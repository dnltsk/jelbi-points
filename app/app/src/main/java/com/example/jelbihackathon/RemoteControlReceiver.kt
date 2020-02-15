package com.example.jelbihackathon

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.KeyEvent


class RemoteControlReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        TODO("wtf")
        context!!.t("test5: ${intent.getParcelableExtra<Parcelable>(Intent.EXTRA_KEY_EVENT) as? KeyEvent}")
        if (Intent.ACTION_MEDIA_BUTTON == intent.action) {
            val event: KeyEvent =
                intent.getParcelableExtra<Parcelable>(Intent.EXTRA_KEY_EVENT) as KeyEvent
            context!!.t("test ${event.keyCode}")
            if (KeyEvent.KEYCODE_VOLUME_DOWN === event.getKeyCode()) { // Handle key press.
                context!!.t("test2 ${event.keyCode}")
            }
        }
    }
}