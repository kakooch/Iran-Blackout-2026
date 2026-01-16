package com.google.android.gms.internal.gtm;

import ir.nasim.AbstractC3795Cj5;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzbx {
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private long zzd;
    private final Map<String, String> zze;

    public zzbx(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.f(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = j2;
        if (map != null) {
            this.zze = new HashMap(map);
        } else {
            this.zze = Collections.emptyMap();
        }
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
