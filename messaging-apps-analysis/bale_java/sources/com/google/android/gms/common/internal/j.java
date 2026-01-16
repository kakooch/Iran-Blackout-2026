package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        boolean zM = false;
        boolean zM2 = false;
        IBinder iBinderU = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                iBinderU = SafeParcelReader.u(parcel, iT);
            } else if (iL == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.e(parcel, iT, ConnectionResult.CREATOR);
            } else if (iL == 4) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                zM2 = SafeParcelReader.m(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zav(iV, iBinderU, connectionResult, zM, zM2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zav[i];
    }
}
