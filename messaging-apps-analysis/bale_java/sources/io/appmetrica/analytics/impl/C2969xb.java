package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.xb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2969xb {
    public final W2 a;
    public final C2578h2 b;
    public final ArrayList c;

    public C2969xb(W2 w2, C2578h2 c2578h2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = w2;
        arrayList.add(w2);
        this.b = c2578h2;
        arrayList.add(c2578h2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((InterfaceC2905uj) it.next()).onCreate();
        }
    }

    public final synchronized void a(C2562ga c2562ga) {
        this.c.add(c2562ga);
    }
}
