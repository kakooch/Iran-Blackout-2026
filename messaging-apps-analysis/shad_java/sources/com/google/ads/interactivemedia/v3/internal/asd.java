package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asd<E> extends arn<E> {
    static final arn<Object> a = new asd(new Object[0], 0);
    final transient Object[] b;
    private final transient int c;

    asd(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final Object[] b() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int c() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int d() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arn, com.google.ads.interactivemedia.v3.internal.arj
    final int g(Object[] objArr) {
        System.arraycopy(this.b, 0, objArr, 0, this.c);
        return this.c;
    }

    @Override // java.util.List
    public final E get(int i) {
        aqd.i(i, this.c);
        return (E) this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
