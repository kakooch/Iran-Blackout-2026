package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgx implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhn zzb;

    zzgx(zzhn zzhnVar, Bundle bundle) {
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
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzhnVar.zzx.zzF()) {
            zzhnVar.zzx.zzat().zzk().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkg zzkgVar = new zzkg(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzas zzasVarZzV = zzhnVar.zzx.zzl().zzV(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, false);
            zzhnVar.zzx.zzy().zzm(new zzaa(bundle.getString("app_id"), string2, zzkgVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzhnVar.zzx.zzl().zzV(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, false), bundle.getLong("trigger_timeout"), zzasVarZzV, bundle.getLong("time_to_live"), zzhnVar.zzx.zzl().zzV(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
