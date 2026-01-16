package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzco extends zzho<zzcp, zzco> implements zziy {
    private zzco() {
        super(zzcp.zzn);
    }

    /* synthetic */ zzco(zzcl zzclVar) {
        super(zzcp.zzn);
    }

    public final int zza() {
        return ((zzcp) this.zza).zzf();
    }

    public final zzcn zzb(int i) {
        return ((zzcp) this.zza).zzg(i);
    }

    public final zzco zzc(int i, zzcm zzcmVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcp.zzn((zzcp) this.zza, i, zzcmVar.zzaA());
        return this;
    }

    public final List<zzbu> zzd() {
        return Collections.unmodifiableList(((zzcp) this.zza).zzh());
    }

    public final zzco zze() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        ((zzcp) this.zza).zzj = zzhs.zzbE();
        return this;
    }
}
