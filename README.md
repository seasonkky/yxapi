
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
  * @param value，gpio number。1为输入，0为输出
  * @return false 失败 true 成功
*/  
public boolean setGpioDirection(int gpio, int arg)

/**
  * @method  getGpioDirection(int gpio)
  * @description 获取GPIO方向
  * @param value，gpio number
  * @return gpio方向 in / out
*/  
public String getGpioDirection(int gpio)

/**
  * @method  setGpioValue(int id,int value)
  * @description 设置gpio高低，只有在输出模式有效
  * @param value，gpio number，0低1高
  * @return -1失败
*/  
public int setGpioValue(int id,int value)

/**
  * @method  getGpioValue(int id)
  * @description 获取GPIO高低
  * @param value，gpio number
  * @return -1失败 0低 1高
*/  
public int getGpioValue(int id)

## 状态栏，导航栏
/**
  * @method  setNavBar(boolean flag)
  * @description 设置导航栏显示隐藏
  * @param value，true 显示 false 隐藏
  * @return void
*/  
public void setNavBar(boolean flag) 

/**
  * @method  setStaBar(boolean flag)
  * @description 设置状态栏显示隐藏
  * @param value，true 显示 false 隐藏
  * @return void
*/  
public void setStaBar(boolean flag) 

## 系统
/**
  * @method  setScreenRotation(int value)
  * @description 设置系统显示方向，重启后生效
  * @param value，0 90 180 270
  * @return -1 失败
*/  
public int setScreenRotation(int value)

/**
  * @method  getScreenRotation()
  * @description 获取当前系统显示方向
  * @param value，void
  * @return 0 90 180 270
*/  
public int getScreenRotation()

/**
  * @method  shutDownNow()
  * @description 关机
  * @param value，void
  * @return -1失败
*/  
public int shutDownNow()

/**
  * @method  rebootNow()
  * @description 重启
  * @param value，void
  * @return -1失败
*/  
public int rebootNow()

/**
  * @method  getSerialno()
  * @description 获取设备SN号
  * @param value，void
  * @return 设备SN号 adb devices / adb get-serialno
*/  
public String getSerialno()

/**
  * @method  getTelephonyImei()
  * @description 获取设备Imei号,如果不存在模组，则从vendor分区读取
  * @param value，void
  * @return 设备Imei号
*/  
public String getTelephonyImei()  

/**
  * @method  getSimSerialNumber()
  * @description 获取sim卡iccid
  * @param value，void
  * @return 获取sim卡iccid
*/  
public String getSimSerialNumber() 

/**
  * @method  setScreenKeyGuard(boolean enable)
  * @description 设置屏幕开关
  * @param value，true 开屏；false 关屏
  * @return void
*/  
public void setScreenKeyGuard(boolean enable)  

/**
  * @method  setSystemTime(long modify_time)
  * @description 设置系统时间
  * @param value，当前时间的时间戳
  * @return void
*/  
public void setSystemTime(long modify_time)  

/**
  * @method  enableWatchdog()
  * @description 使能看门狗
  * @param value，void
  * @return void
*/  
public void enableWatchdog()  

/**
  * @method  feedWatchdog()
  * @description  **硬件看门狗的最大超时时间为 22 秒，在应用层没有使能看门狗时是靠底层自动喂狗，应用使能后底层会停止喂狗，应用层打开后要保证定时喂狗，建议定时时间少于 20 秒** 
  * @param value，void
  * @return void
*/  
public void feedWatchdog()  

/**
  * @method  disableWatchdog()
  * @description  停止看门狗
  * @param value，void
  * @return void
*/  
public void disableWatchdog()  

## 硬件控制  
### 补光灯 
/**
  * @method  setOemFunc(String value)
  * @description 设置补光灯颜色
  * @param lightron/lightroff 红灯亮灭  lightgon/lightgoff 绿灯亮灭   lightbon/lightboff 白灯亮灭
  * @return void
*/  
public void setOemFunc(String value)  

### 红外摄像头补光灯
yx.setGpioDirection(94,0); //IR_CTL out  
yx.setGpioValue(94,1);  
yx.setGpioValue(94,0);  

### 继电器
yx.setGpioDirection(88,0); //relay out  
yx.setGpioValue(88,1);  
yx.setGpioValue(88,0);   

### 人体感应
yx.setGpioDirection(4,1); 初始化GPIO4 为输入口   
yx.register(listener1,4);  增加监听器  
private IYxGpioListener listener1 = new IYxGpioListener.Stub() {  
        @Override  
        public void onNewValue(int b) throws RemoteException {  
            Log.d("test","gpio4 onNewValue:"+b);  
        }  
    };  

### 韦根
#### 读取
import android.os.yx.YxWiegand;  
YxWiegand yxWiegand;  
yxWiegand = YxWiegand.getInstance(this);  
yxWiegand.startReading(new YxWiegand.YxWiegandCallBack() {  
            @Override  
            public void onNewValue(byte[] bytes) {  
            }  
        });  
#### 发送
import android.os.yx.YxWiegand;  
YxWiegand yxWiegand;    
yxWiegand = YxWiegand.getInstance(this);   
byte[] wigend34 = {0x01, 0x02, 0x03, 0x04};  
yxWiegand.write(wigend34);  

### 串口节点
|  节点名称 |  属性 |  访问权限 |   |
|---|---|---|---|
|  ttyS4 |  RS485 |  666 |   |
|  ttyS7 |  RS232 |  666 |   |


## OTA升级  
/**
  * @method  upgradeSystem(String absolutePath)
  * @description 升级系统
  * @param ota包存放的绝对路径
  * @return
*/  
public void upgradeSystem(String absolutePath)  

 /**
  * @method  setUpdateSystemWithDialog(boolean flag)
  * @description 设置升级是否弹出用户确认框（设置后永久生效）
  * @param false 不需要用户确认，true 需要用户确认
  * @return
*/  
public void setUpdateSystemWithDialog(boolean flag)
