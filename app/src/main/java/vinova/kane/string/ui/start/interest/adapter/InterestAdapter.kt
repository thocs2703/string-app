package vinova.kane.string.ui.start.interest.adapter

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

class InterestAdapter(
    private val itemClick: (interestData: InterestData) -> Unit
) : RecyclerView.Adapter<InterestAdapter.InterestViewHolder>() {
    private var listInterest: ArrayList<InterestData>? = arrayListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): InterestViewHolder {

        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.interest_item, viewGroup, false)
        return InterestViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return listInterest?.size ?: 0
    }

    fun addInterestData(list: ArrayList<InterestData>) {
        listInterest = arrayListOf()
        listInterest = list
        notifyDataSetChanged()
    }

    fun getSelectCount(): Int {
        var count = 0
        for (item in listInterest!!) {
            if (item.checkUserSellect == 1) {
                count++
            }
        }
        return count
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        val element = listInterest?.get(position)
        holder.bind(element as InterestData, position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    inner class InterestViewHolder(
        itemView: View,
        val itemClick: (interest: InterestData) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: InterestData, position: Int) {
            Glide.with(itemView)
                .load(item.photo.url.original)
                .apply(RequestOptions().transform(CenterInside(), RoundedCorners(20)))
                .thumbnail(Glide.with(itemView).load(item.photo.url.thumb))
                .into(itemView.interest_image)

            itemView.interest_title_text.text = item.title

            itemView.interest_checkbox.isChecked = item.checkUserSellect == 1

            itemView.interest_checkbox.setOnClickListener {
                if (item.checkUserSellect == 1)
                    item.checkUserSellect = 0
                else
                    item.checkUserSellect = 1

                itemView.interest_checkbox.isChecked = item.checkUserSellect == 1

                notifyItemChanged(position)
                item.let { it1 -> listInterest?.set(position, it1) }
                itemClick(item)
            }
        }
    }
}