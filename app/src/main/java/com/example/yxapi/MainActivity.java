package com.example.yxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.yx.YxDeviceManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements View.OnClickListener{

    YxDeviceManager yx;

    private TextView info;

    private ToggleButton tb1;


    public Handler mHandler;
    private Thread mClockThread;

    private static boolean threadFlag = false;
    private static final int R_PASS = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yx = YxDeviceManager.getInstance(this);
        info = findViewById(R.id.textView);

        InitButton();
        InitHandle();
    }

    private void initGpio() {
        yx.setGpioDirection(113,1); //IO4 IN
        yx.setGpioDirection(112,1); //IO3 IN
        yx.setGpioDirection(111,0); //IO2 OUT
        yx.setGpioDirection(102,1); //IO1 IN
    }
    private void InitHandle() {
        mHandler = new Handler()
        {
            public void handleMessage(Message msg)
            {
                switch (msg.what)
                {
                    case R_PASS:
                        info.setText("LOCK_DECT io direction:"+yx.getGpioDirection(102) + ",value:"+yx.getGpioValue(102) + "\n" +
                                "OPEN IO direction:"+yx.getGpioDirection(111) + ",value:"+yx.getGpioValue(111) + "\n" +
                                "NO IO direction:"+yx.getGpioDirection(112) + ",value:"+yx.getGpioValue(112) + "\n" +
                                "NC IO direction:"+yx.getGpioDirection(113) + ",value:"+yx.getGpioValue(113) + "\n");
                        break;
                }
                super.handleMessage(msg);
            }
        };
        mClockThread = new LooperThread();
        mClockThread.start();
    }

    private void InitButton() {
        tb1 = findViewById(R.id.toggleButton);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                if(tb1.isChecked())
                {
                    yx.setGpioValue(111,1);
                }
                    else
                {
                    yx.setGpioValue(111,0);
                }
                break;
                default:
                    break;
        }
    }

    class LooperThread extends Thread
    {
        public void run()
        {
            super.run();
            try
            {
                do
                {
                    Thread.sleep(500);
                    mHandler.sendEmptyMessageDelayed(R_PASS, 0);

                } while (MainActivity.LooperThread.interrupted() == false && threadFlag);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        threadFlag = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        threadFlag = false;
        super.onPause();
    }

}
