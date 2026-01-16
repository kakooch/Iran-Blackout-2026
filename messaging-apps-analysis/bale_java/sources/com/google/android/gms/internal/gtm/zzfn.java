package com.google.android.gms.internal.gtm;

import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import com.google.android.gms.internal.gtm.zzfm;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C23502x18;

/* loaded from: classes3.dex */
public final class zzfn<T extends Context & zzfm> {
    private static Boolean zza;
    private final Handler zzb;
    private final T zzc;

    public zzfn(T t) {
        AbstractC3795Cj5.j(t);
        this.zzc = t;
        this.zzb = new zzga();
    }

    public static boolean zzh(Context context) throws PackageManager.NameNotFoundException {
        AbstractC3795Cj5.j(context);
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"), 0);
            if (serviceInfo != null) {
                if (serviceInfo.enabled) {
                    z = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zza = Boolean.valueOf(z);
        return z;
    }

    public final int zza(Intent intent, int i, final int i2) {
        try {
            synchronized (zzfi.zza) {
                try {
                    C23502x18 c23502x18 = zzfi.zzb;
                    if (c23502x18 != null && c23502x18.b()) {
                        c23502x18.c();
                    }
                } finally {
                }
            }
        } catch (SecurityException unused) {
        }
        zzbv zzbvVarZzg = zzbv.zzg(this.zzc);
        final zzfb zzfbVarZzm = zzbvVarZzg.zzm();
        if (intent == null) {
            zzfbVarZzm.zzR("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzbvVarZzg.zzj();
        zzfbVarZzm.zzQ("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzg(new Runnable() { // from class: com.google.android.gms.internal.gtm.zzfj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzc(i2, zzfbVarZzm);
                }
            });
        }
        return 2;
    }

    public final /* synthetic */ void zzc(int i, zzfb zzfbVar) {
        if (this.zzc.callServiceStopSelfResult(i)) {
            zzfbVar.zzO("Local AnalyticsService processed last dispatch request");
        }
    }

    public final /* synthetic */ void zzd(zzfb zzfbVar, JobParameters jobParameters) {
        zzfbVar.zzO("AnalyticsJobService processed last dispatch request");
        this.zzc.zza(jobParameters, false);
    }

    public final void zze() {
        zzbv zzbvVarZzg = zzbv.zzg(this.zzc);
        zzfb zzfbVarZzm = zzbvVarZzg.zzm();
        zzbvVarZzg.zzj();
        zzfbVarZzm.zzO("Local AnalyticsService is starting up");
    }

    public final void zzf() {
        zzbv zzbvVarZzg = zzbv.zzg(this.zzc);
        zzfb zzfbVarZzm = zzbvVarZzg.zzm();
        zzbvVarZzg.zzj();
        zzfbVarZzm.zzO("Local AnalyticsService is shutting down");
    }

    public final void zzg(Runnable runnable) {
        zzbv.zzg(this.zzc).zzf().zze(new zzfl(this, runnable));
    }

    public final boolean zzi(final JobParameters jobParameters) {
        zzbv zzbvVarZzg = zzbv.zzg(this.zzc);
        final zzfb zzfbVarZzm = zzbvVarZzg.zzm();
        String string = jobParameters.getExtras().getString("action");
        zzbvVarZzg.zzj();
        zzfbVarZzm.zzP("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zzg(new Runnable() { // from class: com.google.android.gms.internal.gtm.zzfk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zzfbVarZzm, jobParameters);
            }
        });
        return true;
    }
}
