package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.BD1;
import ir.nasim.OV0;

@VisibleForTesting
/* loaded from: classes3.dex */
public final class zzd {
    private static final Object zza = new Object();
    private static zzd zzb;
    private volatile AdvertisingIdClient.Info zzf;
    private volatile long zzg;
    private volatile long zzh;
    private final Context zzi;
    private final OV0 zzj;
    private final Thread zzk;
    private volatile long zzc = 900000;
    private volatile long zzd = 30000;
    private volatile boolean zze = false;
    private final Object zzl = new Object();
    private final zzc zzm = new zza(this);

    @VisibleForTesting
    public zzd(Context context, zzc zzcVar, OV0 ov0) {
        this.zzj = ov0;
        if (context != null) {
            this.zzi = context.getApplicationContext();
        } else {
            this.zzi = null;
        }
        this.zzg = ov0.currentTimeMillis();
        this.zzk = new Thread(new zzb(this));
    }

    public static zzd zzb(Context context) {
        if (zzb == null) {
            synchronized (zza) {
                try {
                    if (zzb == null) {
                        zzd zzdVar = new zzd(context, null, BD1.a());
                        zzb = zzdVar;
                        zzdVar.zzk.start();
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzd(zzd zzdVar) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (!zzdVar.zze) {
            AdvertisingIdClient.Info infoZza = zzdVar.zzm.zza();
            if (infoZza != null) {
                zzdVar.zzf = infoZza;
                zzdVar.zzh = zzdVar.zzj.currentTimeMillis();
                zzdh.zzb.zzb("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (zzdVar) {
                zzdVar.notifyAll();
            }
            try {
                synchronized (zzdVar.zzl) {
                    zzdVar.zzl.wait(zzdVar.zzc);
                }
            } catch (InterruptedException unused) {
                zzdh.zzb.zzb("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    @VisibleForTesting
    public final void zze() {
        this.zze = true;
        this.zzk.interrupt();
    }
}
