package com.azvk.mvp_4;

import android.app.Application;

import com.azvk.mvp_4.dependencies.AppModule;
import com.azvk.mvp_4.dependencies.DaggerNetComponent;
import com.azvk.mvp_4.dependencies.NetComponent;
import com.azvk.mvp_4.dependencies.NetModule;

public class App extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://54.186.57.223:3000/"))
                .build();
    }
}
