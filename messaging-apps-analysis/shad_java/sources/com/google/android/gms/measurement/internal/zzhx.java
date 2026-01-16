package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhx implements Runnable {
    final /* synthetic */ zzib zza;

    zzhx(zzib zzibVar) {
        this.zza = zzibVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar = this.zza;
        zzibVar.zza = zzibVar.zzh;
    }
}
