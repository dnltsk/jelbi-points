package com.example.jelbihackathon

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast


class InterceptorService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(baseContext, "onCreate", Toast.LENGTH_LONG).show()
        //mView = HUDView(this)
        val view = ImageView(applicationContext)
        view.setImageResource(R.drawable.ic_launcher_background)
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
            PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.RIGHT or Gravity.TOP
        params.title = "Load Average"
        val wm =
            getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.addView(view,params)
        view.setOnClickListener {
            Toast.makeText(applicationContext,"lolol",Toast.LENGTH_SHORT).show()
        }
        //wm.addView(mView, params)
    }

    fun onTouchEvent(event: MotionEvent?): Boolean { // ATTENTION: GET THE X,Y OF EVENT FROM THE PARAMETER
// THEN CHECK IF THAT IS INSIDE YOUR DESIRED AREA
        Toast.makeText(applicationContext, "onTouchEvent"+event?.x+"::"+event?.y, Toast.LENGTH_LONG).show()
        return true
    }
}