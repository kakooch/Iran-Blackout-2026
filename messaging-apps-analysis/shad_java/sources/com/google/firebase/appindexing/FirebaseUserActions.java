package com.google.firebase.appindexing;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appindexing.internal.zzr;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public abstract class FirebaseUserActions {
    private static WeakReference<FirebaseUserActions> zza;

    @RecentlyNonNull
    public abstract Task<Void> end(@RecentlyNonNull Action action);

    private static FirebaseUserActions zza() {
        WeakReference<FirebaseUserActions> weakReference = zza;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private static FirebaseUserActions zza(Context context) {
        zzr zzrVar = new zzr(context);
        zza = new WeakReference<>(zzrVar);
        return zzrVar;
    }

    @RecentlyNonNull
    @Deprecated
    public static synchronized FirebaseUserActions getInstance() {
        FirebaseUserActions firebaseUserActionsZza;
        firebaseUserActionsZza = zza();
        if (firebaseUserActionsZza == null) {
            firebaseUserActionsZza = zza(FirebaseApp.getInstance().getApplicationContext());
        }
        return firebaseUserActionsZza;
    }
}
