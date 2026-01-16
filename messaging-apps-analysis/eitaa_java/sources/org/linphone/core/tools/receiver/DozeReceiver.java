package org.linphone.core.tools.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class DozeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT >= 23) {
            Log.i("[Platform Helper] [Doze Receiver] Doze mode enabled: " + powerManager.isDeviceIdleMode());
        }
    }
}
