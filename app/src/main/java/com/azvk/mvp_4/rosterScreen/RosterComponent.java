package com.azvk.mvp_4.rosterScreen;

import com.azvk.mvp_4.dependencies.CustomScope;
import com.azvk.mvp_4.dependencies.NetComponent;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by azvk on 2016-08-28.
 */
@CustomScope
@Subcomponent(modules = RosterModule.class)
public interface RosterComponent {
    void inject (RosterActivity rosterActivity);
}
