package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abg {
    public final int a;
    public final ef[] b;
    public final abb c;
    public final Object d;

    public abg(ef[] efVarArr, aba[] abaVarArr, Object obj) {
        this.b = efVarArr;
        this.c = new abb(abaVarArr);
        this.d = obj;
        this.a = efVarArr.length;
    }

    public final boolean a(int i) {
        return this.b[i] != null;
    }

    public final boolean b(abg abgVar, int i) {
        return abgVar != null && aeu.c(this.b[i], abgVar.b[i]) && aeu.c(this.c.a(i), abgVar.c.a(i));
    }
}
