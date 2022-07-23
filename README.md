
# 深圳市昱显科技有限公司  API开发文档


> 发布版本：V0.0.3
> 
> 日期：2021-12-21
> 
> 文件密级：□绝密 □秘密 □内部资料 ■公开
> 
> 免责声明
> 
> 本文档按“现状”提供，本人不对本文档的任何陈述、信息和内容的准确性、可靠性、完整性、适销性、特定目的性和非侵权性提供任何明示或暗示的声明或保证。本文档仅作为使用指导的参考。本文档将可能在未经任何通知的情况下，不定期进行更新或修改。
> 
> 商标声明
> 
> 本文档可能提及的其他所有注册商标或商标，由其各自拥有者所有。  

**前言**

**概述**

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

## 串口
![输入图片说明](binary/uart.jpg)


## apk安装与卸载

/**
  * @method silentInstallApk(String apkPath) 
  * @description 静默安装apk
  * @param value，apk在文件系统中的绝对路径
  * @return void
*/  
public void silentInstallApk(String apkPath)


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
 gpio-102 (                    |IO4                 ) out hi
 gpio-111 (                    |IO3                 ) out hi
 gpio-112 (                    |IO2                 ) out hi
 gpio-113 (                    |IO1                 ) out hi
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

## 双屏异显
[参考此demo源码与说明](https://gitee.com/seasonkky/thirdparty/tree/master/DualScreenDemo)

## modem config  
/**
  * @method  changeMobileCarrier()
  * @description 设置网络类型
  * @param value，1 移动 2 联通 3 电信
  * @return -1 失败
*/  
public int changeMobileCarrier(int paramInt)  

/**
  * @method  getTelephonyImei()
  * @description 获取设备IMEI
  * @param value
  * @return 设备IMEI
*/  
public String getTelephonyImei()  

/**
  * @method  getSimSerialNumber()
  * @description 获取SIM卡number
  * @param value
  * @return sim卡number
*/  
public String getSimSerialNumber()  


public void turnOffBacklight()  //关闭主屏背光  
public void turnOnBacklight()   //打开主屏背光  
public boolean isBacklightOn()  //查询当前主屏背光是否打开  
public int getSystemBrightness()  //获取当前主屏亮度值  
public void turnOffBacklightExtend() //关闭副屏背光  
public void turnOnBacklightExtend()  //打开副屏背光  
public boolean isBacklightOnExtend()  //查询当前副屏背光是否打开  
public int getSystemBrightnessExtend()  //获取当前副屏亮度值  


/**
  * @method  getSensorReport()
  * @description 获取人体感应sensor当前开关状态
  * @param value
  * @return false 关，true 开
*/  
public boolean getSensorReport()   


/**
  * @method  setSensorReport(boolean param)
  * @description 设置人体感应开关
  * @param false 关， true 开
  * @return >0 成功
*/  
public int setSensorReport(boolean param)  

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