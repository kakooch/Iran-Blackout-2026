package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzik extends zzil {
    /* synthetic */ zzik(zzii zziiVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzil
    final void zza(Object obj, long j) {
        ((zzhz) zzkh.zzn(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzil
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzhz zzhzVarZze = (zzhz) zzkh.zzn(obj, j);
        zzhz zzhzVar = (zzhz) zzkh.zzn(obj2, j);
        int size = zzhzVarZze.size();
        int size2 = zzhzVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzhzVarZze.zza()) {
                zzhzVarZze = zzhzVarZze.zze(size2 + size);
            }
            zzhzVarZze.addAll(zzhzVar);
        }
        if (size > 0) {
            zzhzVar = zzhzVarZze;
        }
        zzkh.zzo(obj, j, zzhzVar);
    }
}
