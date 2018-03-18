package com.ybf.lottery.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @ClassName: DisplayUtil 
 * @Description: px 和dip dp的转换工具
 */
public class DisplayUtil {
	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 * 
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 * 
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * 
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param spValue
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}


	/**
	 * 获取屏幕的宽
	 * */
	public static int getScreenWidth(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		return wm.getDefaultDisplay().getWidth();

	}

	/**
	 * 屏幕的高
	 * */
	public static int getScreenHeight(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		return wm.getDefaultDisplay().getHeight();

	}

	/**
	 * 获取屏幕实际像素的宽高度
	 * */
	public static int[] getScreenWidthHeight(Context context) {

		DisplayMetrics dm = new DisplayMetrics();
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(dm);
		int widthPixels = dm.widthPixels;
		int heightPixels = dm.heightPixels;

		int[] result = { widthPixels, heightPixels };
		return result;

	}

	/**
	 * 设置背景透明度
	 *
	 * @param context
	 * @param bgAlpha
	 */
	public static void backgroundAlpha(Context context, float bgAlpha) {
		if(context == null) return;
		WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
		lp.alpha = bgAlpha;
		((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		((Activity)context).getWindow().setAttributes(lp);
	}
}
