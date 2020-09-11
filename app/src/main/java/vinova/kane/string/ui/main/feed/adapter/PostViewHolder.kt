package vinova.kane.string.ui.main.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import vinova.kane.string.R
import vinova.kane.string.model.feed.FeedData

class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val avatarImage = view.findViewById<CircleImageView>(R.id.avt_post_image)
    private val username = view.findViewById<TextView>(R.id.username_post_text)
    private val timePost = view.findViewById<TextView>(R.id.time_post_text)
    private val saveCounter = view.findViewById<Button>(R.id.save_counter_button)
    private val description = view.findViewById<TextView>(R.id.description_post_text)
    private val location = view.findViewById<TextView>(R.id.location_post_text)
    private val playButton = view.findViewById<Button>(R.id.play_video_button)
    private val timeDuration = view.findViewById<TextView>(R.id.time_duration_text)
    private val likeCounter = view.findViewById<TextView>(R.id.like_counter_text)
    private val commentCounter = view.findViewById<TextView>(R.id.comment_counter_text)

    fun bind(feed: FeedData?){
        if (feed != null) {
//            Glide.with(itemView)
//                .load()

            username.text = feed.user.username
            saveCounter.text = feed.saveCounter.toString()
            description.text = feed.description
            location.text = feed.place.address
            if (feed.videos == "null"){
                playButton.visibility = View.GONE
                timeDuration.visibility = View.GONE
            }
            timePost.text = feed.createdAt
            likeCounter.text = feed.likeCounter.toString()
            commentCounter.text = feed.likeCounter.toString()
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