package edu.worldskills.fourcity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog

class EventFragment : Fragment() {

    private lateinit var finishedEventMenuImageView: ImageView
    private lateinit var qrLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        finishedEventMenuImageView = view.findViewById(R.id.finishEventMenuImageView)
        qrLayout = view.findViewById(R.id.qr_layout)

        val popupMenu = PopupMenu(context, finishedEventMenuImageView, 0)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        finishedEventMenuImageView.setOnClickListener {
            popupMenu.show()
        }

        qrLayout.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.qr_bottom_sheet, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(dialogView)
            dialog.show()
        }
        return view
    }
}