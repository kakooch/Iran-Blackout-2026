package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC15401jX0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.zc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3018zc {
    public final LinkedHashSet a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        try {
            LinkedHashSet linkedHashSet = this.a;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(linkedHashSet, 10));
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InterfaceC2994yc) it.next()).a());
            }
            arrayList = new ArrayList();
            for (Object obj : arrayList2) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return AbstractC15401jX0.r1(arrayList);
    }
}
