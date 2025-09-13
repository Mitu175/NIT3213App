package com.example.nit3213app.model

data class Artwork(
    val artworkTitle: String,
    val artist: String,
    val medium: String,
    val year: Int,
    val description: String
)

data class DashboardResponse(
    val entities: List<Artwork>,
    val entityTotal: Int
)
