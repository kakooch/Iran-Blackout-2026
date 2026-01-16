package com.google.android.gms.measurement.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhw implements Runnable {
    final /* synthetic */ zzhu zza;
    final /* synthetic */ zzhu zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzib zze;

    zzhw(zzib zzibVar, zzhu zzhuVar, zzhu zzhuVar2, long j, boolean z) {
        this.zze = zzibVar;
        this.zza = zzhuVar;
        this.zzb = zzhuVar2;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
