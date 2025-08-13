package com.example.bunny_native.modules

import android.content.Context
import android.os.BatteryManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.bunny_native.utils.AppConstants
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

object BunnyChannel {
    fun initMethod(binaryMessenger: BinaryMessenger, context: Context ){
        MethodChannel(binaryMessenger, AppConstants.CHANNEL_APP).setMethodCallHandler { call, result ->
            when(call.method){
                AppConstants.CHANNEL_GET_BATTERY ->{
                    val batteryLevel = getBatteryLevel(context)
                    result.success(batteryLevel)
                }
                else ->{
                    result.notImplemented()
                }
            }

        }

    }

    private fun getBatteryLevel(context: Context): Int {
        val batteryManager = getSystemService(context,BatteryManager::class.java)
        val batteryLevel = batteryManager?.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        return batteryLevel!!

    }
}