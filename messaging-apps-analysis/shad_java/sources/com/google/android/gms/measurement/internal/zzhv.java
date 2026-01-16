package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhv implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhu zzb;
    final /* synthetic */ zzhu zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzib zze;

    zzhv(zzib zzibVar, Bundle bundle, zzhu zzhuVar, zzhu zzhuVar2, long j) {
        this.zze = zzibVar;
        this.zza = bundle;
        this.zzb = zzhuVar;
        this.zzc = zzhuVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzib.zzu(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
