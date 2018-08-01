package com.example.sayone.mykotlinapp.app.login.registration

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.sayone.mykotlinapp.R
import com.example.sayone.mykotlinapp.app.AppClass
import com.example.sayone.mykotlinapp.app.homepage.HomePage
import com.example.sayone.mykotlinapp.model.Person
import com.example.sayone.mykotlinapp.utilities.Dbhandler
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_login, container, false)


        view.login_ok.setOnClickListener {

            val dbHandler = Dbhandler(view.context)

//           login without using SQL light
//            if((view.login_email_edt.text.toString().equals(loginPerson.email))
//                and (view.login_pass_edt.text.toString().equals(loginPerson.password))){
//                Toast.makeText(context,"log in success",Toast.LENGTH_LONG).show()
//                val intent = Intent(context,HomePage::class.java)
//                startActivity(intent)
//            }else
//                Toast.makeText(context,"log in failed ",Toast.LENGTH_LONG).show()

            var result = dbHandler.getUser(view.login_email_edt.text.toString(), view.login_pass_edt.text.toString())
            if (result)
                Toast.makeText(context,"log in success",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(context,"log in failed ",Toast.LENGTH_LONG).show()
        }

        return view
    }


}
