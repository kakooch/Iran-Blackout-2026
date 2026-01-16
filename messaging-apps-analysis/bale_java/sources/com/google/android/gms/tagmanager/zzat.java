package com.google.android.gms.tagmanager;

import java.util.List;

/* loaded from: classes3.dex */
final class zzat implements zzaw {
    final /* synthetic */ DataLayer zza;

    zzat(DataLayer dataLayer) {
        this.zza = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zza(List<zzau> list) {
        for (zzau zzauVar : list) {
            DataLayer dataLayer = this.zza;
            dataLayer.zzi(dataLayer.zza(zzauVar.zza, zzauVar.zzb));
        }
        this.zza.zzh.countDown();
    }
}
