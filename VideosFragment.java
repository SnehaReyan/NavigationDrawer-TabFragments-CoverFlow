package com.example.dell.spotsoontest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {

    private RecyclerView videoListRecyclerView;
    private VideoListAdapter videoListAdapter;
    private List<VideoList> videoLists;

    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_videos, container, false);

        videoListRecyclerView =(RecyclerView) view.findViewById(R.id.video_fragment_recyclerView);
        videoLists = new ArrayList<>();
        videoListAdapter = new VideoListAdapter(getContext(),videoLists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        videoListRecyclerView.setLayoutManager(layoutManager);
        videoListRecyclerView.setAdapter(videoListAdapter);

        prepareDealList();
        return view;
    }

    private void prepareDealList() {

        VideoList a = new VideoList("Emptyness","18 hrs ago","Dummy text",R.drawable.img1);
        videoLists.add(a);

        a = new VideoList("Iam falling","20 hrs ago","Dummy text one",R.drawable.img2);
        videoLists.add(a);

        a = new VideoList("Baby ft. Justin beiber","22 hrs ago","Dummy text two",R.drawable.img3);
        videoLists.add(a);

        a = new VideoList("Maroon 5","23 hrs ago","Dummy text three",R.drawable.img4);
        videoLists.add(a);

        a = new VideoList("Chantaje","24 hrs ago","Dummy text four",R.drawable.img5);
        videoLists.add(a);

        videoListAdapter.notifyDataSetChanged();
    }


}
