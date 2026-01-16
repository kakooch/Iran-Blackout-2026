package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

/* loaded from: classes3.dex */
final class e implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ d b;

    e(d dVar, Intent intent) {
        this.b = dVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("EnhancedIntentService", sb.toString());
        this.b.a();
    }
}
