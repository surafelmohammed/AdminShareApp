package com.example.surafel.kotlineshareapp.Login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.surafel.kotlineshareapp.Main.MainReportFragment
import com.example.surafel.kotlineshareapp.R

class LoginFragment : Fragment() {

    private var listener: onLoginClick? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is onLoginClick) {
            listener = context
        } else {
            println("attachment error")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        val fragmentMain = MainReportFragment()

        val loginButton = view.findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {

            view.findNavController().navigate(R.id.mainReportFragment4,null)
        }

        return view
    }

    interface onLoginClick {
        fun loginCallback()
    }

}
