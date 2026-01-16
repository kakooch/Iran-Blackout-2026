package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC10976cX0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Pm {
    public static final Mm a(Throwable th, T t, List list, String str, Boolean bool) {
        ArrayList arrayList = null;
        Cm cmA = th != null ? Dm.a(th, 1, 0) : null;
        if (list != null) {
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Ck((StackTraceElement) it.next()));
            }
        }
        return new Mm(cmA, t, arrayList, null, null, null, str, bool);
    }
}
