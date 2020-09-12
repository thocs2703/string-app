package vinova.kane.string.util

import android.app.Application
import android.content.Context

class StringApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: StringApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

}