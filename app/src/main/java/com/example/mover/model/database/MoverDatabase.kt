package com.example.mover.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mover.Network.Mover
import com.example.mover.utils.Constants

@Database(entities = [Mover::class], version = 1, exportSchema = false)
abstract class MoverDatabase : RoomDatabase() {

    abstract val moverDao: MoverDao

    companion object {
        @Volatile private var instance: MoverDatabase? = null

        fun getInstance(context: Context): MoverDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): MoverDatabase {
            return Room.databaseBuilder(context, MoverDatabase::class.java, Constants.DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }
                )
                .build()
        }


    }

}