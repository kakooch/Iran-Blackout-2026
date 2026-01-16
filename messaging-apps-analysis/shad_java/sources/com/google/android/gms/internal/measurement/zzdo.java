package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdo extends zzhs<zzdo, zzdk> implements zziy {
    private static final zzdo zzg;
    private int zza;
    private int zze = 1;
    private zzhz<zzdd> zzf = zzhs.zzbE();

    static {
        zzdo zzdoVar = new zzdo();
        zzg = zzdoVar;
        zzhs.zzby(zzdo.class, zzdoVar);
    }

    private zzdo() {
    }

    public static zzdk zza() {
        return zzg.zzbt();
    }

    static /* synthetic */ void zzc(zzdo zzdoVar, zzdd zzddVar) {
        zzddVar.getClass();
        zzhz<zzdd> zzhzVar = zzdoVar.zzf;
        if (!zzhzVar.zza()) {
            zzdoVar.zzf = zzhs.zzbF(zzhzVar);
        }
        zzdoVar.zzf.add(zzddVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zza", "zze", zzdn.zzb(), "zzf", zzdd.class});
        }
        if (i2 == 3) {
            return new zzdo();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzdk(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
