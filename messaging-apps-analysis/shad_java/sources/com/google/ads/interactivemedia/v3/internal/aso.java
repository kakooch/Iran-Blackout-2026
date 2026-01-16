package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aso<E> extends arx<E> {
    final transient E a;
    private transient int b;

    aso(E e) {
        aqd.j(e);
        this.a = e;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public final asp<E> listIterator() {
        return new arz(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int g(Object[] objArr) {
        objArr[0] = this.a;
        return 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.a.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx
    final boolean l() {
        return this.b != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx
    final arn<E> m() {
        return arn.j(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.a.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }

    aso(E e, int i) {
        this.a = e;
        this.b = i;
    }
}
