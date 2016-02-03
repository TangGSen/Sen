package com.sen.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.sen.adapter.HomeActFragAdpter;
import com.sen.base.BaseActivity;
import com.sen.liuboss.R;
import com.sen.uitls.ResourcesUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeActivity extends BaseActivity {


    private Toolbar mToolbar;
    private TextView actionBarTile;
    @Bind(R.id.viewPager_content)
    ViewPager viewPager_content;
    @Bind(R.id.layout_buttom_tab)
    TabLayout layout_buttom_tab;
    //tab item name
    String tabTiles[];
    //tab item drawable
    int tabItemDrawable[];


    public void initView() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initTabView();

    }

    private void initTabView() {

        tabTiles = ResourcesUtils.getStringArray(this, R.array.tabItemName);
        tabItemDrawable = new int[]{R.drawable.ic_tab_home, R.drawable.ic_tab_classification, R.drawable.ic_tab_car, R.drawable.ic_tab_personal};
        HomeActFragAdpter fragAdapter = new HomeActFragAdpter(getSupportFragmentManager(), this, tabTiles, tabItemDrawable);
        viewPager_content.setAdapter(fragAdapter);
        layout_buttom_tab.setupWithViewPager(viewPager_content);
        for (int i = 0; i < layout_buttom_tab.getTabCount(); i++) {
            TabLayout.Tab tab = layout_buttom_tab.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(fragAdapter.getTabView(i));
            }
        }
        viewPager_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = layout_buttom_tab.getTabAt(position);
                AppCompatTextView textView = (AppCompatTextView) tab.getCustomView();
                textView.setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager_content.setCurrentItem(0);
    }

    @Override
    protected void initActionBar() {
        super.initActionBar();
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        mToolbar.setTitle("");
        actionBarTile = (TextView) findViewById(R.id.action_bar_title);
        setSupportActionBar(mToolbar);

    }
}
