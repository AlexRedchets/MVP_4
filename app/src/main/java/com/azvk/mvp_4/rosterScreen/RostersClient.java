package com.azvk.mvp_4.rosterScreen;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface RostersClient {

    @GET("api/player/{team}")
    Observable<List<Roster>> getRosters(
            @Path("team") String team
    );
}
