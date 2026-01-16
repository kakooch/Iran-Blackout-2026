package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzkb implements zzkj {
    final /* synthetic */ zzkd zza;

    zzkb(zzkd zzkdVar) {
        this.zza = zzkdVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final void zza(String str, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzl.zzat().zzb().zza("AppId not known when logging error event");
        } else {
            this.zza.zzau().zzh(new zzka(this, str, bundle));
        }
    }
}
