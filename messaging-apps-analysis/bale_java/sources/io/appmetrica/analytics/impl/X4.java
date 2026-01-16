package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class X4 {
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public final void a(InterfaceC2795q4 interfaceC2795q4) {
        this.a.add(interfaceC2795q4);
    }

    public final void b(InterfaceC2795q4 interfaceC2795q4) {
        this.a.remove(interfaceC2795q4);
    }

    public final List<InterfaceC2795q4> a() {
        return this.a;
    }
}
