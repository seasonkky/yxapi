package com.example.yxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.yx.YxDeviceManager;
import android.os.yx.IYxGpioListener;

import android.os.Bundle;
import android.os.yx.YxGpioListener;
import android.os.yx.YxWiegand;
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
    YxWiegand yxWiegand;

    private TextView info;

    private ToggleButton tb1;
    private ToggleButton tb2;
    private ToggleButton tb3;
    private ToggleButton tb4;
    private ToggleButton tb5;
    private ToggleButton tb6;

    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yx = YxDeviceManager.getInstance(this);
        info = findViewById(R.id.textView);
        info.setText(yx.getTelephonyImei());
        InitButton();
        initGpio();

        yx.register(listener1,4);
        yx.register(listener2,114);
        yx.register(listener3,115);


        initWiegand();
    };

    private IYxGpioListener listener1 = new IYxGpioListener.Stub() {
        @Override
        public void onNewValue(int b) throws RemoteException {
            Log.d("test","gpio4 onNewValue:"+b);
            info.setText("gpio4 onNewValue:"+b);
        }
    };

    private IYxGpioListener listener2 = new IYxGpioListener.Stub() {
        @Override
        public void onNewValue(int b) throws RemoteException {
            Log.d("test","gpio114 onNewValue:"+b);
            info.setText("gpio114 onNewValue:"+b);
        }
    };

    private IYxGpioListener listener3 = new IYxGpioListener.Stub() {
        @Override
        public void onNewValue(int b) throws RemoteException {
            Log.d("test","gpio115 onNewValue:"+b);
            info.setText("gpio115 onNewValue:"+b);
        }
    };

    private void initWiegand() {
        yxWiegand = YxWiegand.getInstance(this);
        yxWiegand.startReading(new YxWiegand.YxWiegandCallBack() {
            @Override
            public void onNewValue(byte[] bytes) {
                info.append("wiegand read:"+new String(bytes));
            }
        });
    }

    private void InitButton() {
        tb1 = findViewById(R.id.toggleButton);
        tb1.setOnClickListener(this);

        tb2 = findViewById(R.id.toggleButton2);
        tb2.setOnClickListener(this);

        tb3 = findViewById(R.id.toggleButton3);
        tb3.setOnClickListener(this);

        tb4 = findViewById(R.id.toggleButton4);
        tb4.setOnClickListener(this);

        tb5 = findViewById(R.id.toggleButton5);
        tb5.setOnClickListener(this);

        tb6 = findViewById(R.id.toggleButton6);
        tb6.setOnClickListener(this);

        bt1 = findViewById(R.id.button);
        bt1.setOnClickListener(this);
    }

    private void initGpio() {
        yx.setGpioDirection(88,0); //relay out
        yx.setGpioDirection(4,1); //body in
        yx.setGpioDirection(114,1); //IO1 in
        yx.setGpioDirection(115,1); //IO2 in
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                if(tb1.isChecked())
                {
                    yx.setOemFunc("lightron");
                }
                    else
                {
                    yx.setOemFunc("lightroff");
                }
                break;
            case R.id.toggleButton2:
                if(tb2.isChecked())
                {
                    yx.setOemFunc("lightgon");
                }
                else
                {
                    yx.setOemFunc("lightgoff");
                }
                break;
            case R.id.toggleButton3:
                if(tb3.isChecked())
                {
                    yx.setOemFunc("lightbon");
                }
                else
                {
                    yx.setOemFunc("lightboff");
                }
                break;
            case R.id.toggleButton4:
                if(tb4.isChecked())
                {
                    yx.setGpioValue(88,1);
                }
                else
                {
                    yx.setGpioValue(88,0);
                }
                break;
            case R.id.toggleButton5:
                if(tb5.isChecked())
                {
                    yx.setGpioValue(114,1);
                }
                else
                {
                    yx.setGpioValue(114,0);
                }
                break;
            case R.id.toggleButton6:
                if(tb6.isChecked())
                {
                    yx.setGpioValue(115,1);
                }
                else
                {
                    yx.setGpioValue(115,0);
                }
                break;
            case R.id.button:
                yx.setSystemTime(1664609612000L);
                default:
                    break;
        }
    }
}
