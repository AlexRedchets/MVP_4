package com.azvk.mvp_4.rosterScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.azvk.mvp_4.App;
import com.azvk.mvp_4.R;

import java.util.List;

import javax.inject.Inject;

public class RosterActivity extends AppCompatActivity implements RosterViewInterface.View {

    @Inject
    RosterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        DaggerRosterComponent.builder()
                .netComponent(((App)getApplicationContext()).getNetComponent())
                .rosterModule(new RosterModule(this))
                .build().inject(this);

        presenter.fetchData();
    }

    @Override
    public void onComplete(List<Roster> rosters) {

    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
