package com.example.surafel.kotlineshareapp.Main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.recycler_view_cell.view.*
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData

class AdapterRV() : RecyclerView.Adapter<AdapterRV.myViewHolder>() {

    private var reportedData: List<ReportedData> = emptyList()
    private var count = 0
    val mockData= listOf(
        ReportedData(
            1,
            true,
            "Android Kotlin1",
            " This book is all about android ha ha This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            2,
            true,
            "Android Kotlin2",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            3,
            true,
            "Android Kotlin3",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            4,
            true,
            "Android Kotlin4",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            5,
            true,
            "Android Kotlin5",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            6,
            true,
            "Android Kotlin6",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            7,
            true,
            "Android Kotlin7",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            8,
            true,
            "Android Kotlin8",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            9,
            true,
            "Android Kotlin9",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            10,
            true,
            "Android Kotlin10",
            "This book is all about android ha ha",
            "pdf",
            "University"
        ),
        ReportedData(
            11,
            true,
            "Android Kotlin11",
            "This book is all about android ha ha",
            "pdf",
            "University"
        )
       )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_cell,parent,false) as View

        view.setOnClickListener {

        }
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
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mockData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.view.title.text = mockData[position].file_name
        holder.view.subtitle.text = mockData[position].file_description
    }
    fun setReportData(reportedData: List<ReportedData>){
        this.reportedData = reportedData
        notifyDataSetChanged()
    }

    class myViewHolder(val view:View): RecyclerView.ViewHolder(view)

}