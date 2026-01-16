package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C3264Ad1;
import ir.nasim.Gu8;
import java.util.Collections;

@VisibleForTesting
/* loaded from: classes3.dex */
public final class zzcc extends zzbs {
    private final zzcb zza;
    private final zzcw zzb;
    private final zzfo zzc;
    private zzey zzd;

    protected zzcc(zzbv zzbvVar) {
        super(zzbvVar);
        this.zzc = new zzfo(zzbvVar.zzr());
        this.zza = new zzcb(this);
        this.zzb = new zzby(this, zzbvVar);
    }

    static /* bridge */ /* synthetic */ void zzb(zzcc zzccVar, ComponentName componentName) {
        Gu8.e();
        if (zzccVar.zzd != null) {
            zzccVar.zzd = null;
            zzccVar.zzP("Disconnected from device AnalyticsService", componentName);
            zzccVar.zzs().zzk();
        }
    }

    static /* bridge */ /* synthetic */ void zzi(zzcc zzccVar, zzey zzeyVar) {
        Gu8.e();
        zzccVar.zzd = zzeyVar;
        zzccVar.zzj();
        zzccVar.zzs().zzj();
    }

    private final void zzj() {
        this.zzc.zzb();
        zzcw zzcwVar = this.zzb;
        zzw();
        zzcwVar.zzg(zzeu.zzK.zzb().longValue());
    }

    public final void zzc() {
        Gu8.e();
        zzW();
        try {
            C3264Ad1.b().c(zzo(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.zzd != null) {
            this.zzd = null;
            zzs().zzk();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbs
    protected final void zzd() {
    }

    public final boolean zzf() {
        Gu8.e();
        zzW();
        if (this.zzd != null) {
            return true;
        }
        zzey zzeyVarZza = this.zza.zza();
        if (zzeyVarZza == null) {
            return false;
        }
        this.zzd = zzeyVarZza;
        zzj();
        return true;
    }

    public final boolean zzg() {
        Gu8.e();
        zzW();
        return this.zzd != null;
    }

    public final boolean zzh(zzex zzexVar) {
        String strZzk;
        AbstractC3795Cj5.j(zzexVar);
        Gu8.e();
        zzW();
        zzey zzeyVar = this.zzd;
        if (zzeyVar == null) {
            return false;
        }
        if (zzexVar.zzh()) {
            zzw();
            strZzk = zzct.zzi();
        } else {
            zzw();
            strZzk = zzct.zzk();
        }
        try {
            zzeyVar.zzf(zzexVar.zzg(), zzexVar.zzd(), strZzk, Collections.emptyList());
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzO("Failed to send hits to AnalyticsService");
            return false;
        }
    }
}
