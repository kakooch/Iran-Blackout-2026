package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdx extends zzhs<zzdx, zzdw> implements zziy {
    private static final zzdx zze;
    private zzhz<zzdz> zza = zzhs.zzbE();

    static {
        zzdx zzdxVar = new zzdx();
        zze = zzdxVar;
        zzhs.zzby(zzdx.class, zzdxVar);
    }

    private zzdx() {
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdz.class});
        }
        if (i2 == 3) {
            return new zzdx();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzdw(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zze;
    }
}
