package com.zaketn.quadraticequation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View) {
        val aInput: EditText = findViewById(R.id.varAInput)
        val bInput: EditText = findViewById(R.id.varBInput)
        val cInput: EditText = findViewById(R.id.varCInput)
        val resultText: TextView = findViewById(R.id.resultText)

        try {
            val quadraticEquation = QuadraticEquation(
                aInput.text.toString().toFloat(),
                bInput.text.toString().toFloat(),
                cInput.text.toString().toFloat()
            )

            val roots = quadraticEquation.findRoots();

            if (roots[1] == 0f) resultText.text = getString(R.string.result_single_root_text, "%.1f".format(roots[0]))
            else resultText.text = getString(R.string.result_text,"%.1f".format(roots[0]),"%.1f".format(roots[1]))
        } catch (e: IllegalArgumentException) {
            resultText.text = "Корней нет."
        }
        resultText.visibility = View.VISIBLE
    }
}