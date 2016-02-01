package com.sen.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sen.base.BaseActivity;
import com.sen.liuboss.R;


public class HomeActivity extends BaseActivity {


	private Toolbar mToolbar;
	private TextView actionBarTile;

	public void initView() {
		setContentView(R.layout.activity_home);


		View view = View.inflate(this, R.layout.layout_content_home,null);


	}

	@Override
	protected void initActionBar() {
		super.initActionBar();
		mToolbar = (Toolbar) findViewById(R.id.app_bar);
		mToolbar.setTitle("");
		actionBarTile = (TextView)findViewById(R.id.action_bar_title);
		actionBarTile.setText(R.string.loginString);
		mToolbar.setNavigationIcon(R.drawable.arrow_left);
		setSupportActionBar(mToolbar);

	}
}
