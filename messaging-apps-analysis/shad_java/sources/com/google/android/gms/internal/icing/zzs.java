package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzs {
    private final String zza;
    private String zzb;
    private boolean zzc;
    private boolean zze;
    private String zzg;
    private int zzd = 1;
    private final List<zzm> zzf = new ArrayList();

    public zzs(String str) {
        this.zza = str;
    }

    public final zzs zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzs zza(boolean z) {
        this.zzc = true;
        return this;
    }

    public final zzt zza() {
        String str = this.zza;
        String str2 = this.zzb;
        boolean z = this.zzc;
        int i = this.zzd;
        boolean z2 = this.zze;
        List<zzm> list = this.zzf;
        return new zzt(str, str2, z, i, z2, null, (zzm[]) list.toArray(new zzm[list.size()]), this.zzg, null);
    }
}
