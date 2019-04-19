package com.devendra.shaadimatches.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class Picture {

    @SerializedName("large")
    private String largeUrl;
    @SerializedName("medium")
    private String mediumUrl;
    @SerializedName("thumbnail")
    private String thumbnailUrl;

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "largeUrl='" + largeUrl + '\'' +
                ", mediumUrl='" + mediumUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
