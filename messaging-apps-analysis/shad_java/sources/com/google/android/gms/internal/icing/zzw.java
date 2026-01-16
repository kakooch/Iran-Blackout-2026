package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzy();
    private final zzi zza;
    private final long zzb;
    private int zzc;
    private final String zzd;
    private final zzh zze;
    private final boolean zzf;
    private int zzg;
    private int zzh;
    private final String zzi;

    zzw(zzi zziVar, long j, int i, String str, zzh zzhVar, boolean z, int i2, int i3, String str2) {
        this.zza = zziVar;
        this.zzb = j;
        this.zzc = i;
        this.zzd = str;
        this.zze = zzhVar;
        this.zzf = z;
        this.zzg = i2;
        this.zzh = i3;
        this.zzi = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzh));
    }
}
