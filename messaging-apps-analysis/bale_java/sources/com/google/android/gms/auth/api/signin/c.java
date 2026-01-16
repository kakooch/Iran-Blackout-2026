package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        Uri uri = null;
        String strF5 = null;
        String strF6 = null;
        ArrayList arrayListJ = null;
        String strF7 = null;
        String strF8 = null;
        long jX = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 4:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 5:
                    strF4 = SafeParcelReader.f(parcel, iT);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.e(parcel, iT, Uri.CREATOR);
                    break;
                case 7:
                    strF5 = SafeParcelReader.f(parcel, iT);
                    break;
                case 8:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 9:
                    strF6 = SafeParcelReader.f(parcel, iT);
                    break;
                case 10:
                    arrayListJ = SafeParcelReader.j(parcel, iT, Scope.CREATOR);
                    break;
                case 11:
                    strF7 = SafeParcelReader.f(parcel, iT);
                    break;
                case 12:
                    strF8 = SafeParcelReader.f(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new GoogleSignInAccount(iV, strF, strF2, strF3, strF4, uri, strF5, jX, strF6, arrayListJ, strF7, strF8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
