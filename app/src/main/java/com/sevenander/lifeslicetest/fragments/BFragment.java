package com.sevenander.lifeslicetest.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devbrackets.android.exomedia.listener.OnCompletionListener;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;
import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.adapters.VideoListAdapter;
import com.sevenander.lifeslicetest.model.VideoItem;
import com.sevenander.lifeslicetest.utils.VideoListHandler;
import com.sevenander.lifeslicetest.utils.callbacks.FragmentCallback;
import com.sevenander.lifeslicetest.utils.callbacks.ListItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BFragment extends Fragment implements ListItemClickListener, OnPreparedListener, OnCompletionListener {

    @Bind(R.id.rv_video_list) RecyclerView rvVideoList;
    @Bind(R.id.em_video) EMVideoView emVideoView;

    private FragmentCallback mListener;
    private VideoListAdapter adapter;

    private int currentPlayPosition;

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
//        loadVideos();
        setupRecyclerView();
        setupVideoView();

        return view;
    }

    private void setupVideoView() {
        emVideoView.setOnPreparedListener(this);
        emVideoView.setOnCompletionListener(this);
        //For now we just picked an arbitrary item to play.  More can be found at
        //https://archive.org/details/more_animation

    }

    private void loadVideos() {
        List<VideoItem> videos = new ArrayList<>();
        VideoItem videoItem = new VideoItem();
        videoItem.setUserName("Brandon Calvillo");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/9D875C4D3E1314430546486890496_52dd35cb27f.5.0.jpg?versionId=pSPRqs0fzUvGQcZUdSceXVYJVdOPPreX");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/98A4D62ABB1389822725811806208_5771fc25db9.35.1.A36F0C11-83C5-4DC9-8A17-A9A4B31344E7.mp4?versionId=TsOp.0itSXcXX5SDB9MVzSrfz9qVEp8A");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("viral shark");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/E9FD59343B1364342348439560192_588033e5fb3.25.1.jpg?versionId=sRJa64p2J5MYSGE5tkSZJFRnIv6xFo0n");
        videoItem.setVideoSrc("http://mtc.cdn.vine.co/r/videos_r2/DD1672942A1389813589359190016_552685449e3.35.1.EE344314-2A18-4FE5-9D86-824D7997BFFC.mp4?versionId=qs2LVFqibF68x9p_enPlpuk1HA_eZxiX");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("The Gabbie Show");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/93BC2639DD1237652782228688896_3f2ae71148f.4.2.jpg?versionId=KiwL.qIhZewHAVIJRQgjS2aTr4fESnMY");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/2C230E708F1389832993320914944_54957b9e13f.35.1.B3A4EF0E-7430-4C07-AD0A-9964D3031604.mp4?versionId=Es8gLSSXBqd9YkfQDBUBAmueyz92v9Hr");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("JAY VERSACE");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/54874311491346937003236806656_5f2a87afe3c.17.0.jpg?versionId=tkiC4HGvM0tWVtfWgI6Jc8sMHouDlO2j");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/96EEE758361389828552354299904_5886ca78a77.35.0.4482C136-7758-49DF-ACC2-F6C8ECF043BC.mp4?versionId=N0rqJpOGSrxvcuNSroU.jktYub8e_sE_");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("Brandon Calvillo1");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/9D875C4D3E1314430546486890496_52dd35cb27f.5.0.jpg?versionId=pSPRqs0fzUvGQcZUdSceXVYJVdOPPreX");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/98A4D62ABB1389822725811806208_5771fc25db9.35.1.A36F0C11-83C5-4DC9-8A17-A9A4B31344E7.mp4?versionId=TsOp.0itSXcXX5SDB9MVzSrfz9qVEp8A");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("viral shark2");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/E9FD59343B1364342348439560192_588033e5fb3.25.1.jpg?versionId=sRJa64p2J5MYSGE5tkSZJFRnIv6xFo0n");
        videoItem.setVideoSrc("http://mtc.cdn.vine.co/r/videos_r2/DD1672942A1389813589359190016_552685449e3.35.1.EE344314-2A18-4FE5-9D86-824D7997BFFC.mp4?versionId=qs2LVFqibF68x9p_enPlpuk1HA_eZxiX");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("The Gabbie Show3");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/93BC2639DD1237652782228688896_3f2ae71148f.4.2.jpg?versionId=KiwL.qIhZewHAVIJRQgjS2aTr4fESnMY");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/2C230E708F1389832993320914944_54957b9e13f.35.1.B3A4EF0E-7430-4C07-AD0A-9964D3031604.mp4?versionId=Es8gLSSXBqd9YkfQDBUBAmueyz92v9Hr");
        videos.add(videoItem);

        videoItem = new VideoItem();
        videoItem.setUserName("JAY VERSACE4");
        videoItem.setUserPhoto("http://v.cdn.vine.co/r/avatars/54874311491346937003236806656_5f2a87afe3c.17.0.jpg");
        videoItem.setVideoSrc("http://v.cdn.vine.co/r/videos_r2/96EEE758361389828552354299904_5886ca78a77.35.0.4482C136-7758-49DF-ACC2-F6C8ECF043BC.mp4?versionId=N0rqJpOGSrxvcuNSroU.jktYub8e_sE_");
        videos.add(videoItem);

        VideoListHandler.getInstance().addAll(videos);
    }

    private void setupRecyclerView() {
        adapter = new VideoListAdapter(getActivity(),
                VideoListHandler.getInstance().getItems(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false);
        rvVideoList.setLayoutManager(layoutManager);
        rvVideoList.setAdapter(adapter);
    }

    public void refreshList() {
        adapter = new VideoListAdapter(getActivity(),
                VideoListHandler.getInstance().getItems(), this);
        rvVideoList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallback) {
            mListener = (FragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(int position) {
        playVideo(position);
    }

    @Override
    public void onPrepared() {
        Log.d("TAG1", "prepared");
        emVideoView.start();
    }

    @Override
    public void onCompletion() {
        Log.d("TAG1", "completed");
        if (currentPlayPosition < VideoListHandler.getInstance().getItems().size() - 1) {
            playVideo(currentPlayPosition + 1);
        } else {
            playVideo(0);
        }
    }

    public void playVideo(int position) {
        adapter.highlightItem(position);
        Log.d("TAG1", "playing " + position);
        currentPlayPosition = position;
        String uri = VideoListHandler.getInstance().getItems().get(position).getVideoSrc();
        if (!TextUtils.isEmpty(uri))
            emVideoView.setVideoURI(Uri.parse(uri));
        rvVideoList.scrollToPosition(position);
    }
}
