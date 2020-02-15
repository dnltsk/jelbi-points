package com.example.jelbihackathon

import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.tapadoo.alerter.Alerter

fun showDialog1(context:Context){
    with(AlertDialog.Builder(context)){//,R.style.MyAlertDialogStyle)){
        setTitle("+2 Minuten – 30% billiger")
        setMessage("Hey, möchtest du den Scooter an einem 2 minuten" +
                " entfernten Ort abstellen und dafür 30% weniger für die gesamte Fahrt zahlen?")
        setPositiveButton("Ok",null)
        setNeutralButton("Route anzeigen",null)
        setNegativeButton("Cancel",null)
        show()
    }
}
fun showConfetti(activity: Activity){

}
class InvisibleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invisible)
        Toast.makeText(applicationContext,"test toast activity",Toast.LENGTH_LONG).show()

        /*val LAYOUT_FLAG: Int
        LAYOUT_FLAG = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_PHONE
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            LAYOUT_FLAG,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )

        params.gravity = Gravity.TOP or Gravity.CENTER
        params.x = applicationContext.resources.displayMetrics.widthPixels / 2
        params.y = applicationContext.resources.displayMetrics.heightPixels / 2

        val view = ImageView(applicationContext)
        view.setImageResource(R.drawable.ic_launcher_background)
        view.setOnClickListener {
            applicationContext.t("lol clicked")
        }
        windowManager.addView(view, params)*/

    }
}
fun Context.t(s:String)=Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
fun Context.long(s:String)=Toast.makeText(this,s,Toast.LENGTH_LONG).show()