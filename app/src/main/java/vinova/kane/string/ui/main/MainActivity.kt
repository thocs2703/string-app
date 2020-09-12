package vinova.kane.string.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import vinova.kane.string.R
import vinova.kane.string.util.SaveSharedPreference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        setupViews()


    }

    private fun setupViews(){
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main_fragment) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.feedFragment, R.id.searchFragment, R.id.postFragment, R.id.notificationFragment, R.id.profileFragment))
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}