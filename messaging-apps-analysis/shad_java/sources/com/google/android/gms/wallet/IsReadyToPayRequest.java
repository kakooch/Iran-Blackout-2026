package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class IsReadyToPayRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<IsReadyToPayRequest> CREATOR = new zzn();
    ArrayList<Integer> zzao;
    private String zzby;
    private String zzbz;
    ArrayList<Integer> zzca;
    boolean zzcb;
    private String zzcc;

    IsReadyToPayRequest() {
    }

    IsReadyToPayRequest(ArrayList<Integer> arrayList, String str, String str2, ArrayList<Integer> arrayList2, boolean z, String str3) {
        this.zzao = arrayList;
        this.zzby = str;
        this.zzbz = str2;
        this.zzca = arrayList2;
        this.zzcb = z;
        this.zzcc = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzao, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzby, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbz, false);
        SafeParcelWriter.writeIntegerList(parcel, 6, this.zzca, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzcb);
        SafeParcelWriter.writeString(parcel, 8, this.zzcc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public static IsReadyToPayRequest fromJson(String str) {
        Builder builderNewBuilder = newBuilder();
        IsReadyToPayRequest.this.zzcc = (String) Preconditions.checkNotNull(str, "isReadyToPayRequestJson cannot be null!");
        return builderNewBuilder.build();
    }

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    @Deprecated
    public final class Builder {
        private Builder() {
        }

        public final IsReadyToPayRequest build() {
            return IsReadyToPayRequest.this;
        }
    }

    @Deprecated
    public static Builder newBuilder() {
        return new Builder();
    }
}
