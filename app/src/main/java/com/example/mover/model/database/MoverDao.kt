package com.example.mover.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mover.Network.Mover

@Dao
interface MoverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mover: Mover)

    @Query("SELECT * FROM mover_table WHERE id = :key")
    suspend fun get(key: Int): Mover?

    @Query("SELECT * FROM mover_table ORDER BY id DESC")
    fun getAll(): LiveData<List<Mover>>

}