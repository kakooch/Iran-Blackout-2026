package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class tq extends tl {
    public static final Object c = new Object();
    private final Object d;
    private final Object e;

    private tq(es esVar, Object obj, Object obj2) {
        super(esVar);
        this.d = obj;
        this.e = obj2;
    }

    public static tq a(dg dgVar) {
        return new tq(new tr(dgVar), er.a, c);
    }

    public static tq b(es esVar, Object obj, Object obj2) {
        return new tq(esVar, obj, obj2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tl, com.google.ads.interactivemedia.v3.internal.es
    public final er f(int i, er erVar, long j) {
        this.b.f(i, erVar, j);
        if (aeu.c(erVar.b, this.d)) {
            erVar.b = er.a;
        }
        return erVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tl, com.google.ads.interactivemedia.v3.internal.es
    public final eq h(int i, eq eqVar, boolean z) {
        this.b.h(i, eqVar, z);
        if (aeu.c(eqVar.b, this.e) && z) {
            eqVar.b = c;
        }
        return eqVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tl, com.google.ads.interactivemedia.v3.internal.es
    public final int i(Object obj) {
        Object obj2;
        es esVar = this.b;
        if (c.equals(obj) && (obj2 = this.e) != null) {
            obj = obj2;
        }
        return esVar.i(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tl, com.google.ads.interactivemedia.v3.internal.es
    public final Object j(int i) {
        Object objJ = this.b.j(i);
        return aeu.c(objJ, this.e) ? c : objJ;
    }

    public final tq k(es esVar) {
        return new tq(esVar, this.d, this.e);
    }
}
