package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzjt extends zzjv {
    private final AlarmManager zzb;
    private zzal zzc;
    private Integer zzd;

    protected zzjt(zzkd zzkdVar) {
        super(zzkdVar);
        this.zzb = (AlarmManager) this.zzx.zzaw().getSystemService("alarm");
    }

    private final zzal zzf() {
        if (this.zzc == null) {
            this.zzc = new zzjs(this, this.zza.zzR());
        }
        return this.zzc;
    }

    private final void zzh() {
        JobScheduler jobScheduler = (JobScheduler) this.zzx.zzaw().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzi());
        }
    }

    private final int zzi() {
        if (this.zzd == null) {
            String strValueOf = String.valueOf(this.zzx.zzaw().getPackageName());
            this.zzd = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    private final PendingIntent zzj() {
        Context contextZzaw = this.zzx.zzaw();
        return PendingIntent.getBroadcast(contextZzaw, 0, new Intent().setClassName(contextZzaw, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        AlarmManager alarmManager = this.zzb;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzh();
        return false;
    }

    public final void zzc(long j) {
        zzX();
        this.zzx.zzas();
        Context contextZzaw = this.zzx.zzaw();
        if (!zzfb.zza(contextZzaw)) {
            this.zzx.zzat().zzj().zza("Receiver not registered/enabled");
        }
        if (!zzkk.zzP(contextZzaw, false)) {
            this.zzx.zzat().zzj().zza("Service not registered/enabled");
        }
        zzd();
        this.zzx.zzat().zzk().zzb("Scheduling upload, millis", Long.valueOf(j));
        long jElapsedRealtime = this.zzx.zzax().elapsedRealtime() + j;
        this.zzx.zzc();
        if (j < Math.max(0L, zzdw.zzw.zzb(null).longValue()) && !zzf().zzc()) {
            zzf().zzb(j);
        }
        this.zzx.zzas();
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = this.zzb;
            if (alarmManager != null) {
                this.zzx.zzc();
                alarmManager.setInexactRepeating(2, jElapsedRealtime, Math.max(zzdw.zzr.zzb(null).longValue(), j), zzj());
                return;
            }
            return;
        }
        Context contextZzaw2 = this.zzx.zzaw();
        ComponentName componentName = new ComponentName(contextZzaw2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iZzi = zzi();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzg.zza(contextZzaw2, new JobInfo.Builder(iZzi, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void zzd() {
        zzX();
        this.zzx.zzat().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zzb;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzf().zzd();
        if (Build.VERSION.SDK_INT >= 24) {
            zzh();
        }
    }
}
