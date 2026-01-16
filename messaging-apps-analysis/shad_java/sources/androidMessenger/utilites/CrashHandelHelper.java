package androidMessenger.utilites;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: classes.dex */
public class CrashHandelHelper {
    public static void handleCrashOnMyLog(Throwable th) {
        FirebaseCrashlytics.getInstance().setCustomKey("MyLogException", "true");
        FirebaseCrashlytics.getInstance().recordException(th);
    }
}
