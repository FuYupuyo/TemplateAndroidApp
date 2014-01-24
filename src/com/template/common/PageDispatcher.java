package com.template.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.template.common.Const.ScreenType;

public class PageDispatcher {
	private PageDispatcher() {
		// ユーティリティクラスなのでインスタンス化禁止
	}

	public static void dispatchMainPage(Context context) {
		dispatchPage(context, ScreenType.SCREEN_TYPE_FRAGMENT_MAIN_WEBVIEW,
				null);
	}

	private static void dispatchPage(Context ctx, ScreenType type, Object object) {
		if (ctx == null || type == null) {
			return;
		}

		/** 　FragmentManagerの取得　 */
		FragmentManager fm = ((FragmentActivity) ctx)
				.getSupportFragmentManager();

		if (fm == null) {
			return;
		}

		Log.d("Dispatch Screen:", type.toString());

		/**
		 * FragmentのDispatch
		 */
		FragmentTransaction ft = fm.beginTransaction();

		switch (type) {

		case SCREEN_TYPE_FRAGMENT_MAIN_WEBVIEW:
			MainWebViewFragment mainFragment = new MainWebViewFragment();
			dispatch(ctx, mainFragment, false, type.ordinal(), null);
			break;

		default:
			break;
		}
		ft.commit();
	}

	private static void dispatch(Context ctx, Fragment fragment, boolean b,
			int ordinal, Bundle bundle) {

		if (ctx == null || fragment == null) {
			return;
		}

		if (bundle != null) {
			fragment.setArguments(bundle);
		}

		FragmentManager fm = ((FragmentActivity) ctx)
				.getSupportFragmentManager();
	}

}
