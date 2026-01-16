package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes3.dex */
public final class f extends Binder {
    private final zze a;

    f(zze zzeVar) {
        this.a = zzeVar;
    }

    public final void b(d dVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.a.a.execute(new g(this, dVar));
    }
}
