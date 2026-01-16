package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public enum zzcc implements zzhu {
    UNKNOWN_COMPARISON_TYPE(0),
    LESS_THAN(1),
    GREATER_THAN(2),
    EQUAL(3),
    BETWEEN(4);

    private final int zzg;

    static {
        new Object() { // from class: com.google.android.gms.internal.measurement.zzca
        };
    }

    zzcc(int i) {
        this.zzg = i;
    }

    public static zzcc zza(int i) {
        if (i == 0) {
            return UNKNOWN_COMPARISON_TYPE;
        }
        if (i == 1) {
            return LESS_THAN;
        }
        if (i == 2) {
            return GREATER_THAN;
        }
        if (i == 3) {
            return EQUAL;
        }
        if (i != 4) {
            return null;
        }
        return BETWEEN;
    }

    public static zzhw zzb() {
        return zzcb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
