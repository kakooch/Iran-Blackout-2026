package com.google.android.gms.internal.gtm;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.OV0;

/* loaded from: classes3.dex */
final class zzfo {
    private final OV0 zza;
    private long zzb;

    public zzfo(OV0 ov0) {
        AbstractC3795Cj5.j(ov0);
        this.zza = ov0;
    }

    public final void zza() {
        this.zzb = 0L;
    }

    public final void zzb() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final boolean zzc(long j) {
        return this.zzb == 0 || this.zza.elapsedRealtime() - this.zzb > j;
    }

    public zzfo(OV0 ov0, long j) {
        AbstractC3795Cj5.j(ov0);
        this.zza = ov0;
        this.zzb = j;
    }
}
