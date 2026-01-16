package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhe implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzhn zzb;

    zzhe(zzhn zzhnVar, AtomicReference atomicReference) {
        this.zzb = zzhnVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zzx.zzc().zzj(this.zzb.zzx.zzA().zzi(), zzdw.zzL)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
