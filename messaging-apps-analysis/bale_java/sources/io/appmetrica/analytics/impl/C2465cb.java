package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13610gX0;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.cb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2465cb {
    public final C2554g2 a = new C2554g2();
    public final C2653k6 b = new C2653k6();
    public C2932vm c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, Na na) {
        try {
            if (this.d) {
                return;
            }
            C2653k6 c2653k6 = this.b;
            List list = C2747o4.g().i.a;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC2621im) it.next()).a(context, na));
            }
            c2653k6.a.addAll(arrayList);
            this.d = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            if (this.c != null) {
                return;
            }
            P1 p1 = new P1(this.b);
            this.c = new C2932vm(p1);
            C2908um c2908um = new C2908um();
            c2908um.a.add(p1);
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                c2908um.a.add(defaultUncaughtExceptionHandler);
            }
            Thread.setDefaultUncaughtExceptionHandler(c2908um);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, Na na) {
        if (this.e) {
            return;
        }
        AbstractC13610gX0.E(this.b.a, new InterfaceC3016za[]{this.a.a(context, appMetricaConfig, na)});
        this.e = true;
    }

    public final synchronized void a() {
        this.b.a.clear();
        this.d = false;
        this.e = false;
    }
}
