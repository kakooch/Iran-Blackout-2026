package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.wearable.CapabilityApi;

/* loaded from: classes3.dex */
final class zzgr extends zzgm<CapabilityApi.GetCapabilityResult> {
    public zzgr(BaseImplementation$ResultHolder<CapabilityApi.GetCapabilityResult> baseImplementation$ResultHolder) {
        super(baseImplementation$ResultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdk zzdkVar) {
        Status statusZzb = zzgd.zzb(zzdkVar.statusCode);
        zzah zzahVar = zzdkVar.zzdq;
        zza((zzgr) new zzy(statusZzb, zzahVar == null ? null : new zzw(zzahVar)));
    }
}
