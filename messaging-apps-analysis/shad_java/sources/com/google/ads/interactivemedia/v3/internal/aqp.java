package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqp extends aqg {
    final /* synthetic */ aqr a;
    private final Object b;
    private int c;

    aqp(aqr aqrVar, int i) {
        this.a = aqrVar;
        this.b = aqrVar.b[i];
        this.c = i;
    }

    private final void a() {
        int i = this.c;
        if (i == -1 || i >= this.a.size() || !apz.b(this.b, this.a.b[this.c])) {
            this.c = this.a.t(this.b);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object getKey() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object getValue() {
        Map mapD = this.a.d();
        if (mapD != null) {
            return mapD.get(this.b);
        }
        a();
        int i = this.c;
        if (i == -1) {
            return null;
        }
        return this.a.c[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapD = this.a.d();
        if (mapD != null) {
            return mapD.put(this.b, obj);
        }
        a();
        int i = this.c;
        if (i == -1) {
            this.a.put(this.b, obj);
            return null;
        }
        Object[] objArr = this.a.c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
