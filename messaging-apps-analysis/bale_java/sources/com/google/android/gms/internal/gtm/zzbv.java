package com.google.android.gms.internal.gtm;

import android.content.Context;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.BD1;
import ir.nasim.Gu8;
import ir.nasim.OV0;
import ir.nasim.RJ2;

/* loaded from: classes3.dex */
public final class zzbv {
    private static volatile zzbv zza;
    private final Context zzb;
    private final Context zzc;
    private final OV0 zzd;
    private final zzct zze;
    private final zzfb zzf;
    private final Gu8 zzg;
    private final zzbq zzh;
    private final zzcy zzi;
    private final zzft zzj;
    private final zzfh zzk;
    private final RJ2 zzl;
    private final zzcn zzm;
    private final zzbi zzn;
    private final zzcf zzo;
    private final zzcx zzp;

    protected zzbv(zzbw zzbwVar) {
        Context contextZza = zzbwVar.zza();
        AbstractC3795Cj5.k(contextZza, "Application context can't be null");
        Context contextZzb = zzbwVar.zzb();
        AbstractC3795Cj5.j(contextZzb);
        this.zzb = contextZza;
        this.zzc = contextZzb;
        this.zzd = BD1.a();
        this.zze = new zzct(this);
        zzfb zzfbVar = new zzfb(this);
        zzfbVar.zzX();
        this.zzf = zzfbVar;
        zzfb zzfbVarZzm = zzm();
        String str = zzbt.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 134);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzfbVarZzm.zzM(sb.toString());
        zzfh zzfhVar = new zzfh(this);
        zzfhVar.zzX();
        this.zzk = zzfhVar;
        zzft zzftVar = new zzft(this);
        zzftVar.zzX();
        this.zzj = zzftVar;
        zzbq zzbqVar = new zzbq(this, zzbwVar);
        zzcn zzcnVar = new zzcn(this);
        zzbi zzbiVar = new zzbi(this);
        zzcf zzcfVar = new zzcf(this);
        zzcx zzcxVar = new zzcx(this);
        Gu8 gu8A = Gu8.a(contextZza);
        gu8A.g(new zzbu(this));
        this.zzg = gu8A;
        RJ2 rj2 = new RJ2(this);
        zzcnVar.zzX();
        this.zzm = zzcnVar;
        zzbiVar.zzX();
        this.zzn = zzbiVar;
        zzcfVar.zzX();
        this.zzo = zzcfVar;
        zzcxVar.zzX();
        this.zzp = zzcxVar;
        zzcy zzcyVar = new zzcy(this);
        zzcyVar.zzX();
        this.zzi = zzcyVar;
        zzbqVar.zzX();
        this.zzh = zzbqVar;
        rj2.h();
        this.zzl = rj2;
        zzbqVar.zzm();
    }

    public static zzbv zzg(Context context) {
        AbstractC3795Cj5.j(context);
        if (zza == null) {
            synchronized (zzbv.class) {
                try {
                    if (zza == null) {
                        OV0 ov0A = BD1.a();
                        long jElapsedRealtime = ov0A.elapsedRealtime();
                        zzbv zzbvVar = new zzbv(new zzbw(context));
                        zza = zzbvVar;
                        RJ2.g();
                        long jElapsedRealtime2 = ov0A.elapsedRealtime() - jElapsedRealtime;
                        Long lZzb = zzeu.zzQ.zzb();
                        if (jElapsedRealtime2 > lZzb.longValue()) {
                            zzbvVar.zzm().zzT("Slow initialization (ms)", Long.valueOf(jElapsedRealtime2), lZzb);
                        }
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    private static final void zzs(zzbs zzbsVar) {
        AbstractC3795Cj5.k(zzbsVar, "Analytics service not created/initialized");
        AbstractC3795Cj5.b(zzbsVar.zzY(), "Analytics service not initialized");
    }

    public final Context zza() {
        return this.zzb;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final Gu8 zzd() {
        AbstractC3795Cj5.j(this.zzg);
        return this.zzg;
    }

    public final zzbq zzf() {
        zzs(this.zzh);
        return this.zzh;
    }

    public final zzcf zzh() {
        zzs(this.zzo);
        return this.zzo;
    }

    public final zzct zzj() {
        return this.zze;
    }

    public final zzcx zzk() {
        return this.zzp;
    }

    public final zzcy zzl() {
        zzs(this.zzi);
        return this.zzi;
    }

    public final zzfb zzm() {
        zzs(this.zzf);
        return this.zzf;
    }

    public final zzfb zzn() {
        return this.zzf;
    }

    public final zzfh zzo() {
        zzs(this.zzk);
        return this.zzk;
    }

    public final zzfh zzp() {
        zzfh zzfhVar = this.zzk;
        if (zzfhVar == null || !zzfhVar.zzY()) {
            return null;
        }
        return this.zzk;
    }

    public final zzft zzq() {
        zzs(this.zzj);
        return this.zzj;
    }

    public final OV0 zzr() {
        return this.zzd;
    }
}
