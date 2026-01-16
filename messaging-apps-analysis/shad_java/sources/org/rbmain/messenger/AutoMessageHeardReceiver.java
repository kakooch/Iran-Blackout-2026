package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidMessenger.proxy.IdStorage;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes4.dex */
public class AutoMessageHeardReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ApplicationLoader.postInitApplication();
        final long longExtra = intent.getLongExtra("dialog_id", 0L);
        final String dialogId = IdStorage.getInstance().getDialogId(longExtra);
        final long longExtra2 = intent.getLongExtra("max_id", 0L);
        final int intExtra = intent.getIntExtra("currentAccount", 0);
        if (longExtra == 0 || longExtra2 == 0 || !UserConfig.isValidAccount(intExtra)) {
            return;
        }
        final int i = (int) longExtra;
        final AccountInstance accountInstance = AccountInstance.getInstance(intExtra);
        if (i > 0) {
            if (accountInstance.getMessagesController().getUser(Integer.valueOf(i)) == null) {
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.AutoMessageHeardReceiver$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutoMessageHeardReceiver.lambda$onReceive$1(accountInstance, i, intExtra, dialogId, longExtra, longExtra2);
                    }
                });
                return;
            }
        } else if (i < 0 && accountInstance.getMessagesController().getChat(Integer.valueOf(-i)) == null) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.AutoMessageHeardReceiver$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AutoMessageHeardReceiver.lambda$onReceive$3(accountInstance, i, intExtra, dialogId, longExtra, longExtra2);
                }
            });
            return;
        }
        AccountInstance.getInstance(intExtra).getCoreMainClass().setNotificationReadByGuid(dialogId);
        MessagesController.getInstance(intExtra).markDialogAsRead(longExtra, longExtra2, longExtra2, 0, false, 0L, 0, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceive$1(final AccountInstance accountInstance, int i, final int i2, final String str, final long j, final long j2) {
        final TLRPC$User userSync = accountInstance.getMessagesStorage().getUserSync(i);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.AutoMessageHeardReceiver$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AutoMessageHeardReceiver.lambda$onReceive$0(accountInstance, userSync, i2, str, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceive$0(AccountInstance accountInstance, TLRPC$User tLRPC$User, int i, String str, long j, long j2) {
        accountInstance.getMessagesController().putUser(tLRPC$User, true);
        AccountInstance.getInstance(i).getCoreMainClass().setNotificationReadByGuid(str);
        MessagesController.getInstance(i).markDialogAsRead(j, j2, j2, 0, false, 0L, 0, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceive$3(final AccountInstance accountInstance, int i, final int i2, final String str, final long j, final long j2) {
        final TLRPC$Chat chatSync = accountInstance.getMessagesStorage().getChatSync(-i);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.AutoMessageHeardReceiver$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AutoMessageHeardReceiver.lambda$onReceive$2(accountInstance, chatSync, i2, str, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onReceive$2(AccountInstance accountInstance, TLRPC$Chat tLRPC$Chat, int i, String str, long j, long j2) {
        accountInstance.getMessagesController().putChat(tLRPC$Chat, true);
        AccountInstance.getInstance(i).getCoreMainClass().setNotificationReadByGuid(str);
        MessagesController.getInstance(i).markDialogAsRead(j, j2, j2, 0, false, 0L, 0, true, 0);
    }
}
