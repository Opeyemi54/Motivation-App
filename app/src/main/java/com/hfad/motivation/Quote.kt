package com.hfad.motivation

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user_table")
@Parcelize

data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    var title: String,
    var userQuote: String
) : Parcelable

