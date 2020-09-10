package vinova.kane.string.ui.main.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import vinova.kane.string.R
import vinova.kane.string.databinding.FragmentHomeBinding
import vinova.kane.string.ui.main.feed.adapter.FeedAdapter
import vinova.kane.string.util.ACCESS_TOKEN
import vinova.kane.string.viewmodel.FeedViewModel


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: FeedAdapter
    private lateinit var viewModel: FeedViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        val authorization = activity?.intent?.getStringExtra(ACCESS_TOKEN)
        Log.d("FeedFragment", "Authorization: $authorization")
        if (authorization != null) {
            viewModel.getFeed(authorization)
        }

        return binding.root
    }

}