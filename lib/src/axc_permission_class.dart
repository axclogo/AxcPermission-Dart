import 'dart:async';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';

import 'enum.dart';

class AxcPermission {
  static const MethodChannel _Channel =
      const MethodChannel('club.axclogo.axc_permission');
}

extension PermissionToApi on AxcPermission {
  /// Check permissions
  /// 检查权限
  ///
  /// [androidPermissions] A set of Android permissions to check. See [PermissionsAndroid]
  /// [androidPermissions] 一组要检查的Android权限。参见 [PermissionsAndroid]
  ///
  /// [iosPermissions] A set of iOS permissions to check. See [PermissionsIOS]
  /// [iosPermissions] 一组要检查的iOS权限。参见 [PermissionsIOS]
  ///
  /// Returns true if permission is granted, false otherwise.
  /// 已获得授权时返回：true，否则返回：false
  static Future<bool> CheckStatus(
      {required List<PermissionsAndroid> androidPermissions,
      required List<PermissionsIOS> iosPermissions}) async {
    try {
      var list = [];
      if (Platform.isIOS) {
        // iOS
        list = GetPermissionsIndex(androidPermissions);
      } else if (Platform.isAndroid) {
        // Android
        list = GetPermissionsIndex(iosPermissions);
      }
      return await AxcPermission._Channel.invokeMethod(
          'hasPermissions', {"perms": list});
    } catch (e, s) {
      debugPrint('$e\n$s');
    }
    return false;
  }

  /// Request Permissions
  /// 请求权限
  ///
  /// [androidPermissions] A set of Android permissions to check. See [PermissionsAndroid]
  /// [androidPermissions] 一组要检查的Android权限。参见 [PermissionsAndroid]
  ///
  /// [iosPermissions] A set of iOS permissions to check. See [PermissionsIOS]
  /// [iosPermissions] 一组要检查的iOS权限。参见 [PermissionsIOS]
  ///
  /// [rationale] Only valid for Android. Explains why the application needs this set of permissions;
  ///  if the user refuses the request for the first time, this information will be displayed.
  /// [rationale] 仅Android有效。解释为什么应用程序需要这组权限；如果用户第一次拒绝请求，将显示该信息。
  ///
  /// [requestCode] Tracks the request code for this request, must be an integer less than 256, and will be returned in the [Granted] and [Denied] callbacks.
  /// [requestCode] 追踪此请求的请求码，必须是小于256的整数，将在[Granted]、[Denied]回调中返回
  static void Request(
      {required List<PermissionsAndroid> androidPermissions,
      required List<PermissionsIOS> iosPermissions,
      String? rationale,
      int requestCode = DefaultRequestCode}) async {
    try {
      var list = [];
      if (Platform.isIOS) {
        // iOS
        list = GetPermissionsIndex(androidPermissions);
      } else if (Platform.isAndroid) {
        // Android
        list = GetPermissionsIndex(iosPermissions);
      }
      await AxcPermission._Channel.invokeMethod('requestPermissions',
          {"perms": list, "rationale": rationale, "requestCode": requestCode});
    } catch (e, s) {
      debugPrint('$e\n$s');
    }
  }

  /// 获取权限索引列表
  /// Returns a list of permission indexes.
  ///
  /// The [permissionsList] parameter is a list of dynamic objects representing permissions.
  /// [permissionsList] 参数是一个包含权限对象的动态列表
  ///
  /// If the [permissionsList] is not empty, it checks if it is a List<PermissionsIOS> or List<PermissionsAndroid>.
  /// 如果 [permissionsList] 不为空，它会检查是否为 List<PermissionsIOS> 或 List<PermissionsAndroid> 类型
  ///
  /// If it is, it maps the 'index' property of each object in the list and returns a new list of integers.
  /// 如果是这两种类型之一，它会映射列表中每个对象的 'index' 属性，并返回一个新的整数列表
  ///
  /// If the [permissionsList] is empty or not of the expected types, it throws an Exception.
  /// 如果 [permissionsList] 为空或不是期望的类型，则会抛出异常
  static List<int> GetPermissionsIndex(List<dynamic> permissionsList) {
    if (permissionsList.isNotEmpty) {
      if (permissionsList is List<PermissionsIOS>) {
        return permissionsList.map((e) => e.index).toList();
      } else if (permissionsList is List<PermissionsAndroid>) {
        return permissionsList.map((e) => e.index).toList();
      }
    }
    throw Exception(
        "_getPermissionsIndex: parameter 'permissionsList' cannot be null or empty");
  }
}
