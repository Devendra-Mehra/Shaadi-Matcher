package com.devendra.shaadimatcher.utils;

import android.content.Context;

import com.devendra.shaadimatcher.R;

import javax.inject.Inject;

/**
 * Created by Devendra Mehra on 4/21/2019.
 */
public class StringHelper {
    private Context context;

    @Inject
    public StringHelper(Context context) {
        this.context = context;
    }


    public String getAge(int age) {
        return context.getString(R.string.age, age);
    }

    public String getComma() {
        return context.getString(R.string.comma);
    }

    public String getZero() {
        return context.getString(R.string.zero);
    }

    public String getOne() {
        return context.getString(R.string.one);
    }

    public String getTwo() {
        return context.getString(R.string.two);
    }


    public String getToday() {
        return context.getString(R.string.today);
    }

    public String getYesterday() {
        return context.getString(R.string.yesterday);
    }

    public String getSomeDaysAgo(int days) {
        return context
                .getString(R.string.some_day_ago, days);
    }

}
