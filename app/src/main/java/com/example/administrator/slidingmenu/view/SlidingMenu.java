package com.example.administrator.slidingmenu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/10/29.
 */
public class SlidingMenu extends HorizontalScrollView {
    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    //屏幕宽度
    private int mScreenWidth;
    private int mMenuWidth;
    //dp
    private int mMenuRightPadding = 50;

    private boolean once = false;

    private boolean isOpen;
    //未使用自定义属性时调用
    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWidth = outMetrics.widthPixels;
        //把sp转为px
        mMenuRightPadding =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50,context.getResources().getDisplayMetrics());
    }
    @Override
    //设置view和自己的宽、高
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once)
        {
            mWapper = (LinearLayout)getChildAt(0);
            mMenu = (ViewGroup)mWapper.getChildAt(0);
            mContent = (ViewGroup)mWapper.getChildAt(1);
            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - mMenuRightPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed)
        {
            this.scrollTo(mMenuWidth,0);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_UP:
                //隐藏在左边的宽度
                int scrollX = getScrollX();
                if (scrollX >= mMenuWidth / 2)
                {
                    this.smoothScrollTo(mMenuWidth,0);
                    isOpen = false;
                }else
            {
                this.smoothScrollTo(0,0);
                isOpen = true;
            }
            return true;
        }
        return super.onTouchEvent(ev);
    }
    public void openMenu()
    {
        if (isOpen)return;
        this.smoothScrollTo(0,0);
        isOpen = true;
    }
    public void closeMenu()
    {
        if (isOpen)return;
        this.smoothScrollTo(mMenuWidth,0);
        isOpen = false;
    }
    public void toggle()
    {
        if (isOpen)
        {
            closeMenu();
        }else
        {
            openMenu();
        }
    }

}
