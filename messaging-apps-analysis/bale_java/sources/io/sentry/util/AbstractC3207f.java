package io.sentry.util;

import ir.nasim.AbstractC18350oW3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.sentry.util.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3207f {
    public static List a(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                throw null;
            }
        }
        return new CopyOnWriteArrayList(arrayList);
    }
}
