package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.m0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2695m0 implements Runnable {
    public final /* synthetic */ C2719n0 a;

    public RunnableC2695m0(C2719n0 c2719n0) {
        this.a = c2719n0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a.a;
        C2523ej c2523ej = Ei.a;
        synchronized (c2523ej) {
            try {
                c2523ej.b = Dh.a.a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
                Iterator it = c2523ej.a.iterator();
                while (it.hasNext()) {
                    ((Ka) it.next()).a(c2523ej.b);
                }
                c2523ej.a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
