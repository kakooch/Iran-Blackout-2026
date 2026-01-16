package ir.eitaa.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SmsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            String string = sharedPreferences.getString("sms_hash", null);
            if (TextUtils.isEmpty("")) {
                return;
            }
            Matcher matcher = Pattern.compile("[0-9\\-]+").matcher("");
            if (matcher.find()) {
                final String strReplace = matcher.group(0).replace("-", "");
                if (strReplace.length() >= 3) {
                    if (string != null) {
                        sharedPreferences.edit().putString("sms_hash_code", string + "|" + strReplace).commit();
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SmsReceiver$-YQUem4AEQ23Wminqfcl_g4L4Gg
                        @Override // java.lang.Runnable
                        public final void run() {
                            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didReceiveSmsCode, strReplace);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }
}
