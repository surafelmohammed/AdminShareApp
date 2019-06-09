package com.example.surafel.kotlineshareapp.Login

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.surafel.kotlineshareapp.Main.MainFragment

import com.example.surafel.kotlineshareapp.R
import com.example.surafel.kotlineshareapp.Signup.SignUpFragment
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment : Fragment() {

    private var listener:onLoginClick?=null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is onLoginClick){
            listener = context
        }else{
            println("attachment error")
        }
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        val fragmentMain = MainFragment()

        val loginButton = view.findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            view.findNavController().navigate(R.id.mainFragment4)
        }
//        view.btn_login.setOnClickListener {
//            listener?.loginCallback()
//            activity?.supportFragmentManager!!.beginTransaction()
//                .add(R.id.fl_container,fragmentMain)
//                .addToBackStack(null)
//                .commit()
//        }
        return view
    }

    interface onLoginClick{
        fun loginCallback()
    }

}
