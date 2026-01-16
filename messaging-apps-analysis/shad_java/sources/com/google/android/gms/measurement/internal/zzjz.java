package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjz implements Callable<String> {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzkd zzb;

    zzjz(zzkd zzkdVar, zzp zzpVar) {
        this.zzb = zzkdVar;
        this.zza = zzpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        zzlc.zzb();
        if (!this.zzb.zzd().zzn(null, zzdw.zzay) || (this.zzb.zzx(this.zza.zza).zzh() && zzaf.zzc(this.zza.zzv).zzh())) {
            return this.zzb.zzX(this.zza).zzd();
        }
        this.zzb.zzat().zzk().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
