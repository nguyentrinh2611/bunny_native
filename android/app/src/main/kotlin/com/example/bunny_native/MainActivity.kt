package com.example.bunny_native

import com.example.bunny_native.modules.BunnyChannel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity : FlutterActivity(){
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        BunnyChannel.initMethod(flutterEngine.dartExecutor.binaryMessenger,this)
    }
}
