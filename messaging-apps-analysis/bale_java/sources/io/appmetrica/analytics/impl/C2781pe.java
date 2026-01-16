package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC15401jX0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.pe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2781pe implements Xm {
    public final boolean a;

    public C2781pe(C2828re c2828re) {
        boolean z;
        List<C2805qe> list = c2828re.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((C2805qe) it.next()).c == M7.c) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        this.a = z;
    }

    @Override // io.appmetrica.analytics.impl.Xm, ir.nasim.InterfaceC14603iB2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C2805qe> invoke(List<? extends C2805qe> list, Ee ee) {
        C2805qe c2805qe = new C2805qe(ee.a, ee.b, ee.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((C2805qe) it.next()).c == ee.e) {
                    if (c2805qe.c == M7.c && this.a) {
                        return AbstractC15401jX0.S0(list, c2805qe);
                    }
                    return null;
                }
            }
        }
        return AbstractC15401jX0.S0(list, c2805qe);
    }
}
