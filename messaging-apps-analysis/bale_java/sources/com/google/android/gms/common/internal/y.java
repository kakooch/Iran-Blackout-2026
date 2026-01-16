package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C3264Ad1;
import ir.nasim.Vp8;
import ir.nasim.Xs8;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class y extends d {
    private final HashMap f = new HashMap();
    private final Context g;
    private volatile Handler h;
    private final x i;
    private final C3264Ad1 j;
    private final long k;
    private final long l;
    private volatile Executor m;

    y(Context context, Looper looper, Executor executor) {
        x xVar = new x(this, null);
        this.i = xVar;
        this.g = context.getApplicationContext();
        this.h = new Vp8(looper, xVar);
        this.j = C3264Ad1.b();
        this.k = 5000L;
        this.l = 300000L;
        this.m = executor;
    }

    @Override // com.google.android.gms.common.internal.d
    protected final void c(Xs8 xs8, ServiceConnection serviceConnection, String str) {
        AbstractC3795Cj5.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                w wVar = (w) this.f.get(xs8);
                if (wVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + xs8.toString());
                }
                if (!wVar.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + xs8.toString());
                }
                wVar.f(serviceConnection, str);
                if (wVar.i()) {
                    this.h.sendMessageDelayed(this.h.obtainMessage(0, xs8), this.k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.d
    protected final boolean e(Xs8 xs8, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        AbstractC3795Cj5.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f) {
            try {
                w wVar = (w) this.f.get(xs8);
                if (executor == null) {
                    executor = this.m;
                }
                if (wVar == null) {
                    wVar = new w(this, xs8);
                    wVar.d(serviceConnection, serviceConnection, str);
                    wVar.e(str, executor);
                    this.f.put(xs8, wVar);
                } else {
                    this.h.removeMessages(0, xs8);
                    if (wVar.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + xs8.toString());
                    }
                    wVar.d(serviceConnection, serviceConnection, str);
                    int iA = wVar.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(wVar.b(), wVar.c());
                    } else if (iA == 2) {
                        wVar.e(str, executor);
                    }
                }
                zJ = wVar.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
