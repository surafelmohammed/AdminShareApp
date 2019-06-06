package com.example.surafel.kotlineshareapp.Splash


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.fragment_splash_fragment3.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SplashFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash_fragment3, container, false)
        val imageView = view.iv_fragment3_header
        Glide.with(view.context).load(R.drawable.patterns).into(imageView)
        return view
    }


}
