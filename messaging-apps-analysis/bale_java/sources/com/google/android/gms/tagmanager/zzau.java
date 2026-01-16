package com.google.android.gms.tagmanager;

import ir.nasim.AbstractC3795Cj5;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class zzau {
    public final String zza;
    public final Object zzb;

    zzau(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzauVar = (zzau) obj;
        if (!this.zza.equals(zzauVar.zza)) {
            return false;
        }
        Object obj2 = this.zzb;
        if (obj2 == null && zzauVar.zzb == null) {
            return true;
        }
        return obj2 != null && obj2.equals(zzauVar.zzb);
    }

    public final int hashCode() {
        AbstractC3795Cj5.j(this.zzb);
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zza.hashCode()), Integer.valueOf(this.zzb.hashCode())});
    }

    public final String toString() {
        String str = this.zza;
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + strValueOf.length());
        sb.append("Key: ");
        sb.append(str);
        sb.append(" value: ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
