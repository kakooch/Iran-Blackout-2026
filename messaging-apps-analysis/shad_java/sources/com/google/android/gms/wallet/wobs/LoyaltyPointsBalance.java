package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class LoyaltyPointsBalance extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzi();
    String zzbr;
    int zzfw;
    String zzfx;
    double zzfy;
    long zzfz;
    int zzga;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzfw);
        SafeParcelWriter.writeString(parcel, 3, this.zzfx, false);
        SafeParcelWriter.writeDouble(parcel, 4, this.zzfy);
        SafeParcelWriter.writeString(parcel, 5, this.zzbr, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzfz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzga);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    LoyaltyPointsBalance(int i, String str, double d, String str2, long j, int i2) {
        this.zzfw = i;
        this.zzfx = str;
        this.zzfy = d;
        this.zzbr = str2;
        this.zzfz = j;
        this.zzga = i2;
    }

    LoyaltyPointsBalance() {
        this.zzga = -1;
        this.zzfw = -1;
        this.zzfy = -1.0d;
    }
}
