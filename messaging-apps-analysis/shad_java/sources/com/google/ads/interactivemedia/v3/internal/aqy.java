package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqy extends aqg {
    final Object a;
    int b;
    final /* synthetic */ arh c;

    aqy(arh arhVar, int i) {
        this.c = arhVar;
        this.a = arhVar.a[i];
        this.b = i;
    }

    final void a() {
        int i = this.b;
        if (i != -1) {
            arh arhVar = this.c;
            if (i <= arhVar.c && apz.b(arhVar.a[i], this.a)) {
                return;
            }
        }
        this.b = this.c.b(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object getValue() {
        a();
        int i = this.b;
        if (i == -1) {
            return null;
        }
        return this.c.b[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        int i = this.b;
        if (i == -1) {
            return this.c.put(this.a, obj);
        }
        Object obj2 = this.c.b[i];
        if (apz.b(obj2, obj)) {
            return obj;
        }
        this.c.C(this.b, obj);
        return obj2;
    }
}
