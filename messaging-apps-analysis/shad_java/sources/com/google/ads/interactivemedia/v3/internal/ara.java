package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ara extends arg {
    final /* synthetic */ arh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ara(arh arhVar) {
        super(arhVar);
        this.a = arhVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arg
    final /* bridge */ /* synthetic */ Object a(int i) {
        return new aqy(this.a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iB = this.a.b(key);
            if (iB != -1 && apz.b(value, this.a.b[iB])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int iC = ary.c(key);
        int iC2 = this.a.c(key, iC);
        if (iC2 == -1 || !apz.b(value, this.a.b[iC2])) {
            return false;
        }
        this.a.g(iC2, iC);
        return true;
    }
}
