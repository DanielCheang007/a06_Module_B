package edu.worldskills.fourcity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class AlbumFragment : Fragment() {

    private lateinit var activity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_album, container, false)
        val albumWrapperLinearLayout = view.findViewById<LinearLayout>(R.id.albumWrapperLinearLayout)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, 50)

        for(i in 1..3) {
            val albumCity = layoutInflater.inflate(R.layout.album_city, null)
            val popUpImageView = albumCity.findViewById<ImageView>(R.id.popupImageView)
            popUpImageView.setOnClickListener {
                activity.showPopupWindow()
            }
            albumWrapperLinearLayout.addView(albumCity, layoutParams)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity
    }
}