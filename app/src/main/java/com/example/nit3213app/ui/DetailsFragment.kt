// File: com/example/nit3213app/ui/DetailsFragment.kt
package com.example.nit3213app.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nit3213app.R
import com.example.nit3213app.model.Artwork

class DetailsFragment : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artwork: Artwork? = arguments?.let {
            DetailsFragmentArgs.fromBundle(it).artwork
        }

        val titleText = view.findViewById<TextView>(R.id.textArtworkTitle)
        val artistText = view.findViewById<TextView>(R.id.textArtist)
        val mediumText = view.findViewById<TextView>(R.id.textMedium)
        val yearText = view.findViewById<TextView>(R.id.textYear)
        val descriptionText = view.findViewById<TextView>(R.id.textDescription)

        artwork?.let {
            titleText.text = it.artworkTitle
            artistText.text = it.artist
            mediumText.text = it.medium
            yearText.text = it.year.toString()
            descriptionText.text = it.description
        }
    }
}
