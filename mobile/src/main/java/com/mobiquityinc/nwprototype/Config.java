package com.mobiquityinc.nwprototype;

import android.content.Context;

public class Config {

    private Context context;

    public Config(Context context) {
        this.context = context;
    }

    public String getCity() {
        return context.getString(R.string.city);
    }
}
