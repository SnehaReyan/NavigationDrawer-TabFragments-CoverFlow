package com.example.dell.spotsoontest;

/**
 * Created by DELL on 20-05-2017.
 */

public class VideoList {

    String videoName;
    String videoTime;
    String videoDescription;
    Integer videoImage;

    public VideoList(String videoName, String videoTime, String videoDescription, Integer videoImage) {
        this.videoName = videoName;
        this.videoTime = videoTime;
        this.videoDescription = videoDescription;
        this.videoImage = videoImage;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public Integer getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(Integer videoImage) {
        this.videoImage = videoImage;
    }
}
