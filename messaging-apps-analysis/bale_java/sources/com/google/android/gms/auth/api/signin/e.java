package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        boolean zM = false;
        boolean zM2 = false;
        boolean zM3 = false;
        ArrayList arrayListJ = null;
        Account account = null;
        String strF = null;
        String strF2 = null;
        ArrayList arrayListJ2 = null;
        String strF3 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    arrayListJ = SafeParcelReader.j(parcel, iT, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.e(parcel, iT, Account.CREATOR);
                    break;
                case 4:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 5:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 6:
                    zM3 = SafeParcelReader.m(parcel, iT);
                    break;
                case 7:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 8:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 9:
                    arrayListJ2 = SafeParcelReader.j(parcel, iT, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new GoogleSignInOptions(iV, arrayListJ, account, zM, zM2, zM3, strF, strF2, arrayListJ2, strF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
