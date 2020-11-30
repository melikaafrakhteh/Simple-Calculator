package com.afrakhteh.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
      //for buttom clear
    fun clear(view: View) {
          tv_mainactivity_result.setText(" 0 ")
          isNewOp = true
      }


    // for buttom Numbers
    var decimal:Boolean = false
    fun numBtnClick(view: View) {
        // if im waiting to enter operator if is true
        if(isNewOp){
           tv_mainactivity_result.text = ""
        }
        isNewOp = false
        val buttonSelected:Button = view as Button
        val getData =tv_mainactivity_result.text.toString()
        var buttonId:String = getData

        when(buttonSelected.id){

            R.id.btnzero -> {buttonId = "0"
                             getData}
            R.id.btnone -> {buttonId += "1"}
            R.id.btntwo -> {buttonId += "2"}
            R.id.btnthree -> {buttonId += "3"}
            R.id.btnfour -> {buttonId +="4"}
            R.id.btnfive -> {buttonId += "5"}
            R.id.btnsix -> {buttonId += "6"}
            R.id.btnseven -> {buttonId += "7"}
            R.id.btneight -> {buttonId += "8"}
            R.id.btnnine -> {buttonId += "9"}
            R.id.btnneg -> {buttonId = "-" + buttonId}
            R.id.btndot -> {
                if (decimal){
                    Toast.makeText(this,". is exist",Toast.LENGTH_SHORT).show()
                }
                else{
                    buttonId += "."
                    decimal = true
                }
            }
        }
        tv_mainactivity_result.text = buttonId
    }
    var op = "+"
    var number1 = ""
    var isNewOp = true

    fun operatorClick(view: View) {
        val selectedOp = view as Button
        when (selectedOp.id) {
            R.id.btnsum -> {
                op = "+"
                decimal = false
            }

            R.id.btnsub -> {
            op = "-"
            decimal = false
        }
            R.id.btnmul ->{
                op = "*"
                decimal = false
            }
            R.id.btndiv ->{
                op = "/"
                decimal = false
            }
        }


        number1 = tv_mainactivity_result.text.toString()
        isNewOp = true
    }
    fun equalButton(view: View) {
         var number2 = tv_mainactivity_result.text.toString()
        var finalNumber:Double? = null
        when(op){
            "+"-> finalNumber =  number2.toDouble()+ number1.toDouble()
            "-"-> finalNumber =  number2.toDouble() - number1.toDouble()
            "*"-> finalNumber =  number2.toDouble()* number1.toDouble()
            "/"->{
                if (number2.toDouble()!=0.0){
                    finalNumber = number1.toDouble() / number2.toDouble()
                }
                else {
                    tv_mainactivity_result.setText("NaN")
                }
            }
        }
        tv_mainactivity_result.text = finalNumber.toString()
        isNewOp = true
    }

    fun persentClick(view: View) {
        val percentRes = tv_mainactivity_result.text.toString().toDouble() /100
        tv_mainactivity_result.setText(percentRes.toString())
        isNewOp = true
    }
}
