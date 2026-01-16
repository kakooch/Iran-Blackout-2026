package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqz<K, V> extends aqg<V, K> {
    final arh<K, V> a;
    final V b;
    int c;

    aqz(arh<K, V> arhVar, int i) {
        this.a = arhVar;
        this.b = arhVar.b[i];
        this.c = i;
    }

    private final void a() {
        int i = this.c;
        if (i != -1) {
            arh<K, V> arhVar = this.a;
            if (i <= arhVar.c && apz.b(this.b, arhVar.b[i])) {
                return;
            }
        }
        this.c = this.a.d(this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final V getKey() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final K getValue() {
        a();
        int i = this.c;
        if (i == -1) {
            return null;
        }
        return this.a.a[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqg, java.util.Map.Entry
    public final K setValue(K k) {
        a();
        int i = this.c;
        if (i == -1) {
            return this.a.q(this.b, k);
        }
        K k2 = this.a.a[i];
        if (apz.b(k2, k)) {
            return k;
        }
        this.a.B(this.c, k);
        return k2;
    }
}
