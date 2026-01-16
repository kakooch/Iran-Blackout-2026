package ir.resaneh1.iptv.helper;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: classes3.dex */
public class CrashHandelHelper {
    public static void handleCrashOnStroy(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey("stroyExportDesc", str2);
        FirebaseCrashlytics.getInstance().recordException(new Exception(str));
    }

    public static void handleCrashOnMyLog(Throwable th) {
        FirebaseCrashlytics.getInstance().setCustomKey("MyLogException", "true");
        FirebaseCrashlytics.getInstance().recordException(th);
    }

    public static void setLastActionRubino(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey("lastRu" + str, str2);
    }
}
