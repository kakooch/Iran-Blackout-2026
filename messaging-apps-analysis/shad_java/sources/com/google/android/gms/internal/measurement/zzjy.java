package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjy extends zzjw<zzjx, zzjx> {
    zzjy() {
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ void zza(zzjx zzjxVar, int i, long j) {
        zzjxVar.zzh(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ zzjx zzb() {
        return zzjx.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ void zzc(Object obj, zzjx zzjxVar) {
        ((zzhs) obj).zzc = zzjxVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ zzjx zzd(Object obj) {
        return ((zzhs) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final void zze(Object obj) {
        ((zzhs) obj).zzc.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ zzjx zzf(zzjx zzjxVar, zzjx zzjxVar2) {
        zzjx zzjxVar3 = zzjxVar2;
        return zzjxVar3.equals(zzjx.zza()) ? zzjxVar : zzjx.zzc(zzjxVar, zzjxVar3);
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ int zzg(zzjx zzjxVar) {
        return zzjxVar.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ int zzh(zzjx zzjxVar) {
        return zzjxVar.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzjw
    final /* bridge */ /* synthetic */ void zzi(zzjx zzjxVar, zzha zzhaVar) throws IOException {
        zzjxVar.zzi(zzhaVar);
    }
}
