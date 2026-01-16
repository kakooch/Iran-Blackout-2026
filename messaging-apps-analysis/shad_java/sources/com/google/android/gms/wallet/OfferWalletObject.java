package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class OfferWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzs();
    private final int versionCode;
    CommonWalletObject zzbn;
    String zzce;
    String zzdc;

    public final int getVersionCode() {
        return this.versionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    OfferWalletObject(int i, String str, String str2, CommonWalletObject commonWalletObject) {
        this.versionCode = i;
        this.zzdc = str2;
        if (i < 3) {
            this.zzbn = CommonWalletObject.zzg().zza(str).zzh();
        } else {
            this.zzbn = commonWalletObject;
        }
    }

    OfferWalletObject() {
        this.versionCode = 3;
    }
}
