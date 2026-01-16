package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjh;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements zzjg {
    private zzjh<AppMeasurementService> zza;

    private final zzjh<AppMeasurementService> zzd() {
        if (this.zza == null) {
            this.zza = new zzjh<>(this);
        }
        return this.zza;
    }

    @Override // android.app.Service
    @RecentlyNonNull
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        return zzd().zze(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzd().zza();
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzd().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(@RecentlyNonNull Intent intent) {
        zzd().zzh(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(@RecentlyNonNull Intent intent, int i, int i2) throws IllegalStateException {
        zzd().zzc(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(@RecentlyNonNull Intent intent) {
        zzd().zzf(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final void zzb(@RecentlyNonNull JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final void zzc(@RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
