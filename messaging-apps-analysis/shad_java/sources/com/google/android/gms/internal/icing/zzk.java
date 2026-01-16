package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public final int zza;
    private final String zzd;
    private final zzt zze;
    private final byte[] zzf;
    private static final int zzb = Integer.parseInt("-1");
    public static final Parcelable.Creator<zzk> CREATOR = new zzn();

    zzk(String str, zzt zztVar, int i, byte[] bArr) {
        String string;
        int i2 = zzb;
        boolean z = i == i2 || zzq.zza(i) != null;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i);
        Preconditions.checkArgument(z, sb.toString());
        this.zzd = str;
        this.zze = zztVar;
        this.zza = i;
        this.zzf = bArr;
        if (i == i2 || zzq.zza(i) != null) {
            string = (str == null || bArr == null) ? null : "Both content and blobContent set";
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid section type ");
            sb2.append(i);
            string = sb2.toString();
        }
        if (string != null) {
            throw new IllegalArgumentException(string);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    static {
        new zzs("SsbContext").zza(true).zza("blob").zza();
    }
}
