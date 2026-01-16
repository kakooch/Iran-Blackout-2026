package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public enum zzdn implements zzhu {
    RADS(1),
    PROVISIONING(2);

    private final int zzd;

    static {
        new Object() { // from class: com.google.android.gms.internal.measurement.zzdl
        };
    }

    zzdn(int i) {
        this.zzd = i;
    }

    public static zzdn zza(int i) {
        if (i == 1) {
            return RADS;
        }
        if (i != 2) {
            return null;
        }
        return PROVISIONING;
    }

    public static zzhw zzb() {
        return zzdm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzdn.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
    }
}
