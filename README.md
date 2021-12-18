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

