package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class are extends arg {
    final /* synthetic */ arh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    are(arh arhVar) {
        super(arhVar);
        this.a = arhVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arg
    final Object a(int i) {
        return this.a.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iC = ary.c(obj);
        int iE = this.a.e(obj, iC);
        if (iE == -1) {
            return false;
        }
        this.a.h(iE, iC);
        return true;
    }
}
