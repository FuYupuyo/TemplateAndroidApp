package com.template.main;

import com.example.templateandroidapp.R;
import com.template.common.PageDispatcher;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MainActivity extends ActionBarActivity implements
		OnMenuItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupLayout();
	}

	private void setupLayout() {
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		PageDispatcher.dispatchMainPage(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		/** ボタン */
		MenuItem postActionItem = menu.findItem(R.id.action_test);
		postActionItem.setOnMenuItemClickListener(this);

		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		if (item == null)
			return false;

		switch (item.getItemId()) {
		case R.id.action_test:
			Log.d("test", "action_testが押されました");
			break;

		case R.id.action_settings:
			Log.d("test", "action_settingsが押されました");
			break;

		default:
			break;

		}

		return true;
	}

}
