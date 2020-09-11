package vinova.kane.string.ui.main.feed.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poi_item.view.*
import kotlinx.android.synthetic.main.post_item.view.*
import kotlinx.android.synthetic.main.post_item.view.comment_counter_text
import kotlinx.android.synthetic.main.post_item.view.like_counter_text
import vinova.kane.string.R
import vinova.kane.string.model.feed.FeedData

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(feed: FeedData?) {
        if (feed != null) {
            with(itemView) {
                if (feed.user?.profilePhoto != "null") {
                    Glide.with(itemView)
                        .load(feed.user?.profilePhoto)
                        .error(R.drawable.ic_avatar)
                        .into(avt_post_image)
                }

                username_post_text.text = feed.user?.username
                save_counter_post_button.text = feed.saveCounter.toString()
                description_post_text.text = feed.description

                Log.d("PostViewHolder", "Place title: ${feed.place}")
                if (feed.place != null)
                    location_post_text.text = feed.place.title

                if (feed.videos == null) {

                    play_video_image.visibility = View.GONE
                    time_duration_text.visibility = View.GONE
                } else {
                    play_video_image.visibility = View.VISIBLE
                    time_duration_text.visibility = View.VISIBLE
                }

                time_post_text.text = feed.updatedAt

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
                        .into(post_image)
                }
            }
        }

    }

    companion object {
        fun create(parent: ViewGroup): PostViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false)
            return PostViewHolder(view)
        }
    }

}