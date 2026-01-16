package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.ib, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2611ib extends InterruptionSafeThread {
    public final /* synthetic */ C2634jb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2611ib(C2634jb c2634jb, String str) {
        super(str);
        this.a = c2634jb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap map;
        synchronized (this.a.a) {
            C2634jb.a(this.a);
            this.a.e = true;
            this.a.a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                map = new HashMap(this.a.b);
                this.a.b.clear();
            }
            if (map.size() > 0) {
                C2634jb.a(this.a, map);
                map.clear();
            }
        }
    }
}
