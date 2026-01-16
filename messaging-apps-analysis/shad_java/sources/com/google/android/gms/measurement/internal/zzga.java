package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzga implements Callable<List<zzki>> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgd zzb;

    zzga(zzgd zzgdVar, String str) {
        this.zzb = zzgdVar;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ List<zzki> call() throws Exception {
        this.zzb.zza.zzK();
        return this.zzb.zza.zzi().zzl(this.zza);
    }
}
