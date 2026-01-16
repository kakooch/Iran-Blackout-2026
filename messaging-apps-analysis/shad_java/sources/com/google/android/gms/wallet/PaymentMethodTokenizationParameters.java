package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class PaymentMethodTokenizationParameters extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PaymentMethodTokenizationParameters> CREATOR = new zzz();
    int zzds;
    Bundle zzdu;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzds);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzdu, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    PaymentMethodTokenizationParameters(int i, Bundle bundle) {
        this.zzdu = new Bundle();
        this.zzds = i;
        this.zzdu = bundle;
    }

    private PaymentMethodTokenizationParameters() {
        this.zzdu = new Bundle();
    }
}
