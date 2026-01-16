package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzcn extends zzhs<zzcn, zzcm> implements zziy {
    private static final zzcn zzi;
    private int zza;
    private String zze = BuildConfig.FLAVOR;
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzcn zzcnVar = new zzcn();
        zzi = zzcnVar;
        zzhs.zzby(zzcn.class, zzcnVar);
    }

    private zzcn() {
    }

    static /* synthetic */ void zzg(zzcn zzcnVar, String str) {
        str.getClass();
        zzcnVar.zza |= 1;
        zzcnVar.zze = str;
    }

    public final String zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        return (this.zza & 8) != 0;
    }

    public final int zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzcn();
        }
        zzcl zzclVar = null;
        if (i2 == 4) {
            return new zzcm(zzclVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzi;
    }
}
