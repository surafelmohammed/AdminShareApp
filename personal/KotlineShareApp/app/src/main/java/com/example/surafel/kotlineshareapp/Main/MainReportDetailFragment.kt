package com.example.surafel.kotlineshareapp.Main


import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import com.example.surafel.kotlineshareapp.network.NetworkData
import com.example.surafel.kotlineshareapp.network.ReportApiService
import kotlinx.android.synthetic.main.fragment_main_report_detail.*
import kotlinx.android.synthetic.main.fragment_main_report_detail.view.*
import kotlinx.android.synthetic.main.fragment_main_report_detail.view.title
import kotlinx.android.synthetic.main.recycler_view_cell.view.*
import retrofit2.Call
import java.lang.Exception

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

        view.title.text = arguments?.getString("title")
        view.body.text = arguments?.getString("body")

        view.btn_file_delete.setOnClickListener {
            findNavController().navigate(R.id.mainReportFragment4)
            try {
                ReportApiService.getInstance().deleteReport(arguments!!.getInt("id"))
                findNavController().navigate(R.id.mainReportFragment4)
            }catch (e:Exception)
            {
                findNavController().navigate(R.id.mainReportFragment4)
            }

        }
        view.file_download.setOnClickListener {
            progressDialog("Downloading")
        }
        view.file_view.setOnClickListener {

        }

        view.btn_remove_file.setOnClickListener {
            findNavController().navigate(R.id.mainReportFragment4)
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    fun progressDialog(message:String)
    {
        val pDialog = ProgressDialog(context)
        pDialog.setTitle(message)
        pDialog.setMessage("please wait.")
        pDialog.show()
    }

}
