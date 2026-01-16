package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.appmetrica.analytics.impl.l9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2680l9 {
    public final List a;
    public final InterfaceC2752o9 b;
    public final AtomicBoolean c = new AtomicBoolean(true);

    public C2680l9(ArrayList arrayList, InterfaceC2752o9 interfaceC2752o9) {
        this.a = arrayList;
        this.b = interfaceC2752o9;
    }

    public final void a() {
        C2484d5 c2484d5 = (C2484d5) this.b;
        synchronized (c2484d5) {
            c2484d5.e.b();
        }
    }

    public final void b() {
        if (this.c.get()) {
            if (this.a.isEmpty()) {
                C2484d5 c2484d5 = (C2484d5) this.b;
                synchronized (c2484d5) {
                    c2484d5.e.b();
                }
                return;
            }
            Iterator it = this.a.iterator();
            boolean zB = false;
            while (it.hasNext()) {
                zB |= ((InterfaceC2990y8) it.next()).b();
            }
            if (zB) {
                a();
            }
        }
    }
}
