package mario_antolovic.com.Activities

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import mario_antolovic.com.models.User

fun Context.showToast(text:String,duration:Int= Toast.LENGTH_SHORT) {
    Toast.makeText(this,text,duration).show()
}

fun DataSnapshot.asUser(): User? =
    getValue(User::class.java)?.copy(uid = key)