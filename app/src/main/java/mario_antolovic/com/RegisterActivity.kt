package mario_antolovic.com

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        when(view.id) {
            R.id.register_btn -> {
                onRegister(view)
            }
        }
    }

    private val TAG= "RegisterActivity"

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        register_btn.setOnClickListener(this)


        //setup firabase inst
        // create register login
        // create onclick listener button logic


    }

    private fun onRegister(view:View) {
        val fullName = edt_fullname.text.toString()
        val email = edt_email.text.toString()
        val password = edt_password.text.toString()
        val password2 = edt_password2.text.toString()


        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                showToast("All fields are required")
            } else {
            if (password!=password2) {
                showToast("Passwords must match")
            }else {
               mAuth.createUserWithEmailAndPassword(email,password)
                   .addOnCompleteListener { if (it.isSuccessful) {
                   showToast("Registration was succesful")
                       startActivity(Intent(this,MainActivity::class.java))
                       finish()
                   }else {
                       showToast("Something went wrong,please try again later")
                   }
                   }
            }
        }

    }

}
