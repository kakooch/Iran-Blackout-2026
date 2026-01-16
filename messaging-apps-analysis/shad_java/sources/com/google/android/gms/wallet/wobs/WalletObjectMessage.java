package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class WalletObjectMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WalletObjectMessage> CREATOR = new zzn();
    String zzgc;
    String zzgd;
    TimeInterval zzgh;

    @Deprecated
    UriData zzgi;

    @Deprecated
    UriData zzgj;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgd, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzgh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzgi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzgj, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    WalletObjectMessage(String str, String str2, TimeInterval timeInterval, UriData uriData, UriData uriData2) {
        this.zzgc = str;
        this.zzgd = str2;
        this.zzgh = timeInterval;
        this.zzgi = uriData;
        this.zzgj = uriData2;
    }
}
