package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.o5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2748o5 implements Runnable {
    public final /* synthetic */ InterfaceC2851sd a;
    public final /* synthetic */ C2772p5 b;

    public RunnableC2748o5(C2772p5 c2772p5, InterfaceC2851sd interfaceC2851sd) {
        this.b = c2772p5;
        this.a = interfaceC2851sd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            try {
                C2772p5 c2772p5 = this.b;
                Object obj = c2772p5.a;
                if (obj == null) {
                    c2772p5.b.add(this.a);
                } else {
                    this.a.consume(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
