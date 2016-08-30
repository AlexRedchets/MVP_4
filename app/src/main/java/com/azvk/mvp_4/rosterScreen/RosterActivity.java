package com.azvk.mvp_4.rosterScreen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.azvk.mvp_4.App;
import com.azvk.mvp_4.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RosterActivity extends AppCompatActivity implements RosterViewInterface.View, RostersAdapter.RosterClickListener {

    @Inject
    RosterPresenter presenter;

    @BindView(R.id.rosterts_recycle_view)
    RecyclerView recyclerView;

    private RostersAdapter rostersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        resolveDependencies();
        createView();

        presenter.fetchData();
    }

    private void resolveDependencies() {
        ((App)getApplicationContext()).getRosterComponent(this).inject(this);
    }

    private void createView() {
        ButterKnife.bind(this);

        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rostersAdapter = new RostersAdapter(this, this) ;
        recyclerView.setAdapter(rostersAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((App)getApplicationContext()).releaseRosterComponent();
    }

    @Override
    public void onComplete(List<Roster> rosters) {
        rostersAdapter.updateAdapter(rosters);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
