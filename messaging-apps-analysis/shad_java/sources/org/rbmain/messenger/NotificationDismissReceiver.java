package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MyLog;

/* loaded from: classes4.dex */
public class NotificationDismissReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("currentAccount", UserConfig.selectedAccount);
        if (AccountInstance.getInstance(intExtra).getCoreMainClass().isAccountLoggedIn()) {
            AccountInstance.getInstance(intExtra).getDialogsProxy().loadCurrentUserFromCore();
        }
        if (UserConfig.isValidAccount(intExtra)) {
            long longExtra = intent.getLongExtra("dialogId", 0L);
            int intExtra2 = intent.getIntExtra("messageDate", 0);
            String dialogId = IdStorage.getInstance().getDialogId(longExtra);
            if (longExtra == 0) {
                MessagesController.getNotificationsSettings(intExtra).edit().putInt("dismissDate", intExtra2).apply();
                AccountInstance.getInstance(intExtra).getCoreMainClass().setAllNotificationsRead();
                return;
            }
            MyLog.e("NotificationDismissReceiver", "setNotificationReadByGuid");
            AccountInstance.getInstance(intExtra).getCoreMainClass().setNotificationReadByGuid(dialogId);
            MessagesController.getNotificationsSettings(intExtra).edit().putInt("dismissDate" + longExtra, intExtra2).apply();
        }
    }
}
