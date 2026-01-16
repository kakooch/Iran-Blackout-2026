package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC4597Fu6;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class A5 implements InterfaceC2990y8, L8 {
    public final I6 a;
    public final Set b;
    public final AtomicLong c;

    public A5(I6 i6) {
        this.a = i6;
        Set setI = AbstractC4597Fu6.i(Integer.valueOf(Ta.EVENT_CLIENT_EXTERNAL_ATTRIBUTION.a()), Integer.valueOf(Ta.EVENT_TYPE_APP_UPDATE.a()), Integer.valueOf(Ta.EVENT_TYPE_FIRST_ACTIVATION.a()), Integer.valueOf(Ta.EVENT_TYPE_INIT.a()), Integer.valueOf(Ta.EVENT_TYPE_SEND_AD_REVENUE_EVENT.a()), Integer.valueOf(Ta.EVENT_TYPE_SEND_ECOMMERCE_EVENT.a()), Integer.valueOf(Ta.EVENT_TYPE_SEND_REFERRER.a()), Integer.valueOf(Ta.EVENT_TYPE_SEND_REVENUE_EVENT.a()));
        this.b = setI;
        this.c = new AtomicLong(i6.a(setI));
        i6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void a() {
        this.c.set(this.a.a(this.b));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2990y8
    public final boolean b() {
        return this.c.get() > 0;
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void b(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (this.b.contains(Integer.valueOf(((Number) it.next()).intValue())) && (i = i + 1) < 0) {
                    AbstractC10360bX0.v();
                }
            }
        }
        this.c.addAndGet(-i);
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void a(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (this.b.contains(Integer.valueOf(((Number) it.next()).intValue())) && (i = i + 1) < 0) {
                    AbstractC10360bX0.v();
                }
            }
        }
        this.c.addAndGet(i);
    }
}
