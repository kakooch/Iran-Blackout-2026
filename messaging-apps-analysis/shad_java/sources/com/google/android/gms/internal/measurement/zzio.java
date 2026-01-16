package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzio implements zziv {
    private final zziv[] zza;

    zzio(zziv... zzivVarArr) {
        this.zza = zzivVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zziv
    public final boolean zzb(Class<?> cls) {
        zziv[] zzivVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzivVarArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zziv
    public final zziu zzc(Class<?> cls) {
        zziv[] zzivVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zziv zzivVar = zzivVarArr[i];
            if (zzivVar.zzb(cls)) {
                return zzivVar.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
