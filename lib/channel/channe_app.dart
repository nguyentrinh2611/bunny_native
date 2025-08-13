import 'package:flutter/services.dart';

MethodChannel methodChannel = MethodChannel(ChanneApp.channelApp);

class ChanneApp {
  static const String channelApp = "channelApp";
  static const String channelGetBattery = "channelGetBattery";
}
