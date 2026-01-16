package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
@Deprecated
/* loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    private String name;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private boolean zzs;
    private String zzt;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzn, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzq, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzr, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzs);
        SafeParcelWriter.writeString(parcel, 12, this.zzt, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zza() {
    }

    zza(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.name = str;
        this.zzk = str2;
        this.zzl = str3;
        this.zzm = str4;
        this.zzn = str5;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = str8;
        this.zzr = str9;
        this.zzs = z;
        this.zzt = str10;
    }
}
