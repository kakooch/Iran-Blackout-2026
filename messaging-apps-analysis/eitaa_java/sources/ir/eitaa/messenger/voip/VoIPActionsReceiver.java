package ir.eitaa.messenger.voip;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;

/* loaded from: classes.dex */
public class VoIPActionsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws IllegalStateException, InterruptedException, PendingIntent.CanceledException, IOException {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().handleNotificationAction(intent);
        }
    }
}
