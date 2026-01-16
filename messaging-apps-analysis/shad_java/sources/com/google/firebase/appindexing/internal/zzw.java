package com.google.firebase.appindexing.internal;

import android.util.Log;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public final class zzw {
    public static int zza(String str) {
        if (zza(3)) {
            return Log.d("FirebaseAppIndex", str);
        }
        return 0;
    }

    public static boolean zza(int i) {
        if (Log.isLoggable("FirebaseAppIndex", i)) {
            return true;
        }
        return Log.isLoggable("FirebaseAppIndex", i);
    }
}
