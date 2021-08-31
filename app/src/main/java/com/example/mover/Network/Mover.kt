package com.example.mover.Network

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

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name= "email")
    var email: String,

    @ColumnInfo(name= "phone_number")
    var phoneNumber: String,

    @ColumnInfo(name = "money_owed")
    var moneyOwed: Double?

) : Parcelable


