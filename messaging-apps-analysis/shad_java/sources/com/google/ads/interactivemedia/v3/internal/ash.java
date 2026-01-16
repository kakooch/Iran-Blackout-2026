package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ash extends arn<Object> {
    private final transient Object[] a;
    private final transient int b;
    private final transient int c;

    ash(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        aqd.i(i, this.c);
        return this.a[i + i + this.b];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
