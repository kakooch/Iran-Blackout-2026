package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.identity.intents.model.UserAddress;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class FullWallet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new zzi();
    private String zzbc;
    private String zzbd;
    private zzae zzbe;
    private String zzbf;
    private zza zzbg;
    private zza zzbh;
    private String[] zzbi;
    private UserAddress zzbj;
    private UserAddress zzbk;
    private InstrumentInfo[] zzbl;
    private PaymentMethodToken zzbm;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbd, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbe, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbf, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzbg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzbh, i, false);
        SafeParcelWriter.writeStringArray(parcel, 8, this.zzbi, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzbj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzbk, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzbl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzbm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    FullWallet(String str, String str2, zzae zzaeVar, String str3, zza zzaVar, zza zzaVar2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr, PaymentMethodToken paymentMethodToken) {
        this.zzbc = str;
        this.zzbd = str2;
        this.zzbe = zzaeVar;
        this.zzbf = str3;
        this.zzbg = zzaVar;
        this.zzbh = zzaVar2;
        this.zzbi = strArr;
        this.zzbj = userAddress;
        this.zzbk = userAddress2;
        this.zzbl = instrumentInfoArr;
        this.zzbm = paymentMethodToken;
    }

    private FullWallet() {
    }
}
