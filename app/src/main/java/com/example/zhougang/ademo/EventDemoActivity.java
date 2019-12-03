package com.example.zhougang.ademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 事件分发
 *
 * @author zhoguang@unipus.cn
 * @date 2019/12/3 10:15
 */
public class EventDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = EventDemoActivity.class.getSimpleName();
    private MyLayout viewGroup1;
    private MyButton bt_child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_demo);

        viewGroup1 = findViewById(R.id.viewgroup1);
        bt_child = findViewById(R.id.bt_child);

//        viewGroup1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e(TAG, "EventDemoActivity dispatchTouchEvent");
        return false;
//        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e(TAG, "EventDemoActivity onTouchevent");
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {

    }
}
