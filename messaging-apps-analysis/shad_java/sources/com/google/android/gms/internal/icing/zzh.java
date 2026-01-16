package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzj();
    private final zzk[] zza;
    private final String zzb;
    private final boolean zzc;
    private final Account zzd;

    zzh(zzk[] zzkVarArr, String str, boolean z, Account account) {
        this.zza = zzkVarArr;
        this.zzb = str;
        this.zzc = z;
        this.zzd = account;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Boolean.valueOf(this.zzc), this.zzd, Integer.valueOf(Arrays.hashCode(this.zza)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzhVar = (zzh) obj;
            if (Objects.equal(this.zzb, zzhVar.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzhVar.zzc)) && Objects.equal(this.zzd, zzhVar.zzd) && Arrays.equals(this.zza, zzhVar.zza)) {
                return true;
            }
        }
        return false;
    }
}
