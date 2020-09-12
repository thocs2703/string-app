@file:Suppress("DEPRECATION")

package vinova.kane.string.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SaveSharedPreference {
    private fun getPreferences(context: Context): SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setLoggedIn(context: Context, loggedIn: Boolean){
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.putBoolean(LOGGED_IN, loggedIn)
        editor.apply()
    }

    fun getLoggedStatus(context: Context): Boolean{
        return getPreferences(context).getBoolean(LOGGED_IN, false)
    }

    fun setAccessToken(context: Context, authorization: String){
        val editor: SharedPreferences.Editor = getPreferences(context).edit()
        editor.putString(ACCESS_TOKEN, authorization)
        editor.apply()
    }

    fun getAccessToken(context: Context): String? {
        return getPreferences(context).getString(ACCESS_TOKEN, "")
    }
}