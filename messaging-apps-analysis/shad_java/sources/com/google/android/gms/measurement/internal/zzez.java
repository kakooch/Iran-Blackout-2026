package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzez implements ServiceConnection {
    final /* synthetic */ zzfa zza;
    private final String zzb;

    zzez(zzfa zzfaVar, String str) {
        this.zza = zzfaVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzat().zze().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzf zzfVarZzb = com.google.android.gms.internal.measurement.zze.zzb(iBinder);
            if (zzfVarZzb == null) {
                this.zza.zza.zzat().zze().zza("Install Referrer Service implementation was not found");
            } else {
                this.zza.zza.zzat().zzk().zza("Install Referrer Service connected");
                this.zza.zza.zzau().zzh(new zzey(this, zzfVarZzb, this));
            }
        } catch (Exception e) {
            this.zza.zza.zzat().zze().zzb("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzat().zzk().zza("Install Referrer Service disconnected");
    }
}
