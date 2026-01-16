package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjl implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjm zzc;

    zzjl(zzjm zzjmVar, long j, long j2) {
        this.zzc = zzjmVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zza.zzx.zzau().zzh(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzjk
            private final zzjl zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                zzjl zzjlVar = this.zza;
                zzjm zzjmVar = zzjlVar.zzc;
                long j = zzjlVar.zza;
                long j2 = zzjlVar.zzb;
                zzjmVar.zza.zzg();
                zzjmVar.zza.zzx.zzat().zzj().zza("Application going to the background");
                boolean z = true;
                if (zzjmVar.zza.zzx.zzc().zzn(null, zzdw.zzat)) {
                    zzjmVar.zza.zzx.zzd().zzq.zzb(true);
                }
                Bundle bundle = new Bundle();
                if (!zzjmVar.zza.zzx.zzc().zzt()) {
                    zzjmVar.zza.zzb.zzb(j2);
                    if (zzjmVar.zza.zzx.zzc().zzn(null, zzdw.zzak)) {
                        zzjo zzjoVar = zzjmVar.zza.zzb;
                        long j3 = zzjoVar.zzb;
                        zzjoVar.zzb = j2;
                        bundle.putLong("_et", j2 - j3);
                        zzib.zzm(zzjmVar.zza.zzx.zzx().zzh(true), bundle, true);
                    } else {
                        z = false;
                    }
                    zzjmVar.zza.zzb.zzd(false, z, j2);
                }
                zzjmVar.zza.zzx.zzk().zzt("auto", "_ab", j, bundle);
            }
        });
    }
}
