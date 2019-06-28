package mario_antolovic.com.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import mario_antolovic.com.R

class MainActivity : navigation_activity(0), View.OnClickListener {
    private val TAG = "MainActivity"

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()

        mAuth = FirebaseAuth.getInstance()
        logout_btn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.logout_btn -> {
                mAuth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        when(view.id) {
            R.id.profile_btn -> {
                startActivity(Intent(this,ProfileActivity::class.java))
            }
        }
    }
}
