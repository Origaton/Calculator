package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberButtons()
        operationButtons()
        deleteButtons()
        otherButtons()
    }

    private var intNumber1: Long = 0
    private var intNumber2: Long = 0
    private var operation: Char = ' '
    private val signs = arrayOf("+", "-", "x", "/")

    private fun numberButtons() {
        findViewById<Button>(R.id.zeroBtn).setOnClickListener {
            setFirstTextFields("0")
        }
        findViewById<Button>(R.id.oneBtn).setOnClickListener {
            setFirstTextFields("1")
        }
        findViewById<Button>(R.id.twoBtn).setOnClickListener {
            setFirstTextFields("2")
        }
        findViewById<Button>(R.id.threeBtn).setOnClickListener {
            setFirstTextFields("3")
        }
        findViewById<Button>(R.id.fourBtn).setOnClickListener {
            setFirstTextFields("4")
        }
        findViewById<Button>(R.id.fiveBtn).setOnClickListener {
            setFirstTextFields("5")
        }
        findViewById<Button>(R.id.sixBtn).setOnClickListener {
            setFirstTextFields("6")
        }
        findViewById<Button>(R.id.sevenBtn).setOnClickListener {
            setFirstTextFields("7")
        }
        findViewById<Button>(R.id.eightBtn).setOnClickListener {
            setFirstTextFields("8")
        }
        findViewById<Button>(R.id.nineBtn).setOnClickListener {
            setFirstTextFields("9")
        }
    }

    private fun deleteButtons() {
        findViewById<Button>(R.id.deleteBtn).setOnClickListener {
            findViewById<TextView>(R.id.firstTextField).text = ""
            findViewById<TextView>(R.id.secondTextField).text = ""
            intNumber1 = 0
            intNumber2 = 0
        }
        findViewById<Button>(R.id.delBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()) {
                findViewById<TextView>(R.id.firstTextField).text = findViewById<TextView>(R.id.firstTextField).text.substring(0, findViewById<TextView>(R.id.firstTextField).text.length - 1)
            }
        }
    }

    private fun operationButtons() {
        findViewById<Button>(R.id.plusBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.secondTextField).text.isNotEmpty()){
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[0])) {
                    secondVar()
                    moreAction('A')
                    setSecondTextFields(signs[0])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[1])) {
                    secondVar()
                    moreAction('B')
                    setSecondTextFields(signs[0])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[2])) {
                    secondVar()
                    moreAction('C')
                    setSecondTextFields(signs[0])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[3])) {
                    secondVar()
                    moreAction('D')
                    setSecondTextFields(signs[0])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
            if (findViewById<TextView>(R.id.secondTextField).text.isEmpty()) {
                if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()) {
                    firstVar()
                    findViewById<TextView>(R.id.secondTextField).text = intNumber1.toString()
                    setSecondTextFields(signs[0])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
        }
        findViewById<Button>(R.id.minusBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.secondTextField).text.isNotEmpty()){
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[1])) {
                    secondVar()
                    moreAction('B')
                    setSecondTextFields(signs[1])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[0])) {
                    secondVar()
                    moreAction('A')
                    setSecondTextFields(signs[1])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[2])) {
                    secondVar()
                    moreAction('C')
                    setSecondTextFields(signs[1])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[3])) {
                    secondVar()
                    moreAction('D')
                    setSecondTextFields(signs[1])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
            if(findViewById<TextView>(R.id.secondTextField).text.isEmpty()){
                if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()){
                    firstVar()
                    findViewById<TextView>(R.id.secondTextField).text = intNumber1.toString()
                    setSecondTextFields(signs[1])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
        }
        findViewById<Button>(R.id.multiBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.secondTextField).text.isNotEmpty()){
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[2])) {
                    secondVar()
                    moreAction('C')
                    setSecondTextFields(signs[2])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[0])) {
                    secondVar()
                    moreAction('A')
                    setSecondTextFields(signs[2])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[1])) {
                    secondVar()
                    moreAction('B')
                    setSecondTextFields(signs[2])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[3])) {
                    secondVar()
                    moreAction('D')
                    setSecondTextFields(signs[2])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
            if (findViewById<TextView>(R.id.secondTextField).text.isEmpty()) {
                if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()) {
                    firstVar()
                    findViewById<TextView>(R.id.secondTextField).text = intNumber1.toString()
                    setSecondTextFields(signs[2])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
        }
        findViewById<Button>(R.id.divBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.secondTextField).text.isNotEmpty()){
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[3])) {
                    secondVar()
                    moreAction('D')
                    setSecondTextFields(signs[3])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[0])) {
                    secondVar()
                    moreAction('A')
                    setSecondTextFields(signs[3])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[1])) {
                    secondVar()
                    moreAction('B')
                    setSecondTextFields(signs[3])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[2])) {
                    secondVar()
                    moreAction('C')
                    setSecondTextFields(signs[3])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
            if (findViewById<TextView>(R.id.secondTextField).text.isEmpty()) {
                if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()) {
                    firstVar()
                    findViewById<TextView>(R.id.secondTextField).text = intNumber1.toString()
                    setSecondTextFields(signs[3])
                    findViewById<TextView>(R.id.firstTextField).text = ""
                }
            }
        }
        findViewById<Button>(R.id.resultBtn).setOnClickListener {
            if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()){
                secondVar()
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[0])){
                    result('A')
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[1])){
                    result('B')
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[2])){
                    result('C')
                }
                if (findViewById<TextView>(R.id.secondTextField).text.endsWith(signs[3])){
                    result('D')
                }
                findViewById<TextView>(R.id.secondTextField).text = ""
            }
        }
    }

    private fun otherButtons() {
        findViewById<Button>(R.id.plusMinusBtn).setOnClickListener {
           // if (findViewById<TextView>(R.id.firstTextField).text.isNotEmpty()) {
           //}
        }
    }

    private fun setFirstTextFields(digit: String) {
        findViewById<TextView>(R.id.firstTextField).append(digit).toString()
    }

    private fun setSecondTextFields(sign: String) {
        findViewById<TextView>(R.id.secondTextField).append(sign).toString()
    }

    private fun firstVar() {
        intNumber1 = findViewById<TextView>(R.id.firstTextField).text.toString().toLong()
    }

    private fun secondVar() {
        intNumber2 = findViewById<TextView>(R.id.firstTextField).text.toString().toLong()
    }

    private fun moreAction(char: Char) {
        operation = char
        if (operation == 'A') {
             val temporarySum = sumOperation(intNumber1, intNumber2)
            intNumber1 = temporarySum
            Log.d("Log", "а тут $intNumber1")
            intNumber2 = 0
            findViewById<TextView>(R.id.secondTextField).text = temporarySum.toString()
        }
        if (operation == 'B') {
             val temporaryMin = minOperation(intNumber1, intNumber2)
            intNumber1 = temporaryMin
            Log.d("Log", "а тут $intNumber1")
            intNumber2 = 0
            findViewById<TextView>(R.id.secondTextField).text = temporaryMin.toString()
        }
        if (operation == 'C') {
             val temporaryMul = mulOperation(intNumber1, intNumber2)
            intNumber1 = temporaryMul
            Log.d("Log", "а тут $intNumber1")
            intNumber2 = 0
            findViewById<TextView>(R.id.secondTextField).text = temporaryMul.toString()
        }
        if (operation == 'D') {
             val temporaryDiv = divOperation(intNumber1, intNumber2)
            intNumber1 = temporaryDiv
            Log.d("Log", "а тут $intNumber1")
            intNumber2 = 0
            findViewById<TextView>(R.id.secondTextField).text = temporaryDiv.toString()
        }
    }

    private fun result(char: Char) {
        operation = char
        if (operation == 'A') {
            val sum = sumOperation(intNumber1, intNumber2)
            intNumber1 = 0
            intNumber2 = 0
            findViewById<TextView>(R.id.firstTextField).text = sum.toString()
        }
        if (operation == 'B') {
            val min = minOperation(intNumber1, intNumber2)
            intNumber1 = 0
            intNumber2 = 0
            findViewById<TextView>(R.id.firstTextField).text = min.toString()
        }
        if (operation == 'C') {
            val mul = mulOperation(intNumber1, intNumber2)
            intNumber1 = 0
            intNumber2 = 0
            findViewById<TextView>(R.id.firstTextField).text = mul.toString()
        }
        if (operation == 'D') {
            val div = divOperation(intNumber1, intNumber2)
            intNumber1 = 0
            intNumber2 = 0
            findViewById<TextView>(R.id.firstTextField).text = div.toString()
        }
    }

    private fun sumOperation(intNumber1: Long, intNumber2: Long): Long {
        return intNumber1 + intNumber2
    }

    private fun minOperation(intNumber1: Long, intNumber2: Long): Long {
        return intNumber1 - intNumber2
    }

    private fun mulOperation(intNumber1: Long, intNumber2: Long): Long {
        return intNumber1 * intNumber2
    }

    private fun divOperation(intNumber1: Long, intNumber2: Long): Long {
        return intNumber1 / intNumber2
    }
}