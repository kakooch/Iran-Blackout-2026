package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhb implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhn zze;

    zzhb(zzhn zzhnVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zze = zzhnVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zze.zzx.zzy().zzq(this.zza, null, this.zzb, this.zzc, this.zzd);
    }
}
