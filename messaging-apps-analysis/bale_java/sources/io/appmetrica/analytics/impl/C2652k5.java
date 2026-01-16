package io.appmetrica.analytics.impl;

import ir.nasim.XV4;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.k5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2652k5 implements xn {
    public final List a;

    public C2652k5(List<? extends XV4> list) {
        this.a = list;
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final String a() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            String strA = ((xn) ((XV4) it.next()).f()).a();
            if (strA != null && strA.length() > 0) {
                return strA;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final void a(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((xn) ((XV4) it.next()).f()).a(str);
        }
    }
}
