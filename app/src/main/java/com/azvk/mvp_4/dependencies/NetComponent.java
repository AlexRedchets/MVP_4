package com.azvk.mvp_4.dependencies;

import com.azvk.mvp_4.rosterScreen.RosterActivity;
import com.azvk.mvp_4.rosterScreen.RosterComponent;
import com.azvk.mvp_4.rosterScreen.RosterModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
