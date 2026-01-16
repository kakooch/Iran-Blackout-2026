package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC15401jX0;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.nf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2734nf implements InterfaceC2638jf {
    public final /* synthetic */ C2829rf a;

    public C2734nf(C2829rf c2829rf) {
        this.a = c2829rf;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2638jf
    public final void a() {
        C2829rf c2829rf = this.a;
        ArrayList arrayList = c2829rf.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Cf cf = (Cf) next;
            c2829rf.c.getClass();
            String str = cf != null ? cf.a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c2829rf.a(c2829rf.c.a(AbstractC15401jX0.n0(arrayList2)));
    }
}
