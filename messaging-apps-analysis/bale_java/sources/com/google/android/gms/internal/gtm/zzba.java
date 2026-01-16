package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.Kq8;
import java.util.HashMap;

@VisibleForTesting
/* loaded from: classes3.dex */
public final class zzba extends Kq8 {
    public int zza;
    public int zzb;
    private String zzc;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("language", this.zzc);
        map.put("screenColors", 0);
        map.put("screenWidth", Integer.valueOf(this.zza));
        map.put("screenHeight", Integer.valueOf(this.zzb));
        map.put("viewportWidth", 0);
        map.put("viewportHeight", 0);
        return Kq8.zza(map);
    }

    @Override // ir.nasim.Kq8
    public final /* bridge */ /* synthetic */ void zzc(Kq8 kq8) {
        zzba zzbaVar = (zzba) kq8;
        int i = this.zza;
        if (i != 0) {
            zzbaVar.zza = i;
        }
        int i2 = this.zzb;
        if (i2 != 0) {
            zzbaVar.zzb = i2;
        }
        if (TextUtils.isEmpty(this.zzc)) {
            return;
        }
        zzbaVar.zzc = this.zzc;
    }

    public final void zze(String str) {
        this.zzc = str;
    }
}
