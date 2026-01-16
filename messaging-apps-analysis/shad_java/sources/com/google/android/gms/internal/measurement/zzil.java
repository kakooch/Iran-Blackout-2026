package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
abstract class zzil {
    private static final zzil zza;
    private static final zzil zzb;

    static {
        zzii zziiVar = null;
        zza = new zzij(zziiVar);
        zzb = new zzik(zziiVar);
    }

    /* synthetic */ zzil(zzii zziiVar) {
    }

    static zzil zzc() {
        return zza;
    }

    static zzil zzd() {
        return zzb;
    }

    abstract void zza(Object obj, long j);

    abstract <L> void zzb(Object obj, Object obj2, long j);
}
