package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asg<K> extends arx<K> {
    private final transient ars<K, ?> a;
    private final transient arn<K> b;

    asg(ars<K, ?> arsVar, arn<K> arnVar) {
        this.a = arsVar;
        this.b = arnVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public final asp<K> listIterator() {
        return this.b.iterator();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.get(obj) != null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, com.google.ads.interactivemedia.v3.internal.arj
    public final arn<K> e() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int g(Object[] objArr) {
        return this.b.g(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
