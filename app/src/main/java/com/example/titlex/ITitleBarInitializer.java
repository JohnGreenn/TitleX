package com.example.titlex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

/**
 * 描述：
 * fileName：com.example.titlex
 * author：GLQ
 * time：2021/01/08 15:46
 */

public interface ITitleBarInitializer {
    /**
     * 获取左标题view
     */
    TextView getLeftView(Context context);

    /**
     * 获取右标题view
     */
    TextView getRightView(Context context);

    /**
     * 获取中间标题view
     */
    TextView getTitleView(Context context);

    /**
     * 获取分割线View
     */
    View getLineView(Context context);

    /**
     * 获取标题栏背景
     */
    Drawable getBackgroundDrawble(Context context);

    /**
     * 获取子控件的水平内间距
     */
    int getHorizontalPadding(Context context);

    /**
     * 获取子控件的垂直内间距
     */
    int getVerticalPadding(Context context);


}
