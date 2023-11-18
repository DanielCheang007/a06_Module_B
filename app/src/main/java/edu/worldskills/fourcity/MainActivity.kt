package edu.worldskills.fourcity

import android.content.ClipData
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var popupWindowFrameLayout: FrameLayout
    private lateinit var closePopupWindowImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popupWindowFrameLayout = findViewById(R.id.popup_window)
        closePopupWindowImageView = findViewById(R.id.closePopupWindowImageView)
        bottomNavigationView = findViewById(R.id.bottomNav)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.event -> replaceFragment(EventFragment())
                R.id.cloud -> replaceFragment(AlbumFragment())
            }
            true
        }

        closePopupWindowImageView.setOnClickListener {
            closePopupWindow()
        }

        replaceFragment(EventFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
    }

    fun showPopupWindow() {
        popupWindowFrameLayout.visibility = View.VISIBLE
    }

    fun closePopupWindow() {
        popupWindowFrameLayout.visibility = View.INVISIBLE
    }


}