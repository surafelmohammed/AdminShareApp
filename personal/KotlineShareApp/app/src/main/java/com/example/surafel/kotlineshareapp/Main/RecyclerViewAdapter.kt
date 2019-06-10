package com.example.surafel.kotlineshareapp.Main

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.recycler_view_cell.view.*
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.MainActivity
import com.example.surafel.kotlineshareapp.network.NetworkData
import kotlin.coroutines.coroutineContext

class AdapterRV(test:List<NetworkData>,val parentFragment:MainReportFragment) : RecyclerView.Adapter<AdapterRV.myViewHolder>() {

    private var reportedData: List<NetworkData> = test
    private var count = 0




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_cell,parent,false) as View

        view.iv_more.setOnClickListener {
            count = count +1
            if(count%2!=0){
                view.hidden_item.visibility = LinearLayout.VISIBLE
                view.iv_more.setImageResource(R.drawable.less)
            }else {
                view.hidden_item.visibility = LinearLayout.GONE
                view.iv_more.setImageResource(R.drawable.more)
            }
        }

        view.setOnClickListener {
            view.findNavController().navigate(R.id.mainReportDetailFragment4)
        }
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reportedData.size //modkData.size for mock data object
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val data = reportedData[position]
        val fragmentDetail = MainReportDetailFragment()

        holder.view.title.text = data.title//mockData[position]. for  mock data object
        holder.view.subtitle.text = data.body

//        holder.view.setOnClickListener {
//            parentFragment.beginTransaction()
//                .replace(R.id.fl_main_fragment,fragmentDetail)
//                .commit()
//
//        }
    }

    fun setReportData(reportedData: List<ReportedData>){
        notifyDataSetChanged()
    }

    class myViewHolder(val view:View): RecyclerView.ViewHolder(view)

    //    val mockData= listOf(
//        ReportedData(
//            1,
//            true,
//            "Android Kotlin1",
//            " This book is all about android ha ha This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            2,
//            true,
//            "Android Kotlin2",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),parentFragment
//        ReportedData(
//            3,
//            true,
//            "Android Kotlin3",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            4,
//            true,
//            "Android Kotlin4",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            5,
//            true,
//            "Android Kotlin5",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            6,
//            true,
//            "Android Kotlin6",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            7,
//            true,
//            "Android Kotlin7",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            8,
//            true,
//            "Android Kotlin8",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            9,
//            true,
//            "Android Kotlin9",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            10,
//            true,
//            "Android Kotlin10",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        ),
//        ReportedData(
//            11,
//            true,
//            "Android Kotlin11",
//            "This book is all about android ha ha",
//            "pdf",
//            "University"
//        )
//       )
}