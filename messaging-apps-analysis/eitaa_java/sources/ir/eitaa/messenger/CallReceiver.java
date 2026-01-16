package ir.eitaa.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import ir.eitaa.PhoneFormat.PhoneFormat;

/* loaded from: classes.dex */
public class CallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PHONE_STATE") && TelephonyManager.EXTRA_STATE_RINGING.equals(intent.getStringExtra("state"))) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReceiveCall, PhoneFormat.stripExceptNumbers(intent.getStringExtra("incoming_number")));
        }
    }
}
