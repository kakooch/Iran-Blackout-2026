package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.identity.intents.model.UserAddress;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class CardInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CardInfo> CREATOR = new zzc();
    private String zzaj;
    private String zzak;
    private String zzal;
    private int zzam;
    private UserAddress zzan;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzaj, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzak, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzal, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzam);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzan, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    CardInfo(String str, String str2, String str3, int i, UserAddress userAddress) {
        this.zzaj = str;
        this.zzak = str2;
        this.zzal = str3;
        this.zzam = i;
        this.zzan = userAddress;
    }

    private CardInfo() {
    }
}
