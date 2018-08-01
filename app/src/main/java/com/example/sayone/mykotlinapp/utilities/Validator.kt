package com.example.sayone.mykotlinapp.utilities

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.fragment_register.view.*
import java.util.regex.Pattern

/**
 * Created by Jeslin on 29 june 2018.

 * insteam of calling AddTextChange listner on all the edit text seperately
   we can create a common class that can get a view as parameter and check the view id
   in a switch case and do the actions accordingly

 */



class Validator(itemView: View,layoutView:View) : TextWatcher {

    val EMAILREGX = "[a-zA-Z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#\$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?"
    val PHONEREGX = "^[7-9][0-9]{9}$"
    val NAMEREGX = "[A-Za-z]{1,10}"
    private var mItemView = itemView
    private var mView=layoutView


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        var b:Int =10
    }

    override fun afterTextChanged(s: Editable?) {
        var textTovalidate: String = s.toString()

//         alternative for switch case in java
//         comparing with the id of view
        when (mItemView.id) {

            mView.reg_email_edt.id ->   if (!validateEmail(textTovalidate))
                                        mView.reg_email_edt.error = "incorrect email"


            mView.reg_phone_edt.id ->   if (!validatePhone(textTovalidate))
                                        mView.reg_phone_edt.error = "incorrect phone number"

            mView.reg_name_edt.id ->    if (!validateName(textTovalidate))
                                        mView.reg_name_edt.error = "incorrect name format"

        }
    }

    fun validateEmail(emailStr: String): Boolean {
        return Pattern.compile(EMAILREGX).matcher(emailStr).matches()

    }

    fun validateName(nameStr: String): Boolean {
        return Pattern.compile(NAMEREGX).matcher(nameStr).matches()

    }

    fun validatePhone(phoneStr: String): Boolean {
        return Pattern.compile(PHONEREGX).matcher(phoneStr).matches()

    }

}