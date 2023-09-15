
# API Development document


The document mainly describes how the YX API can be quickly ported and used, so that developers can further develop and adapt the YX hardware platform.



## How do I use apis in Android Studio
(1)Copy yx.jar to [project directory \app\libs\];
![输入图片说明](binary/%E5%9B%BE%E7%89%871.png)  
(2)Right click on the jar file in the libs folder and select add as Library... Then select Model to import successfully as well  
![输入图片说明](binary/%E5%9B%BE%E7%89%872.png)  
(3)Getting started with the API
Note: All api calls must be declared before
MyManager manager = MyManager.getInstance(this);    
First you declare the MyManager object, and then you can start using the API. As the following example:
//Declare the MyManager object
YxDeviceManager manager = YxDeviceManager.getInstance(this);  
//USE API   
manager.getApiVersion()  
![输入图片说明](binary/%E5%9B%BE%E7%89%873.png)  

## apk installation and uninstallation

/**
  * @method silentInstallApk(String apkPath,boolean start) 
  * @description silentinstall apk
  * @param value，Absolute path of the apk in the file system. Whether the APK starts automatically after the installation is complete
  * @return void
*/  
public void silentInstallApk(String apkPath,boolean start)

/**
  * @method silentInstallApk(IYxInstallListener aListener,String apkPath,boolean start)
  * @description silentinstall apk
  * @param value，Absolute path of the apk in the file system, whether to start the APK after installation, and call back the listener after installation
  * @return void
*/  
public void silentInstallApk(IYxInstallListener aListener,String apkPath,boolean start)


/**
  * @method unInstallApk(String packagename) 
  * @description uninstall apk
  * @param value，apk package name
  * @return void
*/  
public void unInstallApk(String packagename)

## vendor storage Device spi nor storage area
/**
  * @method  setDeviceCustom(int ID,String value)
  * @description The customized information is written to the vendor partition and cannot be erased
  * @param value，The ID can only start from 16 and contain a maximum of 128 bytes
  * @return -1 write failed
*/  
public int setDeviceCustom(int ID,String value)

/**
  * @method  getDeviceCustom(int ID)
  * @description Reading vendor partition
  * @param value，The ID can only start from 16
  * @return Read the information
*/  
public int getDeviceCustom(int ID)  

/**
  * @method  setDeviceSerialno(String value)
  * @description The sn of the device is written to the vendor partition and cannot be erased
  * @param value，sn number
  * @return -1 write failed
*/  
public int setDeviceSerialno(String value)

/**
  * @method  setDeviceMacaddress(String value)
  * @description The physical Ethernet address of the device is written to the vendor partition and cannot be erased
  * @param value，mac address
  * @return -1 write failed
*/  
public int setDeviceMacaddress(String value)

## GPIO settings
| gpio number  |  func |  mode |  default |
|---|---|---|---|
| 114 | IO1  |  in/out | in  |
| 115 | IO2 |  in/out |  in |
| 94 | Infrared camera fill light |  in/out |  out |
| 88 | relay |  in/out |  out |
| 4 | Body sensing |  in/out |  in |

/**
  * @method  setGpioDirection(int gpio, int arg)
  * @description 设置GPIO方向
  * @param value，gpio number。1 is the input and 0 is the output
  * @return 
*/  
public boolean setGpioDirection(int gpio, int arg)

/**
  * @method  getGpioDirection(int gpio)
  * @description Get the GPIO direction
  * @param value，gpio number
  * @return gpio direction in/out
*/  
public String getGpioDirection(int gpio)

/**
  * @method  setGpioValue(int id,int value)
  * @description Set gpio high or low, valid only in output mode
  * @param value，gpio number: 0 low 1 high
  * @return -1 failed
*/  
public int setGpioValue(int id,int value)

/**
  * @method  getGpioValue(int id)
  * @description Get the GPIO level
  * @param value，gpio number
  * @return -1 Failure 0 Low 1 high
*/  
public int getGpioValue(int id)

## Status bar, navigation bar
/**
  * @method  setNavBar(boolean flag)
  * @description Set the navigation bar display hidden
  * @param value，true displays false hides
  * @return void
*/  
public void setNavBar(boolean flag) 

/**
  * @method  setStaBar(boolean flag)
  * @description Set the status bar display hidden
  * @param value，true displays false hides
  * @return void
*/  
public void setStaBar(boolean flag) 

## system
/**
  * @method  setScreenRotation(int value)
  * @description The system display direction takes effect after a restart
  * @param value，0 90 180 270
  * @return -1 failed
*/  
public int setScreenRotation(int value)

/**
  * @method  getScreenRotation()
  * @description Obtain the current system display direction
  * @param value，void
  * @return 0 90 180 270
*/  
public int getScreenRotation()

/**
  * @method  shutDownNow()
  * @description shutDownNow
  * @param value，void
  * @return -1 
*/  
public int shutDownNow()

/**
  * @method  rebootNow()
  * @description rebootNow
  * @param value，void
  * @return -1
*/  
public int rebootNow()

/**
  * @method  getSerialno()
  * @description Obtain the device SN
  * @param value，void
  * @return Device SN adb devices / adb get-serialno
*/  
public String getSerialno()

/**
  * @method  getTelephonyImei()
  * @description Obtain the device Imei. If no module exists, obtain the device IMEI from the vendor partition
  * @param value，void
  * @return Imei of the device
*/  
public String getTelephonyImei()  

/**
  * @method  getSimSerialNumber()
  * @description Obtain the iccid of the sim card
  * @param value，void
  * @return Obtain the iccid of the sim card
*/  
public String getSimSerialNumber() 

/**
  * @method  setScreenKeyGuard(boolean enable)
  * @description Set screen switch
  * @param value，true Open the screen; false screen off
  * @return void
*/  
public void setScreenKeyGuard(boolean enable)  

/**
  * @method  setSystemTime(long modify_time)
  * @description Setting the system time
  * @param value，Timestamp of the current time
  * @return void
*/  
public void setSystemTime(long modify_time)  

/**
  * @method  enableWatchdog()
  * @description Enable the watchdog
  * @param value，void
  * @return void
*/  
public void enableWatchdog()  

/**
  * @method  feedWatchdog()
  * @description  **The maximum timeout period of the hardware watchdog is 22 seconds. If the watchdog is not enabled at the application layer, the underlying layer automatically feeds the dog. After the application layer is enabled, the underlying layer stops feeding the dog** 
  * @param value，void
  * @return void
*/  
public void feedWatchdog()  

/**
  * @method  disableWatchdog()
  * @description  Stop the guard dogs
  * @param value，void
  * @return void
*/  
public void disableWatchdog()  

## Hardware control
### Fill-in light 
/**
  * @method  setOemFunc(String value)
  * @description Set the fill light color
  * @param lightron/lightroff lightgon/lightgoff Green on off lightbon/lightboff White On Off
  * @return void
*/  
public void setOemFunc(String value)  

### Infrared camera fill light
yx.setGpioDirection(94,0); //IR_CTL out  
yx.setGpioValue(94,1);  
yx.setGpioValue(94,0);  

### relay
yx.setGpioDirection(88,0); //relay out  
yx.setGpioValue(88,1);  
yx.setGpioValue(88,0);   

### body sensor
yx.setGpioDirection(4,1); 
yx.register(listener1,4); 
private IYxGpioListener listener1 = new IYxGpioListener.Stub() {  
        @Override  
        public void onNewValue(int b) throws RemoteException {  
            Log.d("test","gpio4 onNewValue:"+b);  
        }  
    };  

### wiegand
#### read
import android.os.yx.YxWiegand;  
YxWiegand yxWiegand;  
yxWiegand = YxWiegand.getInstance(this);  
yxWiegand.startReading(new YxWiegand.YxWiegandCallBack() {  
            @Override  
            public void onNewValue(byte[] bytes) {  
            }  
        });  
#### send
import android.os.yx.YxWiegand;  
YxWiegand yxWiegand;    
yxWiegand = YxWiegand.getInstance(this);   
byte[] wigend34 = {0x01, 0x02, 0x03, 0x04};  
yxWiegand.write(wigend34);  

### uart
|  name |  prop |  permission |   |
|---|---|---|---|
|  ttyS4 |  RS485 |  666 |   |
|  ttyS7 |  RS232 |  666 |   |


## OTA update  
/**
  * @method  upgradeSystem(String absolutePath)
  * @description Upgrade system
  * @param otaAbsolute path for storing the package
  * @return
*/  
public void upgradeSystem(String absolutePath)  

 /**
  * @method  setUpdateSystemWithDialog(boolean flag)
  * @description Set whether the user confirmation box is displayed (the setting takes effect permanently).
  * @param false No user confirmation is required; true requires user confirmation
  * @return
*/  
public void setUpdateSystemWithDialog(boolean flag)
