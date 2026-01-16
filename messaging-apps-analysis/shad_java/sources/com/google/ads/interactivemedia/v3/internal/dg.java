package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class dg {
    public final String a;
    public final df b;
    public final de c;
    public final dh d;
    public final dc e;

    /* synthetic */ dg(String str, dc dcVar, df dfVar, de deVar, dh dhVar) {
        this.a = str;
        this.b = dfVar;
        this.c = deVar;
        this.d = dhVar;
        this.e = dcVar;
    }

    public final db a() {
        return new db(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dg)) {
            return false;
        }
        dg dgVar = (dg) obj;
        return aeu.c(this.a, dgVar.a) && this.e.equals(dgVar.e) && aeu.c(this.b, dgVar.b) && aeu.c(this.c, dgVar.c) && aeu.c(this.d, dgVar.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        df dfVar = this.b;
        return (((((iHashCode + (dfVar != null ? dfVar.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.e.hashCode()) * 31;
    }
}
