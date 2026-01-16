package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbj extends zzbg {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzbq zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbj(zzbq zzbqVar, Bundle bundle, Activity activity) {
        super(zzbqVar.zza, true);
        this.zzc = zzbqVar;
        this.zza = bundle;
        this.zzb = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zza != null) {
            bundle = new Bundle();
            if (this.zza.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zza.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        this.zzc.zza.zzk.onActivityCreated(ObjectWrapper.wrap(this.zzb), bundle, this.zzi);
    }
}
