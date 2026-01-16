package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class P implements O {
    P() {
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final Object a(Object obj) {
        return N.d().e();
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final Object d(Object obj, Object obj2) {
        N nE = (N) obj;
        N n = (N) obj2;
        if (!n.isEmpty()) {
            if (!nE.b()) {
                nE = nE.e();
            }
            nE.c(n);
        }
        return nE;
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final int e(int i, Object obj, Object obj2) {
        N n = (N) obj;
        if (n.isEmpty()) {
            return 0;
        }
        Iterator it = n.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final M f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final Object g(Object obj) {
        ((N) obj).l();
        return obj;
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final boolean h(Object obj) {
        return !((N) obj).b();
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final Map i(Object obj) {
        return (N) obj;
    }

    @Override // com.google.android.gms.internal.clearcut.O
    public final Map j(Object obj) {
        return (N) obj;
    }
}
