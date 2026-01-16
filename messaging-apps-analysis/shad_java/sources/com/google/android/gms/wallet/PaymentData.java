package com.google.android.gms.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.identity.intents.model.UserAddress;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class PaymentData extends AbstractSafeParcelable implements AutoResolvableResult {
    public static final Parcelable.Creator<PaymentData> CREATOR = new zzu();
    private String zzbc;
    private String zzbf;
    private PaymentMethodToken zzbm;
    private String zzcc;
    private CardInfo zzde;
    private UserAddress zzdf;
    private Bundle zzdg;
    private Bundle zzdh;

    PaymentData(String str, CardInfo cardInfo, UserAddress userAddress, PaymentMethodToken paymentMethodToken, String str2, Bundle bundle, String str3, Bundle bundle2) {
        this.zzbf = str;
        this.zzde = cardInfo;
        this.zzdf = userAddress;
        this.zzbm = paymentMethodToken;
        this.zzbc = str2;
        this.zzdg = bundle;
        this.zzcc = str3;
        this.zzdh = bundle2;
    }

    private PaymentData() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbf, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzde, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbm, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbc, false);
        SafeParcelWriter.writeBundle(parcel, 6, this.zzdg, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcc, false);
        SafeParcelWriter.writeBundle(parcel, 8, this.zzdh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String toJson() {
        return this.zzcc;
    }

    public static PaymentData getFromIntent(Intent intent) {
        return (PaymentData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.wallet.PaymentData", CREATOR);
    }

    @Override // com.google.android.gms.wallet.AutoResolvableResult
    public final void putIntoIntent(Intent intent) {
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.gms.wallet.PaymentData");
    }
}
