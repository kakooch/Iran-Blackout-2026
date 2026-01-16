package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdh extends zzhs<zzdh, zzdg> implements zziy {
    private static final zzdh zze;
    private zzhz<zzdj> zza = zzhs.zzbE();

    static {
        zzdh zzdhVar = new zzdh();
        zze = zzdhVar;
        zzhs.zzby(zzdh.class, zzdhVar);
    }

    private zzdh() {
    }

    public static zzdg zzc() {
        return zze.zzbt();
    }

    static /* synthetic */ void zze(zzdh zzdhVar, zzdj zzdjVar) {
        zzdjVar.getClass();
        zzhz<zzdj> zzhzVar = zzdhVar.zza;
        if (!zzhzVar.zza()) {
            zzdhVar.zza = zzhs.zzbF(zzhzVar);
        }
        zzdhVar.zza.add(zzdjVar);
    }

    public final List<zzdj> zza() {
        return this.zza;
    }

    public final zzdj zzb(int i) {
        return this.zza.get(0);
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdj.class});
        }
        if (i2 == 3) {
            return new zzdh();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzdg(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zze;
    }
}
