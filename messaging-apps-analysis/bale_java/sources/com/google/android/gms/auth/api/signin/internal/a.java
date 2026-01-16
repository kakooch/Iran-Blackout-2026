package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        Bundle bundleA = null;
        int iV2 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                bundleA = SafeParcelReader.a(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new GoogleSignInOptionsExtensionParcelable(iV, iV2, bundleA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
