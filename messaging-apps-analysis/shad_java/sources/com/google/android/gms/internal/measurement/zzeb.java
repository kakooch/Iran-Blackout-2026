package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzeb extends zzhs<zzeb, zzea> implements zziy {
    private static final zzeb zzg;
    private int zza;
    private zzhz<zzeg> zze = zzhs.zzbE();
    private zzdx zzf;

    static {
        zzeb zzebVar = new zzeb();
        zzg = zzebVar;
        zzhs.zzby(zzeb.class, zzebVar);
    }

    private zzeb() {
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zze", zzeg.class, "zzf"});
        }
        if (i2 == 3) {
            return new zzeb();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzea(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
