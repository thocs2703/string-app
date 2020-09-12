package vinova.kane.string.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vinova.kane.string.R
import vinova.kane.string.ui.main.MainActivity
import vinova.kane.string.util.SaveSharedPreference

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if(SaveSharedPreference().getLoggedStatus(this)){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}