package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzka implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzkb zzc;

    zzka(zzkb zzkbVar, String str, Bundle bundle) {
        this.zzc = zzkbVar;
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzz(this.zzc.zza.zzr().zzV(this.zza, "_err", this.zzb, "auto", this.zzc.zza.zzax().currentTimeMillis(), false, false), this.zza);
    }
}
