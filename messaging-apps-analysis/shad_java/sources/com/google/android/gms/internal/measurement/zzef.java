package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public enum zzef implements zzhu {
    UNKNOWN(0),
    STRING(1),
    NUMBER(2),
    BOOLEAN(3),
    STATEMENT(4);

    private final int zzg;

    static {
        new Object() { // from class: com.google.android.gms.internal.measurement.zzed
        };
    }

    zzef(int i) {
        this.zzg = i;
    }

    public static zzef zza(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return STRING;
        }
        if (i == 2) {
            return NUMBER;
        }
        if (i == 3) {
            return BOOLEAN;
        }
        if (i != 4) {
            return null;
        }
        return STATEMENT;
    }

    public static zzhw zzb() {
        return zzee.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzef.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
    }
}
