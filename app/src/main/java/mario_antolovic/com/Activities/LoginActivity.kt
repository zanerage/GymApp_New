package mario_antolovic.com.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import mario_antolovic.com.R
import android.content.Intent as Intent1

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    private val TAG = "LoginActivity"


    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txt_link.setOnClickListener {

            val intent = android.content.Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }


        //get an instance from firebase

        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null) {
            startActivity(Intent1(this, MainActivity::class.java))
            finish()
        }
        // set the onclick listner method upon activity creation
        login_btn.setOnClickListener(this)
    }

    override fun onClick(view:View) {
        when(view.id) {
            R.id.login_btn -> {
                val email = edt_username.text.toString()
                val password = edt_password.text.toString()
                if (validate(email,password)) {
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent1(this, MainActivity::class.java))
                            finish()

                        } else {
                            showToast("You must have entered wrong email or password")

                        }
                    }
                } else {
                    // min password requirements
                    showToast("Please enter email or password")
                }
            }
        }
    }
    private fun  validate(email:String,password:String) =
            email.isNotEmpty() && password.isNotEmpty()


}
