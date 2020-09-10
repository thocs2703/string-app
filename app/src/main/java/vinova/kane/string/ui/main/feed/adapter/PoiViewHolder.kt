package vinova.kane.string.ui.main.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vinova.kane.string.R
import vinova.kane.string.model.feed.FeedData

class PoiViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(feed: FeedData?){

    }

    companion object {
        fun create(parent: ViewGroup): PoiViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.poi_item, parent, false)
            return PoiViewHolder(view)
        }
    }
}