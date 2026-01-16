package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.appmetrica.analytics.impl.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2478d extends Thread {
    public final AtomicBoolean a = new AtomicBoolean(true);
    public final /* synthetic */ C2503e b;

    public C2478d(C2503e c2503e) {
        this.b = c2503e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        while (!isInterrupted() && this.a.get()) {
            this.b.e.set(false);
            C2503e c2503e = this.b;
            c2503e.c.postAtFrontOfQueue(c2503e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C2503e.g);
                    if (this.b.e.get()) {
                        break;
                    } else {
                        i--;
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC2453c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                try {
                    Thread.sleep(C2503e.g);
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }
}
