package com.example.dell.spotsoontest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL on 20-05-2017.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder> {

    private Context context;
    private List<VideoList> videoLists;


    public VideoListAdapter(Context context, List<VideoList> videoLists) {
        this.context = context;
        this.videoLists =videoLists;
    }

    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_videos_list, parent, false);
        return new VideoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoListViewHolder holder, int position) {
        VideoList videoList = videoLists.get(position);

        holder.videoNameText.setText(videoList.getVideoName());
        holder.videoTimeText.setText(videoList.getVideoTime());
        holder.videoDescriptionText.setText(videoList.getVideoDescription());
        holder.videoImage.setImageResource(videoList.getVideoImage());
    }

    @Override
    public int getItemCount() {
        return videoLists.size();
    }

    public class VideoListViewHolder extends RecyclerView.ViewHolder{

        private ImageView videoImage;
        private ImageView videoTimeImage;
        private TextView videoNameText;
        private TextView videoTimeText;
        private TextView videoDescriptionText;


        public VideoListViewHolder(View itemView) {
            super(itemView);

            videoImage= (ImageView) itemView.findViewById(R.id.video_image);
            videoTimeImage= (ImageView) itemView.findViewById(R.id.video_time_image);
            videoNameText= (TextView) itemView.findViewById(R.id.video_title_text);
            videoTimeText= (TextView) itemView.findViewById(R.id.video_time_text);
            videoDescriptionText= (TextView) itemView.findViewById(R.id.video_description_text);

        }
    }
}
