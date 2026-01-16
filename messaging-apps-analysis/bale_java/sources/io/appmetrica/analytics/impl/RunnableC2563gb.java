package io.appmetrica.analytics.impl;

import android.os.Handler;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.lang.ref.WeakReference;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.gb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2563gb implements Runnable {
    public final WeakReference a;
    public final WeakReference b;

    public RunnableC2563gb(Handler handler, Q2 q2) {
        this.a = new WeakReference(handler);
        this.b = new WeakReference(q2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = (Handler) this.a.get();
        Q2 q2 = (Q2) this.b.get();
        if (handler == null || q2 == null) {
            return;
        }
        boolean z = !q2.b.f();
        if (z) {
            PublicLogger publicLogger = q2.c;
            Set set = AbstractC2776p9.a;
            Ta ta = Ta.EVENT_TYPE_UNDEFINED;
            C2433b4 c2433b4 = new C2433b4("", "", 3, 0, publicLogger);
            Lh lh = q2.h;
            Wg wg = q2.b;
            lh.getClass();
            lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        }
        if (z) {
            C2539fb.a(handler, q2, this);
        }
    }
}
