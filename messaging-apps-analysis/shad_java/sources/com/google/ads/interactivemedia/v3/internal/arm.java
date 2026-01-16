package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arm extends arn {
    final transient int a;
    final transient int b;
    final /* synthetic */ arn c;

    arm(arn arnVar, int i, int i2) {
        this.c = arnVar;
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final Object[] b() {
        return this.c.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int c() {
        return this.c.c() + this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int d() {
        return this.c.c() + this.a + this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        aqd.i(i, this.b);
        return this.c.get(i + this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arn
    /* renamed from: h */
    public final arn subList(int i, int i2) {
        aqd.h(i, i2, this.b);
        arn arnVar = this.c;
        int i3 = this.a;
        return arnVar.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arn, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
