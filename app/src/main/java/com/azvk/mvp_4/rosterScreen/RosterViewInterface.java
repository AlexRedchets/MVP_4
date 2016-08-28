package com.azvk.mvp_4.rosterScreen;

import java.util.List;

/**
 * Created by azvk on 2016-08-28.
 */

public interface RosterViewInterface {

    interface View{

        void onComplete(List<Roster> rosters);
        void onError(String message);

    }
    interface Presenter{
        void fetchData();
    }
}
