package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhd implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzhn zzb;

    zzhd(zzhn zzhnVar, AtomicReference atomicReference) {
        this.zzb = zzhnVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(this.zzb.zzx.zzc().zzi(this.zzb.zzx.zzA().zzi(), zzdw.zzK));
            } finally {
                this.zza.notify();
            }
        }
    }
}
