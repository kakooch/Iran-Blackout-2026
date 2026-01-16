package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13610gX0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.appmetrica.analytics.impl.k6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2653k6 implements InterfaceC3016za {
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC3016za
    public final void a(Throwable th, T t) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC3016za) it.next()).a(th, t);
        }
    }

    public final void a(InterfaceC3016za... interfaceC3016zaArr) {
        AbstractC13610gX0.E(this.a, interfaceC3016zaArr);
    }

    public final void a(List<? extends InterfaceC3016za> list) {
        this.a.addAll(list);
    }

    public final void a() {
        this.a.clear();
    }
}
