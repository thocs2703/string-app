package vinova.kane.string.ui.start.interest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.interest_item.view.*
import vinova.kane.string.R
import vinova.kane.string.model.interest.InterestData

class InterestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var listItem: ArrayList<InterestData> = arrayListOf()
    private var checkCounter = 0

    init {
        view.setOnClickListener {
            with(itemView){
                interest_checkbox.isChecked = !interest_checkbox.isChecked
            }
        }
    }

    fun bind(item: InterestData?) {
        if(item != null){
            listItem.add(item)
            with(itemView) {
                Log.d("InterestAdapter", item.title)
                interest_title_text.text = item.title

                Glide.with(itemView)
                    .load(item.photo.url.original)
                    .apply(RequestOptions().transform(CenterInside(), RoundedCorners(20)))
                    .thumbnail(
                        Glide.with(itemView)
                            .load(item.photo.url.thumb)
                    )
                    .error(R.drawable.interest_demo)
                    .into(interest_image)

            }
        }

    }

    fun getCheckCounter(){

    }


    companion object {
        fun create(parent: ViewGroup): InterestViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.interest_item, parent, false)
            return InterestViewHolder(view)
        }
    }
}