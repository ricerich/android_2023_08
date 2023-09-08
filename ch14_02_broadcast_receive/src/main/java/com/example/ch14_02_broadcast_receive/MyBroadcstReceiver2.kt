package com.example.ch14_02_broadcast_receive

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity

class MyBroadcstReceiver2(var act : MainActivity) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var action = intent.action
        if (action == Intent.ACTION_BATTERY_CHANGED) {
            var remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            act.edtBattery.setText("현재 충전량 : $remain\n")

            if (remain >= 90)
                act.ivBattery.setImageResource(R.drawable.battery_100)
            else if (remain >= 70)
                act.ivBattery.setImageResource(R.drawable.battery_80)
            else if (remain >= 50)
                act.ivBattery.setImageResource(R.drawable.battery_60)
            else if (remain >= 10)
                act.ivBattery.setImageResource(R.drawable.battery_20)
            else
                act.ivBattery.setImageResource(R.drawable.battery_0)

            var plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
            when (plug) {
                0 -> act.edtBattery.append("전원 연결 : 안됨")
                BatteryManager.BATTERY_PLUGGED_AC -> act.edtBattery.append("전원 연결 : 어댑터 연결됨")
                BatteryManager.BATTERY_PLUGGED_USB -> act.edtBattery.append("전원 연결 : USB 연결됨")
            }
        }
    }

}