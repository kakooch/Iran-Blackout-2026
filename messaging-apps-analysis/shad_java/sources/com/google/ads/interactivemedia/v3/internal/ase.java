package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ase extends arn<Map.Entry> {
    final /* synthetic */ asf a;

    ase(asf asfVar) {
        this.a = asfVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        aqd.i(i, this.a.d);
        Object[] objArr = this.a.b;
        int i2 = i + i;
        asf.p(this.a);
        Object obj = objArr[i2];
        Object[] objArr2 = this.a.b;
        asf.p(this.a);
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.d;
    }
}
