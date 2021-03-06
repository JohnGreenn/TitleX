package com.example.titlex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 描述：默认初始化基类
 * fileName：com.example.titlex
 * author：GLQ
 * time：2021/01/08 16:13
 */
public abstract class BaseBarInitializer implements ITitleBarInitializer{
    @Override
    public TextView getLeftView(Context context) {
        TextView leftView = createTextView(context);
        leftView.setCompoundDrawablesWithIntrinsicBounds(getBackIcon(context),null,null,null);
        leftView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT,Gravity.START));
        leftView.setGravity(Gravity.CENTER_VERTICAL);
        leftView.setFocusable(true);
        leftView.setSingleLine();
        leftView.setEllipsize(TextUtils.TruncateAt.END);
        leftView.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, leftView.getResources().getDisplayMetrics()));
        leftView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        return leftView;
    }

    @Override
    public TextView getRightView(Context context) {
        TextView rightView = createTextView(context);
        rightView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.END));
        rightView.setGravity(Gravity.CENTER_VERTICAL);
        rightView.setFocusable(true);
        rightView.setSingleLine();
        rightView.setEllipsize(TextUtils.TruncateAt.END);
        rightView.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, rightView.getResources().getDisplayMetrics()));
        rightView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        return rightView;
    }

    @Override
    public TextView getTitleView(Context context) {
        TextView titleView = createTextView(context);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL));
        titleView.setGravity(Gravity.CENTER);
        titleView.setFocusable(true);
        titleView.setSingleLine();
        // 给标题设置跑马灯效果（仅在标题过长的时候才会显示）
        titleView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        // 设置跑马灯的循环次数
        titleView.setMarqueeRepeatLimit(-1);
        // 设置跑马灯之后需要设置选中才能有效果
        titleView.setSelected(true);
        titleView.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, titleView.getResources().getDisplayMetrics()));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        return titleView;
    }

    @Override
    public View getLineView(Context context) {
        View lineView = new View(context);
        lineView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1, Gravity.BOTTOM));
        return lineView;
    }



    @Override
    public int getHorizontalPadding(Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, context.getResources().getDisplayMetrics());
    }

    @Override
    public int getVerticalPadding(Context context) {
        return 0;
    }

    protected TextView createTextView(Context context) {
        return new TextView(context);
    }

    public abstract Drawable getBackIcon(Context context);

    /**
     * 获取图片资源
     * @param context
     * @param id
     * @return
     */
    public static Drawable getBackgroundDrawble(Context context,int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(id, context.getTheme());
        } else {
            return context.getResources().getDrawable(id);
        }
    }

    /**
     * 设置View背景
     */
    public static void setViewBackground(View view,Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /**
     * 检查text view 是否包含内容
     */
    public static boolean checkContainContent(TextView textView) {
        CharSequence text = textView.getText();
        if(!TextUtils.isEmpty(text)){
            return true;
        }
        Drawable[] drawables = textView.getCompoundDrawables();
        for(Drawable drawable : drawables) {
            if(drawable != null){
                return true;
            }
        }
        return false;
    }
}
