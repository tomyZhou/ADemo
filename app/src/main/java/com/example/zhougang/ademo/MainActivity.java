package com.example.zhougang.ademo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * handler没什么大不了的，自己写一个小例子替代handler，messageQueue，Looper
 *
 * @author zhoguang@unipus.cn
 * @date 2019/12/2 16:13
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv_hello;
    private static  LinkedList<MyMessage> messageList = new LinkedList<>();
    private OnMessageOperator operator = new OnMessageOperator() {
        @Override
        public void operateMessage(MyMessage message) {
            tv_hello.setText(message.name);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.tv_hello);
        new SubThread().start();

//        while (true){
//            if(!messageList.isEmpty()){
//                MyMessage message = messageList.pop();
//                operator.operateMessage(message);
//            }
//        }

        new CountDownTimer(1000000000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                refresh();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void refresh() {
        if (!messageList.isEmpty()) {
            MyMessage myMessage = messageList.pop();
            operator.operateMessage(myMessage);
        }
    }


    public static  class SubThread extends Thread {
        @Override
        public void run() {
            super.run();

            new Timer().schedule(new TimerTask() {
                int i = 1;

                @Override
                public void run() {
                    MyMessage message = new MyMessage();
                    message.name = "更新数字" + (i++);
                    message.type = 1;
                    message.param1 = "10";

                    messageList.push(message);
                }
            }, 1000, 1000);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        messageList.clear();
        messageList = null;
    }
}
