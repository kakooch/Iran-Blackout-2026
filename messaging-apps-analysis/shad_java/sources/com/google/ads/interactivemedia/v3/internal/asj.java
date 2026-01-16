package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asj<E> extends arx<E> {
    static final asj<Object> a = new asj<>(new Object[0], 0, null, 0, 0);
    final transient Object[] b;
    final transient Object[] c;
    private final transient int d;
    private final transient int e;
    private final transient int f;

    asj(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.b = objArr;
        this.c = objArr2;
        this.d = i2;
        this.e = i;
        this.f = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public final asp<E> listIterator() {
        return e().iterator();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final Object[] b() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int c() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr == null) {
            return false;
        }
        int iC = ary.c(obj);
        while (true) {
            int i = iC & this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int d() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int g(Object[] objArr) {
        System.arraycopy(this.b, 0, objArr, 0, this.f);
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx
    final boolean l() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx
    final arn<E> m() {
        return arn.o(this.b, this.f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f;
    }
}
