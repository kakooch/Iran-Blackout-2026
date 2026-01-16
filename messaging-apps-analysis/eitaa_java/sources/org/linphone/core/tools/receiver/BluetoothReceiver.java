package org.linphone.core.tools.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.service.CoreManager;

/* loaded from: classes3.dex */
public class BluetoothReceiver extends BroadcastReceiver {
    public BluetoothReceiver() {
        Log.i("[Bluetooth] Bluetooth receiver created");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("[Bluetooth] Bluetooth broadcast received");
        if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra != Integer.MIN_VALUE) {
                switch (intExtra) {
                    case 10:
                        Log.w("[Bluetooth] Adapter has been turned off");
                        if (CoreManager.isReady()) {
                            CoreManager.instance().onBluetoothHeadsetStateChanged();
                            break;
                        }
                        break;
                    case 11:
                        Log.i("[Bluetooth] Adapter is being turned on");
                        break;
                    case 12:
                        Log.i("[Bluetooth] Adapter has been turned on");
                        if (CoreManager.isReady()) {
                            CoreManager.instance().onBluetoothAdapterTurnedOn();
                            break;
                        }
                        break;
                    case 13:
                        Log.w("[Bluetooth] Adapter is being turned off");
                        break;
                    default:
                        Log.w("[Bluetooth] Unknown adapter state: ", Integer.valueOf(intExtra));
                        break;
                }
            }
            Log.e("[Bluetooth] Adapter is in error state !");
            return;
        }
        if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.NAME");
            if (intExtra2 == 2) {
                if (bluetoothDevice != null) {
                    Log.i("[Bluetooth] Bluetooth headset connected: [", bluetoothDevice.getName(), "]");
                } else {
                    Log.i("[Bluetooth] Bluetooth headset connected: [unknown device]");
                }
                if (CoreManager.isReady()) {
                    CoreManager.instance().onBluetoothHeadsetStateChanged();
                    return;
                }
                return;
            }
            if (intExtra2 == 0) {
                if (bluetoothDevice != null) {
                    Log.i("[Bluetooth] Bluetooth headset disconnected: [", bluetoothDevice.getName(), "]");
                } else {
                    Log.i("[Bluetooth] Bluetooth headset disconnected: [unknown device]");
                }
                if (CoreManager.isReady()) {
                    CoreManager.instance().onBluetoothHeadsetStateChanged();
                    return;
                }
                return;
            }
            if (intExtra2 == 1) {
                Log.i("[Bluetooth] Bluetooth headset connecting");
                return;
            }
            Log.w("[Bluetooth] Bluetooth headset unknown state changed: " + intExtra2);
            return;
        }
        Log.w("[Bluetooth] Bluetooth unknown action: " + action);
    }
}
