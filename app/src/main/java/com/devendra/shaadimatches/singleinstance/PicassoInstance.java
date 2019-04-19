package com.devendra.shaadimatches.singleinstance;

import android.content.Context;

import com.squareup.picasso.Picasso;

public class PicassoInstance {


    private static volatile Picasso picassoInstance = null;
    private static Context context;

    private PicassoInstance(Context context) {
        PicassoInstance.context = context;
        if (picassoInstance != null) {
            throw new RuntimeException("Can not create this way, please use " +
                    "getPicassoInstance method");
        }
    }

    public static Picasso getPicassoInstance() {
        if (picassoInstance == null) {
            synchronized (Picasso.class) {
                if (picassoInstance == null) {
                    picassoInstance = new Picasso.
                            Builder(context).build();
                }
            }
        }
        return picassoInstance;
    }
}
