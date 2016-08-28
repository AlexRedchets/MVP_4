package com.azvk.mvp_4.rosterScreen;

import com.azvk.mvp_4.dependencies.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by azvk on 2016-08-28.
 */
@Module
public class RosterModule {

    RosterViewInterface.View rosterViewInterface;

    public RosterModule(RosterViewInterface.View rosterViewInterface) {
        this.rosterViewInterface = rosterViewInterface;
    }

    @Provides
    @CustomScope
    RosterViewInterface.View getRosterViewInterface(){
        return rosterViewInterface;
    }
}
