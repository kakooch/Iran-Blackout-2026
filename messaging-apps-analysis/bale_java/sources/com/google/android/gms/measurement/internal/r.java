package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class r implements Iterator {
    final Iterator a;
    final /* synthetic */ zzau b;

    r(zzau zzauVar) {
        this.b = zzauVar;
        this.a = zzauVar.a.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
