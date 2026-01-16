package org.rbmain.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidMessenger.utilites.ChatConverter;
import ir.aaap.messengercore.model.ChatType;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class OpenChatReceiver extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String stringExtra;
        int longExtra;
        int longExtra2;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getAction() == null || !intent.getAction().startsWith("com.tmessages.openchat")) {
            finish();
            return;
        }
        try {
            if (intent.getAction().startsWith("com.tmessages.openchat") && !intent.hasExtra("link")) {
                if (intent.hasExtra("chatId")) {
                    longExtra = (int) intent.getLongExtra("chatId", 0L);
                    longExtra2 = (int) intent.getLongExtra("userId", 0L);
                    if (longExtra == 0 && longExtra2 == 0) {
                        longExtra = intent.getIntExtra("chatId", 0);
                        longExtra2 = intent.getIntExtra("userId", 0);
                    }
                } else {
                    int intExtra = intent.getIntExtra("encId", 0);
                    String stringExtra2 = intent.getStringExtra("object_guid");
                    ChatType chatTypeValueOf = ChatType.valueOf(intent.getStringExtra("object_type"));
                    long dialogId = ChatConverter.getDialogId(stringExtra2, chatTypeValueOf);
                    int i = (chatTypeValueOf == ChatType.Group || chatTypeValueOf == ChatType.Channel) ? (int) ((-1) * dialogId) : 0;
                    i = (chatTypeValueOf == ChatType.User || chatTypeValueOf == ChatType.Bot || chatTypeValueOf == ChatType.Service) ? (int) dialogId : 0;
                    longExtra = i;
                    longExtra2 = i;
                    i = intExtra;
                }
                if (longExtra == 0 && longExtra2 == 0 && i == 0) {
                    return;
                }
            } else if (intent.hasExtra("link") && ((stringExtra = intent.getStringExtra("link")) == null || stringExtra.isEmpty())) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) LaunchActivity.class);
            intent2.setAction(intent.getAction());
            intent2.putExtras(intent);
            startActivity(intent2);
            finish();
        } catch (Throwable unused) {
        }
    }
}
