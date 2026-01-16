package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        ConnectionResult connectionResult = null;
        int iV = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.e(parcel, iT, PendingIntent.CREATOR);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                connectionResult = (ConnectionResult) SafeParcelReader.e(parcel, iT, ConnectionResult.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new Status(iV, strF, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
