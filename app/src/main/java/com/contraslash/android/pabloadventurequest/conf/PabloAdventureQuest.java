package com.contraslash.android.pabloadventurequest.conf;

import android.app.Application;

import com.contraslash.android.pabloadventurequest.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by ma0 on 3/16/16.
 */
public class PabloAdventureQuest extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Dosis/Dosis-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
//                        .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
//                        .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                        .build()
        );
    }
}
