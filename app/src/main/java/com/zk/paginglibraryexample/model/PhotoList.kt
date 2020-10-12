package com.zk.paginglibraryexample.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.zk.paginglibraryexample.model.Photo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoList(
    @SerializedName("hits")
    val photos: List<Photo>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int) : Parcelable


