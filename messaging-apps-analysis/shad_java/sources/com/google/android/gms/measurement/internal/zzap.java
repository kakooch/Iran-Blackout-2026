package com.google.android.gms.measurement.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzap implements Iterator<String>, j$.util.Iterator {
    final Iterator<String> zza;
    final /* synthetic */ zzaq zzb;

    zzap(zzaq zzaqVar) {
        this.zzb = zzaqVar;
        this.zza = zzaqVar.zza.keySet().iterator();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return this.zza.next();
    }
}
