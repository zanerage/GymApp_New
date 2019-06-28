package mario_antolovic.com.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.bottom_navigation_view.*
import mario_antolovic.com.R

abstract class navigation_activity(val navNumber:Int):AppCompatActivity() {

    private val TAG = "NavigationActivity"

    fun setupBottomNavigation () {
        bottom_navigation_view.setIconSize(29f,29f)
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableItemShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)

        /// tint color on navmenu
        //for (i in 0 until bottom_navigation_view.menu.size()) {
          //  bottom_navigation_view.setIconTintList(i,null)
       // }

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                when(it.itemId) {
                    R.id.nav_item_home->MainActivity::class.java
                    R.id.nav_item_profile->ProfileActivity::class.java
                    R.id.nav_item_reports->ReportActivity::class.java
                    else-> {
                        Log.d(TAG, "setupBottomNavigation:")
                        null
                    }
                }
            if(nextActivity !=null) {
                val intent = Intent(this,nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0,0)
                true


            } else{
                false
            }
        }

    }

    override fun onResume() {
        super.onResume()
        if(bottom_navigation_view != null) {
            bottom_navigation_view.menu.getItem(navNumber).isCheckable=true
        }
    }
}