package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhf implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzhn zzb;

    zzhf(zzhn zzhnVar, AtomicReference atomicReference) {
        this.zzb = zzhnVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Integer.valueOf(this.zzb.zzx.zzc().zzk(this.zzb.zzx.zzA().zzi(), zzdw.zzM)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
