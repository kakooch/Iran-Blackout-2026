package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zziy implements Runnable {
    final /* synthetic */ zzja zza;

    zziy(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjb zzjbVar = this.zza.zza;
        Context contextZzaw = zzjbVar.zzx.zzaw();
        this.zza.zza.zzx.zzas();
        zzjb.zzJ(zzjbVar, new ComponentName(contextZzaw, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
