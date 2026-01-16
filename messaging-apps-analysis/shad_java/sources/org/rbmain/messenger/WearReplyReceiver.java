package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class WearReplyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ApplicationLoader.postInitApplication();
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent == null) {
            return;
        }
        final CharSequence charSequence = resultsFromIntent.getCharSequence(NotificationsController.EXTRA_VOICE_REPLY);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        final long longExtra = intent.getLongExtra("dialog_id", 0L);
        final long longExtra2 = intent.getLongExtra("max_id", 0L);
        int intExtra = intent.getIntExtra("currentAccount", 0);
        if (longExtra == 0 || longExtra2 == 0 || !UserConfig.isValidAccount(intExtra)) {
            return;
        }
        final int i = (int) longExtra;
        final AccountInstance accountInstance = AccountInstance.getInstance(intExtra);
        if (i > 0) {
            if (accountInstance.getMessagesController().getUser(Integer.valueOf(i)) == null) {
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.WearReplyReceiver$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onReceive$1(accountInstance, i, charSequence, longExtra, longExtra2);
                    }
                });
                return;
            }
        } else if (i < 0 && accountInstance.getMessagesController().getChat(Integer.valueOf(-i)) == null) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.WearReplyReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReceive$3(accountInstance, i, charSequence, longExtra, longExtra2);
                }
            });
            return;
        }
        sendMessage(accountInstance, charSequence, longExtra, longExtra2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$1(final AccountInstance accountInstance, int i, final CharSequence charSequence, final long j, final long j2) {
        final TLRPC$User userSync = accountInstance.getMessagesStorage().getUserSync(i);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearReplyReceiver$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReceive$0(accountInstance, userSync, charSequence, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$0(AccountInstance accountInstance, TLRPC$User tLRPC$User, CharSequence charSequence, long j, long j2) {
        accountInstance.getMessagesController().putUser(tLRPC$User, true);
        sendMessage(accountInstance, charSequence, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$3(final AccountInstance accountInstance, int i, final CharSequence charSequence, final long j, final long j2) {
        final TLRPC$Chat chatSync = accountInstance.getMessagesStorage().getChatSync(-i);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearReplyReceiver$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReceive$2(accountInstance, chatSync, charSequence, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$2(AccountInstance accountInstance, TLRPC$Chat tLRPC$Chat, CharSequence charSequence, long j, long j2) {
        accountInstance.getMessagesController().putChat(tLRPC$Chat, true);
        sendMessage(accountInstance, charSequence, j, j2);
    }

    private void sendMessage(AccountInstance accountInstance, CharSequence charSequence, long j, long j2) {
        accountInstance.getSendMessagesHelper().sendMessage(charSequence.toString(), j, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        accountInstance.getMessagesController().markDialogAsRead(j, j2, j2, 0, false, 0L, 0, true, 0);
    }
}
