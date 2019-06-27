package mario_antolovic.com.models

import android.text.LoginFilter
import com.google.firebase.database.Exclude


data class User(val name: String = "", val username: String = "", val email: String = "",
                val photo: String? = null, @Exclude val uid: String = "")