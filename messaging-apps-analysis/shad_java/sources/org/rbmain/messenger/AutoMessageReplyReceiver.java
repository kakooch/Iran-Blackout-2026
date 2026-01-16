package org.rbmain.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class AutoMessageReplyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CharSequence charSequence;
        ApplicationLoader.postInitApplication();
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent == null || (charSequence = resultsFromIntent.getCharSequence(NotificationsController.EXTRA_VOICE_REPLY)) == null || charSequence.length() == 0) {
            return;
        }
        long longExtra = intent.getLongExtra("dialog_id", 0L);
        long longExtra2 = intent.getLongExtra("max_id", 0L);
        int intExtra = intent.getIntExtra("currentAccount", 0);
        if (longExtra == 0 || longExtra2 == 0 || !UserConfig.isValidAccount(intExtra)) {
            return;
        }
        SendMessagesHelper.getInstance(intExtra).sendMessage(charSequence.toString(), longExtra, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        MessagesController.getInstance(intExtra).markDialogAsRead(longExtra, longExtra2, longExtra2, 0, false, 0L, 0, true, 0);
    }
}
