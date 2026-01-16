package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfr<T> implements Serializable, zzfo {
    final T zza;

    zzfr(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfr)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzfr) obj).zza;
        return t == t2 || t.equals(t2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzfo
    public final T zza() {
        return this.zza;
    }
}
