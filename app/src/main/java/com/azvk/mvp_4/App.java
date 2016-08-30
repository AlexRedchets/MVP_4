package com.azvk.mvp_4;

import android.app.Application;

import com.azvk.mvp_4.dependencies.AppModule;
import com.azvk.mvp_4.dependencies.DaggerNetComponent;
import com.azvk.mvp_4.dependencies.NetComponent;
import com.azvk.mvp_4.dependencies.NetModule;
import com.azvk.mvp_4.rosterScreen.RosterComponent;
import com.azvk.mvp_4.rosterScreen.RosterModule;
import com.azvk.mvp_4.rosterScreen.RosterViewInterface;

public class App extends Application {

    private NetComponent netComponent;
    private RosterComponent rosterComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://54.186.57.223:3000/"))
                .build();

    }

    public RosterComponent getRosterComponent(RosterViewInterface.View view){
        rosterComponent = netComponent.plus(new RosterModule(view));
        return rosterComponent;
    }

    public void releaseRosterComponent(){
        rosterComponent = null;
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
