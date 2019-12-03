package com.example.zhougang.ademo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MyLayout extends RelativeLayout {


    private static final String TAG = MyLayout.class.getSimpleName();

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //Activity

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        show("dispatchTouchEvent", ev);
//        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        show("onTouchEvent", event);
//        Log.e(TAG,super.onTouchEvent(event)+"");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return true;
        return super.onInterceptTouchEvent(ev);
    }

    private void show(String methodName, MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                Log.e(TAG, methodName + ": ACTION_DOWN");
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG, methodName + ": ACTION_MOVE");
            }
            break;
            case MotionEvent.ACTION_UP: {
                Log.e(TAG, methodName + ": ACTION_UP");
            }
            break;
            case MotionEvent.ACTION_CANCEL: {
                Log.e(TAG, methodName + ": ACTION_CANCEL");
            }
            break;
        }
    }

}
