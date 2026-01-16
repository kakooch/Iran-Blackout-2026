package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgr implements Runnable {
    final /* synthetic */ zzhn zza;

    zzgr(zzhn zzhnVar) {
        this.zza = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
