package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes3.dex */
public final class zzcf extends zzbs {
    private final zzav zza;

    zzcf(zzbv zzbvVar) {
        super(zzbvVar);
        this.zza = new zzav();
    }

    public final zzav zza() {
        zzW();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbs
    protected final void zzd() {
        zzq().b().zzc(this.zza);
        zzft zzftVarZzB = zzB();
        zzftVarZzB.zzW();
        String str = zzftVarZzB.zzb;
        if (str != null) {
            this.zza.zzk(str);
        }
        zzftVarZzB.zzW();
        String str2 = zzftVarZzB.zza;
        if (str2 != null) {
            this.zza.zzl(str2);
        }
    }
}
