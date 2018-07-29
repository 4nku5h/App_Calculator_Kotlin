package com.example.nikhil.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.nikhil.calculator.R.id.action_bar_menu_info
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*



class MainActivity : AppCompatActivity() {
    var counter_name=0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menu_inflator:MenuInflater=menuInflater
        menu_inflator.inflate(R.menu.mein_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId==action_bar_menu_info){
            if(counter_name==0){
                my_name_layout.visibility=View.VISIBLE
                counter_name=1
            }
            else
            if(counter_name==1){
                my_name_layout.visibility=View.INVISIBLE
                counter_name=0
            }

        }




        return true

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    var old_number:String=""
     var operator=""
    var is_operator_pressed:Boolean=false
    var dot_added=false
    var front_minus_added=false

    fun btn_number_event(view: View){
        if(operator!=""){

            front_minus_added=false
        }

        var btn_select:Button=view as Button
                 // current

        if(is_operator_pressed==true){
            edit_text_result.setText("")
        }
        var btn_click_value:String=edit_text_result.text.toString()

        is_operator_pressed=false
        when(btn_select.id){
            btn_0.id->{
                btn_click_value+="0"

            }
            btn_1.id->{
                btn_click_value+="1"

            }
            btn_2.id->{
                btn_click_value+="2"

            }
            btn_3.id->{
                btn_click_value+="3"

            }
            btn_4.id->{
                btn_click_value+="4"

            }
            btn_5.id->{
                btn_click_value+="5"

            }
            btn_6.id->{
                btn_click_value+="6"

            }
            btn_7.id->{
                btn_click_value+="7"

            }
            btn_8.id->{
                btn_click_value+="8"

            }
            btn_9.id->{
                btn_click_value+="9"

            }
            // prevent more then 1 dot
            btn_dot.id->{
                if(dot_added==false){

                btn_click_value+="."
                    dot_added=true
                }

            }
            btn_plus_mins.id->{
                if(front_minus_added==false){

                    btn_click_value="-"+btn_click_value
                    front_minus_added=true
                }

            }






        }
     edit_text_result.setText(btn_click_value)



    }


    // runs for perform operation
    fun btn_operation_event(view:View){
        val op_id=view as Button
        when(op_id){



            btn_mul->{
                operator="*"
            }
            btn_divide->{
                operator="/"

            }
            btn_mins->{
                operator="-"

            }
            btn_sum->{
                operator="+"

            }


        }
        old_number=edit_text_result.text.toString()
        is_operator_pressed=true

         dot_added=false





    }
    fun btn_eql_event(view:View){

        var new_number=edit_text_result.text.toString()
        var final_number:Double?=null


        when(operator){
            "*"->{
                final_number=old_number.toDouble()*new_number.toDouble()

            }
            "/"->{

                final_number=old_number.toDouble()/new_number.toDouble()
            }
            "-"->{

                final_number=old_number.toDouble()-new_number.toDouble()
            }
            "+"-> {
                final_number = old_number.toDouble() + new_number.toDouble()

            }
            else->{

                final_number=edit_text_result.text.toString().toDouble()
            }


        }

try {

    if((old_number.toInt()+new_number.toInt())<0){

        front_minus_added=true
    }
    edit_text_result.setText(final_number.toString())
    old_number = final_number.toString()
    dot_added=false

    operator=""
}
catch (ex:Exception){
print(ex.message)

}
    }
    fun btn_clean_event(view: View){          // this runs when AC button is pressed
        dot_added=false
        front_minus_added=false
        edit_text_result.setText("0")
        old_number=""
        is_operator_pressed=false

    }
    fun btn_percent_event(view: View){

        val number=edit_text_result.text.toString().toDouble()/100
        old_number=number.toString()
        edit_text_result.setText(number.toString())
    }
}
