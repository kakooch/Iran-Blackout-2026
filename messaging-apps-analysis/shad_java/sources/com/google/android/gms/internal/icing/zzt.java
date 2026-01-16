package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzv();
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private final int zzd;
    private final boolean zze;
    private final String zzf;
    private final zzm[] zzg;
    private final String zzh;
    private final zzu zzi;

    zzt(String str, String str2, boolean z, int i, boolean z2, String str3, zzm[] zzmVarArr, String str4, zzu zzuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = i;
        this.zze = z2;
        this.zzf = str3;
        this.zzg = zzmVarArr;
        this.zzh = str4;
        this.zzi = zzuVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(Arrays.hashCode(this.zzg)), this.zzh, this.zzi);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zztVar = (zzt) obj;
        return this.zzc == zztVar.zzc && this.zzd == zztVar.zzd && this.zze == zztVar.zze && Objects.equal(this.zza, zztVar.zza) && Objects.equal(this.zzb, zztVar.zzb) && Objects.equal(this.zzf, zztVar.zzf) && Objects.equal(this.zzh, zztVar.zzh) && Objects.equal(this.zzi, zztVar.zzi) && Arrays.equals(this.zzg, zztVar.zzg);
    }
}
