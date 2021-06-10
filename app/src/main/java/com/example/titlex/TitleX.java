package com.example.titlex;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 描述：
 * fileName：com.example.titlex
 * author：GLQ
 * time：2021/01/08 15:01
 */
public class TitleX extends FrameLayout implements View.OnClickListener,View.OnLayoutChangeListener{

    /** 默认初始化器 */
    private static ITitleBarInitializer sGlobalInitializer;
    /** 当前初始化器 */
    private final ITitleBarInitializer mCurrentInitializer;
    /** 标题栏子控件 */
    private final TextView mLeftView, mTitleView, mRightView;
    private final View mLineView;

    public TitleX(@NonNull Context context) {
        this(context,null,0);
    }

    public TitleX(@NonNull Context context,@Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleX(@NonNull Context context,@Nullable AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);

        if (sGlobalInitializer == null) {
            sGlobalInitializer = new LightBarInitializer();
        }


        final TypedArray array = getContext().obtainStyledAttributes(attrs,R.styleable.TitleX);
        //标题栏样式设置
        mCurrentInitializer = new LightBarInitializer();

        mLeftView = mCurrentInitializer.getLeftView(context);
        mTitleView = mCurrentInitializer.getTitleView(context);
        mRightView = mCurrentInitializer.getRightView(context);
        mLineView = mCurrentInitializer.getLineView(context);

        //左边返回图标显示
        if(array.hasValue(R.styleable.TitleX_leftIcon)) {
            setLeftIcon(BaseBarInitializer.getBackgroundDrawble(getContext(),array.getResourceId(R.styleable.TitleX_leftIcon,0)));
        } else {

        }

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onLayoutChange(View view,int left,int top,int right,int bottom,int oldLeft,int oldTop,int oldRigjt,int oldBottom) {
        // 先移除当前的监听，因为 TextView.setMaxWidth 方法会重新触发监听
        removeOnLayoutChangeListener(this);


    }

    public TitleX setLeftIcon(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        mLeftView.setCompoundDrawables(drawable, null, null, null);
        return this;
    }
}
