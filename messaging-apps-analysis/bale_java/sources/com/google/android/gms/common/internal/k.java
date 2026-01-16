package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        Scope[] scopeArr = null;
        int iV3 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                iV3 = SafeParcelReader.v(parcel, iT);
            } else if (iL == 3) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.i(parcel, iT, Scope.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zax(iV, iV3, iV2, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zax[i];
    }
}
