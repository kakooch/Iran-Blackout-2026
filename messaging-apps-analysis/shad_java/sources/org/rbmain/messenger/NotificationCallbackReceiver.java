package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public class NotificationCallbackReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ApplicationLoader.postInitApplication();
        int intExtra = intent.getIntExtra("currentAccount", UserConfig.selectedAccount);
        if (UserConfig.isValidAccount(intExtra)) {
            SendMessagesHelper.getInstance(intExtra).sendNotificationCallback(intent.getLongExtra("did", 777000L), intent.getIntExtra("mid", 0), intent.getByteArrayExtra("data"));
        }
    }
}
