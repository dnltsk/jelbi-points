package com.example.jelbihackathon

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_main.*
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {

    private val PERMISSION: Int=2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //requestOverlayPermission()
        //showDialog1(this)
        showDialog1(this)
        //showNotification(this)
        //showNotification(this)
        /*doAfter5 {
            //showNotification(this)
            showDialog1(this)
        }*/

    }

    fun showNotification(context: Activity){

        with(Alerter.create(context)) {
            setTitle("Umfrage: Jelbi Station am Südkreuz")
            setBackgroundColorInt(Color.parseColor("#FAD201"))
            setTitleAppearance(R.style.MyAlertTitle)
            setTextAppearance(R.style.MyAlertText)
            setText("Möchtest du eine Jelbi Station am Südkreuz? Die Stationen mit" +
                    " dem meisten positiven Feedback entstehen innerhalb des nächsten Jahres")
            addButton("Info", R.style.ButtonStyleBlau, View.OnClickListener {
                context.t("Info")
            })
            addButton("Nein", R.style.ButtonStyle, View.OnClickListener {
                context.t("Nein")
            })
            addButton("Ja", R.style.ButtonStyle, View.OnClickListener {
                showConfetti()
            })
            //setBackgroundColorInt(Color.parseColor("#FAD201"))
            show()
        }
    }

    private fun requestOverlayPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        val myIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
        myIntent.data = Uri.parse("package:$packageName")
        startActivityForResult(myIntent, PERMISSION)

    }

    fun showConfetti(){
        viewKonfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(1000L)
            .addShapes(Shape.RECT, Shape.CIRCLE)
            .addSizes(Size(12))
            .setPosition(-50f, viewKonfetti.width + 50f, -50f, -50f)
            .streamFor(300, 3000L)
    }
}
val T="COUNTDOWN"
fun doAfter5(block: () -> Unit){
    1.doAsyncThrowOnUI {
        SystemClock.sleep(1000)
        Log.d(T,"1")
        SystemClock.sleep(1000)
        Log.d(T,"2")
        SystemClock.sleep(1000)
        Log.d(T,"3")
        SystemClock.sleep(1000)
        Log.d(T,"4")
        SystemClock.sleep(1000)
        Log.d(T,"5")
        SystemClock.sleep(1000)
        Log.d(T,"6")
        SystemClock.sleep(1000)
        Log.d(T,"7")
        SystemClock.sleep(1000)
        Log.d(T,"8")
        SystemClock.sleep(1000)
        Log.d(T,"9")
        SystemClock.sleep(1000)
        Log.d(T,"10")
        uiThread {
            block()
        }
    }
}

fun showDialog1(context:Context){
    with(AlertDialog.Builder(context)){//,R.style.MyAlertDialogStyle)){
        setTitle("+3 Minuten Fahrt – 20% billiger")
        setMessage("Hey, möchtest du den VW Crafter an einem Jelbi Point" +
                " abstellen?\nAls Dankeschön erhältst du 20% Nachlass auf die Fahrt.")
        setPositiveButton("Ok",null)
        setNeutralButton("Route anzeigen",null)
        setNegativeButton("Cancel",null)
        show()
    }
}

fun <T> T.doAsyncThrowOnUI(task: AnkoAsyncContext<T>.() -> Unit) = doAsync(
    exceptionHandler = { thr -> Handler(Looper.getMainLooper()).post { throw thr }},
    task = task)
