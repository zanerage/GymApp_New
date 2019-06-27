package mario_antolovic.com.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_profile.*
import mario_antolovic.com.R
import mario_antolovic.com.Utils.ValueListenerAdapter
import mario_antolovic.com.models.User

class ProfileActivity : AppCompatActivity() {


    private val TAG = "ProfileActivity"
    private lateinit var mUser: User
    private lateinit var mAuth:FirebaseAuth
    private lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference


        fun currentUserReference():DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)

        currentUserReference().addListenerForSingleValueEvent(
            ValueListenerAdapter{
                mUser=it.asUser()!!
                name.setText(mUser.name)
            }
        )
    }
}
