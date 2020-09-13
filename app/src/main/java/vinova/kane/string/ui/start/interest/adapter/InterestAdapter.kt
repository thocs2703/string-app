package vinova.kane.string.ui.start.interest.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import vinova.kane.string.model.interest.InterestData

class InterestAdapter
    : PagedListAdapter<InterestData, RecyclerView.ViewHolder>(
    DiffCallbackInterest
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InterestViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as InterestViewHolder).bind(getItem(position))
    }

    companion object DiffCallbackInterest: DiffUtil.ItemCallback<InterestData>(){
        override fun areItemsTheSame(oldItem: InterestData, newItem: InterestData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: InterestData, newItem: InterestData): Boolean {
            return oldItem == newItem
        }
    }
}