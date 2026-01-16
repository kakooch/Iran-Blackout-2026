package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class agf {
    private ahr a = ahr.a;
    private final int i = agr.a;
    private final afx b = afw.IDENTITY;
    private final Map<Type, agg<?>> c = new HashMap();
    private final List<agu> d = new ArrayList();
    private final List<agu> e = new ArrayList();
    private final int f = 2;
    private final int g = 2;
    private final boolean h = true;

    public final age a() {
        ArrayList arrayList = new ArrayList(this.d.size() + this.e.size() + 3);
        arrayList.addAll(this.d);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.e);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        return new age(this.a, this.b, this.c, true, this.i, arrayList);
    }

    public final void b(Type type, Object obj) {
        boolean z = obj instanceof agp;
        boolean z2 = true;
        if (!z && !(obj instanceof agi) && !(obj instanceof agg) && !(obj instanceof agt)) {
            z2 = false;
        }
        com.google.ads.interactivemedia.v3.impl.data.ax.e(z2);
        if (obj instanceof agg) {
            this.c.put(type, (agg) obj);
        }
        if (z || (obj instanceof agi)) {
            this.d.add(aji.a(akz.c(type), obj));
        }
        if (obj instanceof agt) {
            this.d.add(aku.a(akz.c(type), (agt) obj));
        }
    }

    public final void c(agu aguVar) {
        this.d.add(aguVar);
    }

    public final void d(apz apzVar) {
        this.a = this.a.e(apzVar);
    }
}
