package com.example.mover.model.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "mover_table")
data class Mover (
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name="image_name")
    var imageName: String = "placeholder",

    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "money_owed")
    var moneyOwed: Double?
) : Parcelable
