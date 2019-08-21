package com.example.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvZero.setOnClickListener{
            appendOnExpression("0",true)
        }
        tv1.setOnClickListener{
            appendOnExpression("1",true)
        }
        tv2.setOnClickListener{
            appendOnExpression("2",true)
        }
        tv3.setOnClickListener{
            appendOnExpression("3",true)
        }
        tv4.setOnClickListener{
            appendOnExpression("4",true)
        }
        tv5.setOnClickListener{
            appendOnExpression("5",true)
        }
        tv6.setOnClickListener{
            appendOnExpression("6",true)
        }
        tv7.setOnClickListener{
            appendOnExpression("7",true)
        }
        tv8.setOnClickListener{
            appendOnExpression("8",true)
        }
        tv9.setOnClickListener{
            appendOnExpression("9",true)
        }
        tvDot.setOnClickListener{
            appendOnExpression(".",true)
        }

        //Operators
        tvPlus.setOnClickListener{
            appendOnExpression("+",false)
        }
        tvMinus.setOnClickListener{
            appendOnExpression("-",false)
        }
        tvMultiply.setOnClickListener{
            appendOnExpression("x",false)
        }
        tvDivide.setOnClickListener{
            appendOnExpression("/",false)
        }
        tvCloseParentheses.setOnClickListener{
            appendOnExpression(")",false)
        }
        tvOpenParentheses.setOnClickListener{
            appendOnExpression("(",false)
        }

        tvCE.setOnClickListener{
            tvResult.text = ""
            tvExpression.text = ""
        }
        tvBack.setOnClickListener{
            if (tvExpression.text.isNotEmpty()){
                tvExpression.text = tvExpression.text.substring(0, tvExpression.text.length-1)
            }
            tvResult.text = ""
        }
        Equals.setOnClickListener{
            try{
                val result = ExpressionParser().evaluate(tvExpression.text.toString())
                tvResult.text = result.toString()
            }
            catch (e:Exception){
                Log.d("Exception"," Message: " + e.message)
            }
        }
    }

    fun appendOnExpression(str: String, canClear: Boolean){
        if(canClear){
            tvResult.text = ""
            tvExpression.append(str)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(str)
            tvResult.text = ""
        }
    }
}
