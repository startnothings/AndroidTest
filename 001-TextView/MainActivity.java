package com.example.recyc;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int temp = 0;
    private TextView tv_marquee;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_marquee = (TextView)findViewById(R.id.tv_marquee);
        spark();
    }
    //TextView闪烁效果
    public void spark() {        
        TimerTask timerTask = new TimerTask() 
        {
        	//run方法需要覆写
            public void run() 
            {
                runOnUiThread(new Runnable() 
                {//UI线程上运行
                    public void run() 
                    {                    	
                    	switch (temp)
                    	{
                    	case 0:
                    		temp=1;
                    		tv_marquee.setTextColor(Color.YELLOW);
                    		break;
                    	case 1:
                    		 temp = 0;
                            tv_marquee.setTextColor(Color.GREEN);
                            break;
                    	}

                    }
                });
            }
        };
        //schedule方法有三个参数： 第一个参数是TimerTask对象，第二个参数是执行延迟时间，第三个参数为间隔周期。 
        Timer timer = new Timer();
        timer.schedule(timerTask, 1, 100);
    }
}
