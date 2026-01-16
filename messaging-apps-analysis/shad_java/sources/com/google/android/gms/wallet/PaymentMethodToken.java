package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class PaymentMethodToken extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzx();
    private int zzds;
    private String zzdt;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzds);
        SafeParcelWriter.writeString(parcel, 3, this.zzdt, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    PaymentMethodToken(int i, String str) {
        this.zzds = i;
        this.zzdt = str;
    }

    private PaymentMethodToken() {
    }
}
