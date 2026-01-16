package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhd {
    private final Object zza;
    private final int zzb;

    zzhd(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhd)) {
            return false;
        }
        zzhd zzhdVar = (zzhd) obj;
        return this.zza == zzhdVar.zza && this.zzb == zzhdVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
