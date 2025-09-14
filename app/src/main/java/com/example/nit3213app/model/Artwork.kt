package com.example.nit3213app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artwork(
    val artworkTitle: String,
    val artist: String,
    val medium: String,
    val year: Int,
    val description: String
) : Parcelable
