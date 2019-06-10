package com.example.surafel.kotlineshareapp.Main


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import com.example.surafel.kotlineshareapp.network.NetworkData
import kotlinx.android.synthetic.main.fragment_main_report_detail.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainReportDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_report_detail, container, false)
        val textOne = arguments.getBundle("title").toString()
        view.title.text = Bundle().getString("title")
        view.body.text = Bundle().getString("body")
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }


}
