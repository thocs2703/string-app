package vinova.kane.string.ui.main.feed.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import vinova.kane.string.model.feed.FeedData
import vinova.kane.string.model.feed.Itinerary
import vinova.kane.string.network.NetworkState
import java.lang.IllegalArgumentException

class FeedAdapter: PagedListAdapter<FeedData, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            POST_VIEW_TYPE -> PostViewHolder.create(parent)
            POI_VIEW_TYPE -> PoiViewHolder.create(parent)
            ITINERARY_VIEW_TYPE -> ItineraryViewHolder.create(parent)
            else -> throw IllegalArgumentException("View type not found!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = getItem(position)
        when(holder){
            is PostViewHolder -> holder.bind(feed)
            is PoiViewHolder -> holder.bind(feed)
            is ItineraryViewHolder -> holder.bind(feed)
            else -> throw IllegalArgumentException("Can not bind!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)?.type){
                "post" -> POST_VIEW_TYPE
                "poi" -> POI_VIEW_TYPE
                "itinerary" -> ITINERARY_VIEW_TYPE
                else -> throw IllegalArgumentException("View type not found!")
            }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FeedData>(){
        override fun areItemsTheSame(oldItem: FeedData, newItem: FeedData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FeedData, newItem: FeedData): Boolean {
            return oldItem == newItem
        }

        const val POST_VIEW_TYPE = 1
        const val POI_VIEW_TYPE = 2
        const val ITINERARY_VIEW_TYPE = 3
    }
}