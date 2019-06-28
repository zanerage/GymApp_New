package mario_antolovic.com.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mario_antolovic.com.R

class ReportActivity : navigation_activity(1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setupBottomNavigation()
    }
}
