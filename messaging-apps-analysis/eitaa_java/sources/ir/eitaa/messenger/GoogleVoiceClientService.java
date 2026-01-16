package ir.eitaa.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import ir.eitaa.tgnet.TLRPC$User;

/* loaded from: classes.dex */
public class GoogleVoiceClientService extends SearchActionVerificationClientService {
    @Override // com.google.android.search.verification.client.SearchActionVerificationClientService
    public void performAction(final Intent intent, boolean isVerified, Bundle options) {
        if (isVerified) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$GoogleVoiceClientService$bP9r5w_xC7rII7OajS4aiDCCL-4
                @Override // java.lang.Runnable
                public final void run() throws NumberFormatException {
                    GoogleVoiceClientService.lambda$performAction$0(intent);
                }
            });
        }
    }

    static /* synthetic */ void lambda$performAction$0(Intent intent) throws NumberFormatException {
        try {
            int i = UserConfig.selectedAccount;
            ApplicationLoader.postInitApplication();
            if (!AndroidUtilities.needShowPasscode() && !SharedConfig.isWaitingForPasscodeEnter) {
                String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                String stringExtra2 = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI");
                long j = Long.parseLong(intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID"));
                TLRPC$User user = MessagesController.getInstance(i).getUser(Long.valueOf(j));
                if (user == null && (user = MessagesStorage.getInstance(i).getUserSync(j)) != null) {
                    MessagesController.getInstance(i).putUser(user, true);
                }
                if (user != null) {
                    ContactsController.getInstance(i).markAsContacted(stringExtra2);
                    SendMessagesHelper.getInstance(i).sendMessage(stringExtra, user.id, null, null, null, true, null, null, null, true, 0, null);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }
}
