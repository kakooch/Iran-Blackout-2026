package com.google.android.gms.internal.measurement;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjq implements Iterator<Map.Entry>, j$.util.Iterator {
    final /* synthetic */ zzjs zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzjq(zzjs zzjsVar, zzjl zzjlVar) {
        this.zza = zzjsVar;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zzb.size()) {
            return !this.zza.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < this.zza.zzb.size() ? this.zza.zzb.get(this.zzb) : zza().next());
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzm();
        if (this.zzb >= this.zza.zzb.size()) {
            zza().remove();
            return;
        }
        zzjs zzjsVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzjsVar.zzk(i);
    }
}
