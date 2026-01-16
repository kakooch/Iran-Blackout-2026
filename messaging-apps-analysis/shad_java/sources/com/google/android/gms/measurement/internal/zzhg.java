package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhg implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzhn zzb;

    zzhg(zzhn zzhnVar, AtomicReference atomicReference) {
        this.zzb = zzhnVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzx.zzc().zzm(this.zzb.zzx.zzA().zzi(), zzdw.zzN)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
