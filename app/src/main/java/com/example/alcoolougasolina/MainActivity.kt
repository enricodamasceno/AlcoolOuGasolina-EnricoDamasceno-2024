package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    var gasolinaText:String = ""
    var alcoolText:String = ""
    var gasolina:Double = 0.0
    var alcool:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual = savedInstanceState.getDouble("percentual")
            gasolina = savedInstanceState.getDouble("gasolina")
            alcool = savedInstanceState.getDouble("alcool")
        }
        Log.i("PDM24.1","No onCreate, $percentual")

        val swPercent: Switch = findViewById(R.id.swPercentual)

        swPercent.setOnCheckedChangeListener { _, isChecked ->
            percentual = if (isChecked) {
                0.75
            } else {
                0.7
            }
        }

        val btCalc:Button = findViewById(R.id.btCalcular)
        val textMsg:TextView= findViewById(R.id.textMsg)

        // Código do evento:
        btCalc.setOnClickListener(View.OnClickListener {

            // Inicializando as variáveis dos preços:
            gasolinaText = findViewById<EditText>(R.id.edGasolina).text.toString()
            alcoolText = findViewById<EditText>(R.id.edAlcool).text.toString()

            gasolina = gasolinaText.toDoubleOrNull() ?: 0.0
            alcool = alcoolText.toDoubleOrNull() ?: 0.0

            if (alcool <= percentual * gasolina) {
                textMsg.text = "O álcool terá um rendimento maior."
            } else {
                textMsg.text = "A gasolina terá um rendimento maior."
            }

            Log.d("PDM24","No btCalcular, $percentual, $gasolina, $alcool")
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
override fun onSaveInstanceState(outState: Bundle) {
    outState.putDouble("percentual", percentual)
    outState.putDouble("gasolina", gasolina)
    outState.putDouble("alcool", alcool)
    super.onSaveInstanceState(outState)
}
}
