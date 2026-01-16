package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* renamed from: io.appmetrica.analytics.impl.r5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2819r5 implements InterfaceC2856si {
    public BaseRequestConfig a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public M5 c;

    public AbstractC2819r5(BaseRequestConfig.RequestConfigLoader<Object, M5> requestConfigLoader, C2549fl c2549fl, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C2586ha.h().s().a(this);
        a(new M5(c2549fl, C2586ha.h().s(), C2586ha.h().p(), argumentsMerger));
    }

    public final synchronized void a(M5 m5) {
        this.c = m5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized C2549fl c() {
        return this.c.a;
    }

    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }

    public final synchronized void e() {
        this.a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new M5(c(), C2586ha.C.s(), C2586ha.C.p(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(C2549fl c2549fl) {
        a(new M5(c2549fl, C2586ha.C.s(), C2586ha.C.p(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        try {
            if (this.a == null) {
                this.a = this.b.load(this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a;
    }
}
