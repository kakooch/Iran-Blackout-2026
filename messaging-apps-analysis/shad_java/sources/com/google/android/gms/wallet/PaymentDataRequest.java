package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class PaymentDataRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PaymentDataRequest> CREATOR = new zzw();
    ArrayList<Integer> zzca;
    String zzcc;
    private Bundle zzdh;
    boolean zzdj;
    boolean zzdk;
    CardRequirements zzdl;
    boolean zzdm;
    ShippingAddressRequirements zzdn;
    PaymentMethodTokenizationParameters zzdo;
    TransactionInfo zzdp;
    boolean zzdq;

    PaymentDataRequest(boolean z, boolean z2, CardRequirements cardRequirements, boolean z3, ShippingAddressRequirements shippingAddressRequirements, ArrayList<Integer> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, TransactionInfo transactionInfo, boolean z4, String str, Bundle bundle) {
        this.zzdj = z;
        this.zzdk = z2;
        this.zzdl = cardRequirements;
        this.zzdm = z3;
        this.zzdn = shippingAddressRequirements;
        this.zzca = arrayList;
        this.zzdo = paymentMethodTokenizationParameters;
        this.zzdp = transactionInfo;
        this.zzdq = z4;
        this.zzcc = str;
        this.zzdh = bundle;
    }

    private PaymentDataRequest() {
        this.zzdq = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdj);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdk);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdl, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdm);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzdn, i, false);
        SafeParcelWriter.writeIntegerList(parcel, 6, this.zzca, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdp, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdq);
        SafeParcelWriter.writeString(parcel, 10, this.zzcc, false);
        SafeParcelWriter.writeBundle(parcel, 11, this.zzdh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    @Deprecated
    public final class Builder {
        private Builder() {
        }

        public final PaymentDataRequest build() {
            PaymentDataRequest paymentDataRequest = PaymentDataRequest.this;
            if (paymentDataRequest.zzcc == null) {
                Preconditions.checkNotNull(paymentDataRequest.zzca, "Allowed payment methods must be set! You can set it through addAllowedPaymentMethod() or addAllowedPaymentMethods() in the PaymentDataRequest Builder.");
                Preconditions.checkNotNull(PaymentDataRequest.this.zzdl, "Card requirements must be set!");
                PaymentDataRequest paymentDataRequest2 = PaymentDataRequest.this;
                if (paymentDataRequest2.zzdo != null) {
                    Preconditions.checkNotNull(paymentDataRequest2.zzdp, "Transaction info must be set if paymentMethodTokenizationParameters is set!");
                }
            }
            return PaymentDataRequest.this;
        }
    }

    @Deprecated
    public static Builder newBuilder() {
        return new Builder();
    }

    public static PaymentDataRequest fromJson(String str) {
        Builder builderNewBuilder = newBuilder();
        PaymentDataRequest.this.zzcc = (String) Preconditions.checkNotNull(str, "paymentDataRequestJson cannot be null!");
        return builderNewBuilder.build();
    }
}
