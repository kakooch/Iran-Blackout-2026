package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.Kq8;
import java.util.HashMap;

@VisibleForTesting
/* loaded from: classes3.dex */
public final class zzav extends Kq8 {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.zza);
        map.put("appVersion", this.zzb);
        map.put("appId", this.zzc);
        map.put("appInstallerId", this.zzd);
        return Kq8.zza(map);
    }

    @Override // ir.nasim.Kq8
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zzc(zzav zzavVar) {
        if (!TextUtils.isEmpty(this.zza)) {
            zzavVar.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzavVar.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzavVar.zzc = this.zzc;
        }
        if (TextUtils.isEmpty(this.zzd)) {
            return;
        }
        zzavVar.zzd = this.zzd;
    }

    public final void zzi(String str) {
        this.zzc = str;
    }

    public final void zzj(String str) {
        this.zzd = str;
    }

    public final void zzk(String str) {
        this.zza = str;
    }

    public final void zzl(String str) {
        this.zzb = str;
    }
}
