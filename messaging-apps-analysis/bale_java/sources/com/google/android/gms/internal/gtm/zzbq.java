package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gu8;

/* loaded from: classes3.dex */
public final class zzbq extends zzbs {
    private final zzck zza;

    public zzbq(zzbv zzbvVar, zzbw zzbwVar) {
        super(zzbvVar);
        AbstractC3795Cj5.j(zzbwVar);
        this.zza = new zzck(zzbvVar, zzbwVar);
    }

    public final void zzc() {
        zzW();
        Context contextZzo = zzo();
        if (!zzfi.zza(contextZzo) || !zzfn.zzh(contextZzo)) {
            zze(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsService"));
        contextZzo.startService(intent);
    }

    @Override // com.google.android.gms.internal.gtm.zzbs
    protected final void zzd() {
        this.zza.zzX();
    }

    public final void zze(zzcz zzczVar) {
        zzW();
        zzq().f(new zzbo(this, zzczVar));
    }

    public final void zzf(String str, Runnable runnable) {
        AbstractC3795Cj5.g(str, "campaign param can't be empty");
        zzq().f(new zzbk(this, str, runnable));
    }

    final void zzi() {
        Gu8.e();
        this.zza.zzl();
    }

    final void zzj() {
        Gu8.e();
        this.zza.zzm();
    }

    public final void zzk() {
        zzW();
        Gu8.e();
        zzck zzckVar = this.zza;
        Gu8.e();
        zzckVar.zzW();
        zzckVar.zzO("Service disconnected");
    }

    public final void zzm() {
        this.zza.zzaa();
    }
}
