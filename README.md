开始使用 API  
首先要声明 MyManager 对象， 然后就可以开始使用 API.如下面例子：  
//声明 MyManager 对象  
YxDeviceManager manager = YxDeviceManager.getInstance(this);  
//使用 API  
manager.getApiVersion()


## 20211218 update

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
public void silentInstallApk(String apkPath)


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
### M583
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


