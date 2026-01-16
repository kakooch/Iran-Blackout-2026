package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.identity.intents.model.UserAddress;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class MaskedWallet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzq();
    private String zzbc;
    private String zzbd;
    private String zzbf;
    private zza zzbg;
    private zza zzbh;
    private String[] zzbi;
    private UserAddress zzbj;
    private UserAddress zzbk;
    private InstrumentInfo[] zzbl;
    private LoyaltyWalletObject[] zzda;
    private OfferWalletObject[] zzdb;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbd, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.zzbi, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbf, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzbg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzbh, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzda, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzdb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzbj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbk, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 12, this.zzbl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    MaskedWallet(String str, String str2, String[] strArr, String str3, zza zzaVar, zza zzaVar2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.zzbc = str;
        this.zzbd = str2;
        this.zzbi = strArr;
        this.zzbf = str3;
        this.zzbg = zzaVar;
        this.zzbh = zzaVar2;
        this.zzda = loyaltyWalletObjectArr;
        this.zzdb = offerWalletObjectArr;
        this.zzbj = userAddress;
        this.zzbk = userAddress2;
        this.zzbl = instrumentInfoArr;
    }

    private MaskedWallet() {
    }
}
