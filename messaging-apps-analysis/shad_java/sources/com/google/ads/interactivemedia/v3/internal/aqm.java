package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqm extends AbstractSet<Map.Entry> {
    final /* synthetic */ aqr a;

    aqm(aqr aqrVar) {
        this.a = aqrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapD = this.a.d();
        if (mapD != null) {
            return mapD.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iT = this.a.t(entry.getKey());
            if (iT != -1 && apz.b(this.a.c[iT], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry> iterator() {
        return this.a.i();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapD = this.a.d();
        if (mapD != null) {
            return mapD.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.a.c()) {
            return false;
        }
        int iR = this.a.r();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object obj2 = this.a.e;
        aqr aqrVar = this.a;
        int iK = ary.k(key, value, iR, obj2, aqrVar.a, aqrVar.b, aqrVar.c);
        if (iK == -1) {
            return false;
        }
        this.a.f(iK, iR);
        aqr.p(this.a);
        this.a.e();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
