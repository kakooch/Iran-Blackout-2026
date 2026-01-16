package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* loaded from: classes3.dex */
final class zzbd {
    final String zza;
    final byte[] zzb;

    zzbd(String str, byte[] bArr) {
        this.zza = str;
        this.zzb = bArr;
    }

    public final String toString() {
        String str = this.zza;
        int iHashCode = Arrays.hashCode(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(iHashCode);
        return sb.toString();
    }
}
