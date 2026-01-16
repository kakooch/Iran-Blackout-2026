package io.appmetrica.analytics.impl;

import java.util.LinkedList;

/* renamed from: io.appmetrica.analytics.impl.g9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2561g9 extends Pe {
    public final Eg a;
    public final Gg b;
    public final C2854sg c;

    public C2561g9(C2484d5 c2484d5) {
        this.a = new Eg(c2484d5);
        this.b = new Gg(c2484d5);
        this.c = new C2854sg(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.Pe
    public final R8 a(int i) {
        LinkedList linkedList = new LinkedList();
        int iOrdinal = Ta.a(i).ordinal();
        if (iOrdinal == 1) {
            linkedList.add(this.a);
        } else if (iOrdinal == 3) {
            linkedList.add(this.c);
        } else if (iOrdinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.a);
        }
        return new Q8(linkedList);
    }
}
