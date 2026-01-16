package androidMessenger.utilites;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Log;
import ir.aaap.messengercore.network.ApiServerException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class MyLog {
    public static boolean isDebugAble = false;
    public static boolean throwApiExeption = false;

    public static void e(String str, String str2) {
        if (isDebugAble) {
            if (str2.length() < 2000) {
                Log.e("AAA " + str, str2);
                return;
            }
            int i = 0;
            while (i <= str2.length() / 2000) {
                int i2 = i * 2000;
                i++;
                int length = i * 2000;
                if (length > str2.length()) {
                    length = str2.length();
                }
                Log.e("AAA " + str, str2.substring(i2, length));
            }
        }
    }

    public static void handleException(Throwable th) {
        if (isDebugAble) {
            if ((!throwApiExeption && (th instanceof ApiServerException)) || (th instanceof UnknownHostException) || (th.getCause() instanceof UnknownHostException) || (th.getCause() instanceof SocketTimeoutException)) {
                return;
            }
            th.printStackTrace();
            for (int i = 0; i < 100; i++) {
                e("DEBUGERRORRRRR", i + "DEBUGERRORRRRR#########################################");
            }
            CrashHandelHelper.handleCrashOnMyLog(th);
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("exception", th.getMessage()));
        }
    }

    public static void handleExceptionThrowOnDebug(Throwable th) {
        if (isDebugAble) {
            handleException(th);
            th.printStackTrace();
        }
    }
}
