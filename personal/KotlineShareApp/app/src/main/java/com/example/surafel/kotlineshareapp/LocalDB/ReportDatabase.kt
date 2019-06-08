package com.example.surafel.kotlineshareapp.LocalDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ReportedData::class), version = 1)
abstract class ReportDatabase: RoomDatabase() {

    abstract fun getDao(): ReportedDataDao

    companion object {

        @Volatile
        private var INSTANCE: ReportDatabase? = null

        fun getDatabase(context: Context): ReportDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReportDatabase::class.java, "ReportDatabase"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}