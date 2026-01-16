package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjs extends zzal {
    final /* synthetic */ zzjt zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjs(zzjt zzjtVar, zzgg zzggVar) {
        super(zzggVar);
        this.zza = zzjtVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzal
    public final void zza() {
        this.zza.zzd();
        this.zza.zzx.zzat().zzk().zza("Starting upload from DelayedRunnable");
        this.zza.zza.zzF();
    }
}
