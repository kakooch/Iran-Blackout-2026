package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strF2 = "";
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 4) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.e(parcel, iT, GoogleSignInAccount.CREATOR);
            } else if (iL != 8) {
                SafeParcelReader.A(parcel, iT);
            } else {
                strF2 = SafeParcelReader.f(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new SignInAccount(strF, googleSignInAccount, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
