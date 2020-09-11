package vinova.kane.string.ui.main.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poi_item.view.*
import kotlinx.android.synthetic.main.poi_item.view.comment_counter_text
import kotlinx.android.synthetic.main.poi_item.view.like_counter_text
import kotlinx.android.synthetic.main.post_item.view.*
import vinova.kane.string.R
import vinova.kane.string.model.feed.FeedData

class PoiViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(feed: FeedData?){
        if (feed != null){
            with(itemView){
                title_poi_text.text = feed.title
                address_poi_text.text = feed.address
                strung_counter_poi_button.text = feed.strungCounter.toString()

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

                if(feed.photos != null){
                    Glide.with(itemView)
                        .load(feed.photos[0].url.original)
                        .thumbnail(
                            Glide.with(itemView).
                            load(feed.photos[0].url.thumb))
                        .into(poi_image)
                }

                if(feed.user != null){
                    Glide.with(itemView)
                        .load(feed.user.profilePhoto)
                        .error(R.drawable.ic_avatar)
                        .into(avt_poi_image)
                    username_poi_text.text = feed.user.username
                }
            }

        }
    }

    companion object {
        fun create(parent: ViewGroup): PoiViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.poi_item, parent, false)
            return PoiViewHolder(view)
        }
    }
}