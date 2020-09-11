package vinova.kane.string.ui.main.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vinova.kane.string.databinding.FragmentFeedBinding
import vinova.kane.string.ui.main.feed.adapter.FeedAdapter
import vinova.kane.string.util.ACCESS_TOKEN
import vinova.kane.string.viewmodel.FeedViewModel


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var adapter: FeedAdapter
    private lateinit var viewModel: FeedViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFeedBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        val authorization = activity?.intent?.getStringExtra(ACCESS_TOKEN)
        Log.d("FeedFragment", "Authorization: $authorization")
        if (authorization != null) {
            viewModel.getFeed("Bearer $authorization")
        }

        bindData()

        return binding.root
    }

    private fun bindData(){
        adapter = FeedAdapter()
        binding.feedRecyclerview.adapter = adapter
        viewModel.feedDataPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            Log.d("FeedFragment", "Feed size: ${adapter.itemCount}")
        })
    }

}