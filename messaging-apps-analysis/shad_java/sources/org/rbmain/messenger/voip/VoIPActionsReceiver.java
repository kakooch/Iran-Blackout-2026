package org.rbmain.messenger.voip;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public class VoIPActionsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PendingIntent.CanceledException {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().handleNotificationAction(intent);
        }
    }
}
