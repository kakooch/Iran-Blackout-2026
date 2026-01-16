package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzep implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzeq zzb;

    zzep(zzeq zzeqVar, boolean z) {
        this.zzb = zzeqVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzZ(this.zza);
    }
}
