package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.appmetrica.analytics.impl.nc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2731nc implements InterfaceC2990y8, L8 {
    public final I6 a;
    public final C2544fg b;
    public final AtomicLong c;

    public C2731nc(I6 i6, C2544fg c2544fg) {
        this.a = i6;
        this.b = c2544fg;
        this.c = new AtomicLong(i6.a());
        i6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void a(List<Integer> list) {
        this.c.addAndGet(list.size());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2990y8
    public final boolean b() {
        return this.c.get() >= ((long) ((Cg) this.b.a()).j);
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void a() {
        this.c.set(this.a.a());
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final void b(List<Integer> list) {
        this.c.addAndGet(-list.size());
    }
}
