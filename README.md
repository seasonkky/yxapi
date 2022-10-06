
# API开发文档


文档主要介绍YX API如何快速移植使用， 让开发者能够进一步开发和适配YX硬件平台。



## 如何在Android Studio中使用 API
(1)将yx.jar复制到【工程目录\app\libs\】下；  
![输入图片说明](binary/%E5%9B%BE%E7%89%871.png)  
(2)右键点击libs文件夹中的jar文件选择 add as Library...然后选择Model，这样也可以导入成功  
![输入图片说明](binary/%E5%9B%BE%E7%89%872.png)  
(3)开始使用 API  
注意：所有的api调用前必须声明  
MyManager manager = MyManager.getInstance(this);    
首先要声明 MyManager 对象， 然后就可以开始使用 API.如下面例子：   
//声明 MyManager 对象  
YxDeviceManager manager = YxDeviceManager.getInstance(this);  
//使用 API   
manager.getApiVersion()  
![输入图片说明](binary/%E5%9B%BE%E7%89%873.png)  

## apk安装与卸载

/**
  * @method silentInstallApk(String apkPath,boolean start) 
  * @description 静默安装apk
  * @param value，apk在文件系统中的绝对路径,安装完成后是否自启动
  * @return void
*/  
public void silentInstallApk(String apkPath,boolean start)


/**
  * @method unInstallApk(String packagename) 
  * @description 静默卸载apk
  * @param value，apk包名
  * @return void
*/  
public void unInstallApk(String packagename)

## vendor storage 设备spi nor存储区域

/**
  * @method  setDeviceSerialno(String value)
  * @description 写入设备sn号，保存到vendor分区，不可擦除
  * @param value，sn number
  * @return -1 写入失败
*/  
public int setDeviceSerialno(String value)

/**
  * @method  setDeviceMacaddress(String value)
  * @description 写入设备以太网物理地址，保存到vendor分区，不可擦除
  * @param value，mac address
  * @return -1 写入失败
*/  
public int setDeviceMacaddress(String value)

## GPIO设置
| gpio number  |  func |  mode |  default |
|---|---|---|---|
| 114 | IO1  |  in/out | in  |
| 115 | IO2 |  in/out |  in |
| 88 | 继电器 |  in/out |  in |
| 4 | 人体感应 |  in/out |  in |

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

### 继电器
yx.setGpioDirection(88,0); //relay out  
yx.setGpioValue(88,1);  
yx.setGpioValue(88,0);   

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