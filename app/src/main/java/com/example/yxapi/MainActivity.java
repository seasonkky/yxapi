package com.example.yxapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    private TextView info1;

    private Button bt_reboot;
    private ToggleButton tb1;
    private ToggleButton tb2;
    private Spinner spi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yx = YxDeviceManager.getInstance(this);

        InitDeviceInfo();
        InitButton();
        InitSpinner();
    }

    private void InitDeviceInfo() {
        info=(TextView)findViewById(R.id.textView);
        info.setText("API version:"+yx.getApiVersion() + "\n"+
                     "Android version:"+yx.getAndroidVersion() + "\n"+
                     "kernel version:"+yx.getKernelVersion() + "\n" +
                      "getAndroidModle:"+yx.getAndroidModle() + "\n" +
                     "固件版本:"+yx.getFirmwareDate()+ "\n"+
                      "设备SN号:"+yx.getSerialno()+"\n"+
                      "root status:"+yx.getRootStatus() + "\n" +
                       "存储:"+yx.getInternalStorageMemory() +"\n" +
                        "内存:" + yx.getRunningMemory()+"\n" +
                        "屏幕方向:"+yx.getScreenRotation() + "\n" +
                         "IO1:"+yx.getGpioValue(1) + "\n" +
                         "IO2:"+yx.getGpioValue(2) + "\n" +
                        "IO3:"+yx.getGpioValue(3) + "\n" +
                        "IO4:" + yx.getGpioValue(4)+ "\n"
                        );
    }

    private void InitButton() {
        tb1 = findViewById(R.id.toggleButton);
        tb2 = findViewById(R.id.toggleButton2);

       findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.toggleButton).setOnClickListener(this);
        findViewById(R.id.toggleButton2).setOnClickListener(this);

    }

    private void InitSpinner() {
        info1 = findViewById(R.id.textView1);
        info1.setText("设置屏幕方向，当前屏幕方向:"+yx.getScreenRotation());
        spi = findViewById(R.id.spinner2);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if(pos == 1) {
                    yx.setScreenRotation(0);
                    yx.rebootNow();
                }
                else if(pos == 2) {
                    yx.setScreenRotation(90);
                    yx.rebootNow();
                }
                else if(pos == 3) {
                    yx.setScreenRotation(180);
                    yx.rebootNow();
                }
                else if(pos == 4) {
                    yx.setScreenRotation(270);
                    yx.rebootNow();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Log.d("yx","reboot button click");
                yx.rebootNow();
                break;
            case  R.id.button2:
                Log.d("yx","shut down button click");
                yx.shutDownNow();
                break;
            case R.id.toggleButton:
                if(tb1.isChecked())
                {
                    Log.d("yx","toggle button click isChecked");
                    yx.setNavBar(false);
                }
                    else
                {
                    Log.d("yx","toggle button click");
                    yx.setNavBar(true);
                }
                break;
            case R.id.toggleButton2:
                Log.d("yx","toggle2222 button click");
                if(tb2.isChecked())
                {
                    Log.d("yx","toggle2 button click isChecked");
                    yx.setStaBar(false);
                }
                else
                {
                    Log.d("yx","toggle2 button click");
                    yx.setStaBar(true);
                }
                break;
                default:
                    break;
        }
    }
}
