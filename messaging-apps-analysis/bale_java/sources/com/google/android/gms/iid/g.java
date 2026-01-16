package com.google.android.gms.iid;

import android.util.Log;

/* loaded from: classes3.dex */
final class g implements Runnable {
    private final /* synthetic */ d a;
    private final /* synthetic */ f b;

    g(f fVar, d dVar) {
        this.b = fVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.b.a.handleIntent(this.a.a);
        this.a.a();
    }
}
