package org.linphone.core.tools.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.eitaa.messenger.voip.VoIPService;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.service.CoreManager;

/* loaded from: classes3.dex */
public class HeadsetReceiver extends BroadcastReceiver {
    public HeadsetReceiver() {
        Log.i("[Headset] Headset receiver created");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("[Headset] Headset broadcast received");
        if (action.equals(VoIPService.ACTION_HEADSET_PLUG)) {
            int intExtra = intent.getIntExtra("state", 0);
            String stringExtra = intent.getStringExtra("name");
            int intExtra2 = intent.getIntExtra("microphone", 0);
            if (intExtra == 0) {
                Log.i("[Headset] Headset disconnected: " + stringExtra);
            } else if (intExtra == 1) {
                Log.i("[Headset] Headset connected: " + stringExtra);
                if (intExtra2 == 1) {
                    Log.i("[Headset] Headset has a microphone");
                }
            } else {
                Log.w("[Headset] Unknown headset plugged state: " + intExtra);
            }
            if (CoreManager.isReady()) {
                CoreManager.instance().onHeadsetStateChanged();
            }
        }
    }
}
