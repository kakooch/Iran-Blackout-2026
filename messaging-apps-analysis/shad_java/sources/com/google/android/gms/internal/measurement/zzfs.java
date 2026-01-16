package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfs {
    public static <T> zzfo<T> zza(zzfo<T> zzfoVar) {
        return ((zzfoVar instanceof zzfq) || (zzfoVar instanceof zzfp)) ? zzfoVar : zzfoVar instanceof Serializable ? new zzfp(zzfoVar) : new zzfq(zzfoVar);
    }

    public static <T> zzfo<T> zzb(T t) {
        return new zzfr(t);
    }
}
