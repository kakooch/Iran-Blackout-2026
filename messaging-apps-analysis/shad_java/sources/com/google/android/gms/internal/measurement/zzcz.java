package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzcz extends zzhs<zzcz, zzcy> implements zziy {
    private static final zzcz zzg;
    private int zza;
    private int zze;
    private long zzf;

    static {
        zzcz zzczVar = new zzcz();
        zzg = zzczVar;
        zzhs.zzby(zzcz.class, zzczVar);
    }

    private zzcz() {
    }

    public static zzcy zze() {
        return zzg.zzbt();
    }

    static /* synthetic */ void zzg(zzcz zzczVar, int i) {
        zzczVar.zza |= 1;
        zzczVar.zze = i;
    }

    static /* synthetic */ void zzh(zzcz zzczVar, long j) {
        zzczVar.zza |= 2;
        zzczVar.zzf = j;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzcz();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzcy(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
