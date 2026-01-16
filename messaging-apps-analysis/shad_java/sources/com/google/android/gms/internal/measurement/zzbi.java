package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbi extends zzu {
    private final com.google.android.gms.measurement.internal.zzgm zza;

    zzbi(com.google.android.gms.measurement.internal.zzgm zzgmVar) {
        this.zza = zzgmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zzd(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
