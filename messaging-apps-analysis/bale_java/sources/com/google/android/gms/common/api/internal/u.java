package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes3.dex */
final class u implements Runnable {
    final /* synthetic */ ConnectionResult a;
    final /* synthetic */ v b;

    u(v vVar, ConnectionResult connectionResult) {
        this.b = vVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar = this.b;
        s sVar = (s) vVar.f.l.get(vVar.b);
        if (sVar == null) {
            return;
        }
        if (!this.a.x0()) {
            sVar.D(this.a, null);
            return;
        }
        this.b.e = true;
        if (this.b.a.i()) {
            this.b.h();
            return;
        }
        try {
            v vVar2 = this.b;
            vVar2.a.l(null, vVar2.a.k());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.b.a.b("Failed to get service from broker.");
            sVar.D(new ConnectionResult(10), null);
        }
    }
}
