package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class TransactionInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TransactionInfo> CREATOR = new zzai();
    int zzee;
    String zzef;
    String zzeg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzee);
        SafeParcelWriter.writeString(parcel, 2, this.zzef, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzeg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public TransactionInfo(int i, String str, String str2) {
        this.zzee = i;
        this.zzef = str;
        this.zzeg = str2;
    }

    private TransactionInfo() {
    }
}
