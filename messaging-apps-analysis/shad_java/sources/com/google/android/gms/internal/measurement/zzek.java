package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzek extends zzff {
    private final Context zza;
    private final zzfo<zzfm<zzev>> zzb;

    zzek(Context context, zzfo<zzfm<zzev>> zzfoVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zzfoVar;
    }

    public final boolean equals(Object obj) {
        zzfo<zzfm<zzev>> zzfoVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzff) {
            zzff zzffVar = (zzff) obj;
            if (this.zza.equals(zzffVar.zza()) && ((zzfoVar = this.zzb) != null ? zzfoVar.equals(zzffVar.zzb()) : zzffVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzfo<zzfm<zzev>> zzfoVar = this.zzb;
        return iHashCode ^ (zzfoVar == null ? 0 : zzfoVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        String strValueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 46 + strValueOf2.length());
        sb.append("FlagsContext{context=");
        sb.append(strValueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzff
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzff
    final zzfo<zzfm<zzev>> zzb() {
        return this.zzb;
    }
}
