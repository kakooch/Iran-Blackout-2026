package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class eb extends ay {
    private final int b;
    private final int c;
    private final int[] d;
    private final int[] e;
    private final es[] f;
    private final Object[] g;
    private final HashMap<Object, Integer> h;

    public eb(Collection collection, ve veVar) {
        super(veVar);
        int size = collection.size();
        this.d = new int[size];
        this.e = new int[size];
        this.f = new es[size];
        this.g = new Object[size];
        this.h = new HashMap<>();
        Iterator it = collection.iterator();
        int iS = 0;
        int iT = 0;
        int i = 0;
        while (it.hasNext()) {
            dm dmVar = (dm) it.next();
            this.f[i] = dmVar.b();
            this.e[i] = iS;
            this.d[i] = iT;
            iS += this.f[i].s();
            iT += this.f[i].t();
            this.g[i] = dmVar.a();
            this.h.put(this.g[i], Integer.valueOf(i));
            i++;
        }
        this.b = iS;
        this.c = iT;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final int k(int i) {
        return aeu.am(this.d, i + 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final int l(int i) {
        return aeu.am(this.e, i + 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final int m(Object obj) {
        Integer num = this.h.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final es n(int i) {
        return this.f[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final int o(int i) {
        return this.d[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final int p(int i) {
        return this.e[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ay
    protected final Object q(int i) {
        return this.g[i];
    }

    final List<es> r() {
        return Arrays.asList(this.f);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int s() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int t() {
        return this.c;
    }
}
