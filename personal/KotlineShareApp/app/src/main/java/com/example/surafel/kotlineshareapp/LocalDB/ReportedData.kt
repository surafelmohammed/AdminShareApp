package com.example.surafel.kotlineshareapp.LocalDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fileReport")
data class ReportedData(@PrimaryKey @ColumnInfo(name = "fileId") val id:Int,
                        @ColumnInfo(name = "report")val report:Boolean,
                        @ColumnInfo(name = "name") val file_name:String,
                        @ColumnInfo(name = "description") val file_description:String,
                        @ColumnInfo(name = "filetype")val file_type:String,
                        @ColumnInfo(name = "target")val target:String):Serializable