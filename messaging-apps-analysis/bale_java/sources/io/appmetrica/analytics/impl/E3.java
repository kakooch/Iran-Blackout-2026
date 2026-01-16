package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC15401jX0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class E3 implements Xm {
    @Override // io.appmetrica.analytics.impl.Xm, ir.nasim.InterfaceC14603iB2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<I3> invoke(List<I3> list, I3 i3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                M7 m7 = ((I3) it.next()).b;
                M7 m72 = i3.b;
                if (m7 == m72) {
                    if (m72 != M7.c) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((I3) obj).b != M7.c) {
                            arrayList.add(obj);
                        }
                    }
                    return AbstractC15401jX0.S0(arrayList, i3);
                }
            }
        }
        return AbstractC15401jX0.S0(list, i3);
    }
}
