package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhc implements zzkj {
    final /* synthetic */ zzhn zza;

    zzhc(zzhn zzhnVar) {
        this.zza = zzhnVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final void zza(String str, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzs("auto", "_err", bundle);
            return;
        }
        zzhn zzhnVar = this.zza;
        zzfl.zzP();
        zzhnVar.zzx("auto", "_err", zzhnVar.zzx.zzax().currentTimeMillis(), bundle, false, true, false, str);
    }
}
