package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzil extends zzal {
    final /* synthetic */ zzjb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzil(zzjb zzjbVar, zzgg zzggVar) {
        super(zzggVar);
        this.zza = zzjbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzal
    public final void zza() {
        zzjb zzjbVar = this.zza;
        zzjbVar.zzg();
        if (zzjbVar.zzh()) {
            zzjbVar.zzx.zzat().zzk().zza("Inactivity, disconnecting from the service");
            zzjbVar.zzF();
        }
    }
}
