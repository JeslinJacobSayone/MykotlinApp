package com.example.sayone.mykotlinapp.app.login.registration

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.example.sayone.mykotlinapp.R
import com.example.sayone.mykotlinapp.app.AppClass
import com.example.sayone.mykotlinapp.utilities.Validator

import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view:View= inflater.inflate(R.layout.fragment_register, container, false)


        var emailEdt: EditText =view.reg_email_edt
        var phoneEdt: EditText = view.reg_phone_edt
        var nameEdt: EditText =view.reg_name_edt
        // call the validator class from inside and pass the view

        view.reg_email_edt.addTextChangedListener(Validator(emailEdt, view))

        view.reg_name_edt.addTextChangedListener(Validator(nameEdt, view))

        view.reg_phone_edt.addTextChangedListener(Validator(phoneEdt, view))

        view.reg_ok_btn.setOnClickListener{

            var nameStr = view.reg_name_edt.text.toString()
            var emailStr:String = view.reg_email_edt.text.toString()
            var passStr:String=view.reg_pass_edt.text.toString()
            var phoneStr:String=view.reg_phone_edt.text.toString()

            AppClass.getApp().setPerson(nameStr,emailStr,phoneStr,passStr)

        }

        return view
    }






}
