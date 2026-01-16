package ir.eitaa.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class AppStartReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$AppStartReceiver$hz3Wu8e-F4Y6-JXlFeZWfK0TvfQ
            @Override // java.lang.Runnable
            public final void run() {
                AppStartReceiver.lambda$onReceive$0();
            }
        });
    }

    static /* synthetic */ void lambda$onReceive$0() {
        SharedConfig.loadConfig();
        if (SharedConfig.passcodeHash.length() > 0) {
            SharedConfig.appLocked = true;
            SharedConfig.saveConfig();
        }
        ApplicationLoader.startPushService();
    }
}
