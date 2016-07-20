package com.xiaochao.lcrapiddevelop.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.xiaochao.lcrapiddevelop.Adapter.MainAdapter;
import com.xiaochao.lcrapiddevelop.Data.Data;
import com.xiaochao.lcrapiddevelop.R;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private BaseQuickAdapter homeAdapter;
    private Toolbar activityToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        activityToolbar = (Toolbar) findViewById(R.id.activityToolbar);
        setSupportActionBar(activityToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeAdapter = new MainAdapter( R.layout.main_item_layout, Data.getData());
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        homeAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            private Intent intent;
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this,ListvViewActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,ListviewGroupingActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,GridViewActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,ChatLayoutActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(homeAdapter);
    }
}