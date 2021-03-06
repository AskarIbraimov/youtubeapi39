package com.example.youtubeapi39.ui.playlist.playlists

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi39.BuildConfig.BASE_URl
import com.example.youtubeapi39.`object`.Constants
import com.example.youtubeapi39.base.BaseActivity
import com.example.youtubeapi39.databinding.ActivityPlaylistBinding
import com.example.youtubeapi39.ui.playlist.PlaylistViewModel
import com.example.youtubeapi39.ui.playlist.playlist_videos.PlaylistVideosActivity

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistBinding>() {

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlayListVideo().observe(this) {
            Log.e(TAG, "initViewModel: " + it.kind.toString())
            binding.recycler.adapter =
                PlaylistAdapter(it.items!!, object : PlaylistAdapter.ClickOnPlaylist {
                    override fun onClick(id: String?, count: Int) {
                        Intent(this@PlaylistActivity, PlaylistVideosActivity::class.java).apply {
                            putExtra(Constants.NAME, id)
                            putExtra(Constants.COUNT, count)
                            Log.e(TAG, "tittle: ${it.contentDetails?.caption.toString()}")
                            Log.e("TAG", "playlist: $id")
                            startActivity(this)
                        }
                    }
                })

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BASE_URl

    }

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

}









