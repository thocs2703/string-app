package vinova.kane.string.ui.main.feed.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
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

                feed.photos?.let { photos ->
                    time_duration_text.visibility = View.GONE
                    play_video_image.visibility = View.GONE
                    ll_image_feed.visibility = View.VISIBLE
                    when (photos.size) {
                        1 -> {
                            sub_post_layout.visibility = View.GONE
                            Glide.with(itemView)
                                .load(photos[0].url.original)
                                .thumbnail(Glide.with(itemView)
                                        .load(photos[0].url.thumb))
                                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(20)))
                                .into(post_image)
                        }
                        2 -> {
                            Glide.with(itemView)
                                .load(photos[0].url.original)
                                .thumbnail(Glide.with(itemView)
                                    .load(photos[0].url.thumb))
                                .apply(
                                    RequestOptions().transform(
                                        CenterCrop(),
                                        RoundedCornersTransformation(
                                            20,
                                            0,
                                            RoundedCornersTransformation.CornerType.TOP
                                        )
                                    )
                                )
                                .into(post_image)

                            sub_post_layout.visibility = View.VISIBLE
                            post_image_right.visibility = View.GONE
                            Glide.with(itemView)
                                .load(photos[1].url.original)
                                .thumbnail(Glide.with(itemView)
                                    .load(photos[1].url.thumb))
                                .apply(
                                    RequestOptions().transform(
                                        CenterCrop(),
                                        RoundedCornersTransformation(
                                            20,
                                            0,
                                            RoundedCornersTransformation.CornerType.BOTTOM
                                        )
                                    )
                                )
                                .into(post_image_left)
                        }
                        else -> {
                            sub_post_layout.visibility = View.VISIBLE
                            Glide.with(itemView)
                                .load(photos[0].url.original)
                                .thumbnail(Glide.with(itemView)
                                    .load(photos[0].url.thumb))
                                .apply(
                                    RequestOptions().transform(
                                        CenterCrop(),
                                        RoundedCornersTransformation(
                                            20,
                                            0,
                                            RoundedCornersTransformation.CornerType.TOP
                                        )
                                    )
                                )
                                .into(post_image)
                            post_image_left.visibility = View.VISIBLE
                            post_image_right.visibility = View.VISIBLE
                            Glide.with(itemView)
                                .load(photos[1].url.original)
                                .thumbnail(Glide.with(itemView)
                                    .load(photos[1].url.thumb))
                                .apply(
                                    RequestOptions().transform(
                                        CenterCrop(),
                                        RoundedCornersTransformation(
                                            20,
                                            0,
                                            RoundedCornersTransformation.CornerType.BOTTOM_LEFT
                                        )
                                    )
                                )
                                .into(post_image_left)
                            Glide.with(itemView)
                                .load(photos[2].url.original)
                                .thumbnail(Glide.with(itemView)
                                    .load(photos[2].url.thumb))
                                .apply(
                                    RequestOptions().transform(
                                        CenterCrop(),
                                        RoundedCornersTransformation(
                                            20,
                                            0,
                                            RoundedCornersTransformation.CornerType.BOTTOM_RIGHT
                                        )
                                    )
                                )
                                .into(post_image_right)
                        }
                    }
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