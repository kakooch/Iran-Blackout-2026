package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfb;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfb.zza {
    private zzfb zza;

    @Override // com.google.android.gms.measurement.internal.zzfb.zza
    public void doStartService(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfb(this);
        }
        this.zza.zzb(context, intent);
    }
}
