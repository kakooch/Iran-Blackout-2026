package com.google.android.gms.measurement.api;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzgm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
public class AppMeasurementSdk {
    private final zzbr zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
    public interface OnEventListener extends zzgm {
    }

    public AppMeasurementSdk(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    public void clearConditionalUserProperty(@RecentlyNonNull String str, String str2, Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    @RecentlyNonNull
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    public int getMaxUserProperties(@RecentlyNonNull String str) {
        return this.zza.zzE(str);
    }

    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    public void registerOnMeasurementEventListener(@RecentlyNonNull OnEventListener onEventListener) {
        this.zza.zze(onEventListener);
    }

    public void setConditionalUserProperty(@RecentlyNonNull Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object obj) {
        this.zza.zzj(str, str2, obj, true);
    }

    public final void zza(boolean z) {
        this.zza.zzI(z);
    }
}
