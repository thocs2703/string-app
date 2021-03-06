package vinova.kane.string.ui.main.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.itinerary_item.view.*
import kotlinx.android.synthetic.main.poi_item.view.comment_counter_text
import kotlinx.android.synthetic.main.poi_item.view.like_counter_text
import vinova.kane.string.R
import vinova.kane.string.model.feed.FeedData

class ItineraryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(feed: FeedData?){
        if(feed!= null){
            with(itemView){
                title_itinerary_text.text = feed.title

                if(feed.user != null){
                    Glide.with(itemView)
                        .load(feed.user.profilePhoto)
                        .error(R.drawable.ic_avatar)
                        .into(avt_itinerary_image)
                    username_itinerary_text.text = feed.user.username
                }

                if(feed.strungFrom != null){
                    Glide.with(itemView)
                        .load(feed.strungFrom.profilePhoto)
                        .error(R.drawable.ic_avatar)
                        .into(strung_from_image)
                    strung_from_username_text.text = feed.strungFrom.username
                }

                description_itinerary_text.text = feed.description

                if (feed.likeCounter == 0){
                    like_counter_text.visibility = View.GONE
                } else{
                    like_counter_text.text = feed.likeCounter.toString()
                    like_counter_text.visibility = View.VISIBLE
                }

                if(feed.commentCounter == 0){
                    comment_counter_text.visibility = View.GONE
                } else {
                    comment_counter_text.text = feed.commentCounter.toString()
                    comment_counter_text.visibility = View.VISIBLE
                }

            }
        }

    }

    companion object {
        fun create(parent: ViewGroup): ItineraryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.itinerary_item, parent, false)
            return ItineraryViewHolder(view)
        }
    }
}