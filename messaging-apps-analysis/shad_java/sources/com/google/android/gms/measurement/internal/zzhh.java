package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhh implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhn zzb;

    zzhh(zzhn zzhnVar, Boolean bool) {
        this.zzb = zzhnVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzY(this.zza, true);
    }
}
