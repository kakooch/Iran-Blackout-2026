package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: classes3.dex */
public class FirebaseEventSender {
    public static void sendEvent(Context context, String str, String str2) {
    }

    public static void sendEventNew(Context context, String str, String str2) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Bundle bundle = new Bundle();
        bundle.putString("item_name", str);
        bundle.putString("item_id", str2);
        firebaseAnalytics.logEvent("view_item", bundle);
    }

    public static void setKey(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
    }

    public static void recordException(Exception exc) {
        if (exc != null) {
            setKey("Exception Message", exc.getMessage() != null ? exc.getMessage() : "null");
            FirebaseCrashlytics.getInstance().recordException(exc);
        }
    }
}
