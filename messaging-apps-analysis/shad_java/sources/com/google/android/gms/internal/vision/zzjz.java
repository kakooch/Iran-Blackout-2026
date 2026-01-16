package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zzjz extends zzju {
    private zzjz() {
        super();
    }

    @Override // com.google.android.gms.internal.vision.zzju
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzju
    final <E> void zza(Object obj, Object obj2, long j) {
        zzjl zzjlVarZzc = zzc(obj, j);
        zzjl zzjlVarZzc2 = zzc(obj2, j);
        int size = zzjlVarZzc.size();
        int size2 = zzjlVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzjlVarZzc.zza()) {
                zzjlVarZzc = zzjlVarZzc.zza(size2 + size);
            }
            zzjlVarZzc.addAll(zzjlVarZzc2);
        }
        if (size > 0) {
            zzjlVarZzc2 = zzjlVarZzc;
        }
        zzma.zza(obj, j, zzjlVarZzc2);
    }

    private static <E> zzjl<E> zzc(Object obj, long j) {
        return (zzjl) zzma.zzf(obj, j);
    }
}
