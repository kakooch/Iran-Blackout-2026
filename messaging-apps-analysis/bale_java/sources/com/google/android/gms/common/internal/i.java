package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iV2 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                account = (Account) SafeParcelReader.e(parcel, iT, Account.CREATOR);
            } else if (iL == 3) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.e(parcel, iT, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zat(iV, account, iV2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zat[i];
    }
}
