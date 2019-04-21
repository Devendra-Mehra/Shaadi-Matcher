package com.devendra.shaadimatcher.users.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class Info {

    @SerializedName("seed")
    private String seed;
    @SerializedName("result")
    private int result;
    @SerializedName("page")
    private int page;
    @SerializedName("version")
    private String version;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "seed='" + seed + '\'' +
                ", result=" + result +
                ", page=" + page +
                ", version='" + version + '\'' +
                '}';
    }
}
