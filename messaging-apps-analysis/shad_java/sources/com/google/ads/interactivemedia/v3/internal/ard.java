package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ard extends arg {
    final /* synthetic */ arh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ard(arh arhVar) {
        super(arhVar);
        this.a = arhVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arg
    final Object a(int i) {
        return this.a.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iC = ary.c(obj);
        int iC2 = this.a.c(obj, iC);
        if (iC2 == -1) {
            return false;
        }
        this.a.g(iC2, iC);
        return true;
    }
}
