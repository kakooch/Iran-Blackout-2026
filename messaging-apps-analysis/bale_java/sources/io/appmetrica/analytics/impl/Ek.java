package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Ek {
    public final /* synthetic */ Gk a;

    public Ek(Gk gk) {
        this.a = gk;
    }

    public final void a(String str, Ik ik, C2549fl c2549fl) {
        ArrayList arrayList;
        synchronized (this.a.b) {
            try {
                Collection collection = (Collection) this.a.a.a.get(str);
                arrayList = collection == null ? new ArrayList() : new ArrayList(collection);
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Pk) it.next()).a(ik, c2549fl);
        }
    }
}
