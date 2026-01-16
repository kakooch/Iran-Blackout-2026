package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgy implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhn zzb;

    zzgy(zzhn zzhnVar, Bundle bundle) {
        this.zzb = zzhnVar;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhn zzhnVar = this.zzb;
        Bundle bundle = this.zza;
        zzhnVar.zzg();
        zzhnVar.zzb();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzhnVar.zzx.zzF()) {
            zzhnVar.zzx.zzat().zzk().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzhnVar.zzx.zzy().zzm(new zzaa(bundle.getString("app_id"), bundle.getString("origin"), new zzkg(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzhnVar.zzx.zzl().zzV(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
