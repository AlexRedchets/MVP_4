package com.azvk.mvp_4.rosterScreen;

import android.util.Log;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RosterPresenter implements RosterViewInterface.Presenter {

    private Retrofit retrofit;
    private RosterViewInterface.View view;

    @Inject
    public RosterPresenter(Retrofit retrofit, RosterViewInterface.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    public void fetchData() {
        retrofit.create(RostersClient.class).getRosters("Russia")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(userData -> {
                            view.onComplete(userData);
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                            view.onError(throwable.getMessage());
                        });
    }
}
