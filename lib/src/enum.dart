const DefaultRequestCode = 101;

// *****************************************************************************
// ************************************ Android ************************************
// *****************************************************************************
enum PermissionsAndroid {
  readExternalStorage, // 读取外部存储器上的文件
  writeExternalStorage, // 写外部存储器上的文件

  camera, // 访问相机

  recordAudio, // 录制音频

  accessFineLocation, // 访问精确位置信息
  accessCoarseLocation, // 访问大致位置信息

  receiveWapPush, // 接收WAP推送消息

  readContacts, // 读取联系人数据
  writeContacts, // 写联系人数据

  readCalendar, // 读取日历事件
  writeCalendar, // 写日历事件

  bodySensors, // 访问设备上的传感器数据（如心率监测器）

  readCallLog, // 读取通话记录
  readPhoneState, // 读取电话状态和标识
  callPhone, // 拨打电话
  writeCallLog, // 写通话记录
  useSip, // 使用SIP服务进行VoIP电话
  processOutgoingCalls, // 处理拨出电话

  addVoicemail, // 添加语音邮件

  readSms, // 读取短信
  receiveMms, // 接收彩信
  receiveSms, // 接收短信
  sendSms, // 发送短信

  getAccounts, // 获取账户信息
}

// *****************************************************************************
// ************************************ iOS ************************************
// *****************************************************************************
enum PermissionsIOS {
  photos, // 访问相册
  mediaLibrary, // 访问媒体库
  camera, // 访问相机
  microphone, // 访问麦克风
  location, // 访问位置信息
  notification, // 访问通知
  contacts, // 访问联系人
  calendar, // 访问日历
  health, // 访问健康
  reminders, // 访问提醒
  tracking, // 访问跟踪
  bluetooth, // 访问蓝牙
  dataNetwork, // 访问网络
}
