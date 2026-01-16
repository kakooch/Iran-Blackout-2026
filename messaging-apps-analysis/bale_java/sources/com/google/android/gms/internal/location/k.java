package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        LocationRequest locationRequest = null;
        ArrayList arrayListJ = null;
        String strF = null;
        String strF2 = null;
        boolean zM = false;
        boolean zM2 = false;
        boolean zM3 = false;
        boolean zM4 = false;
        long jX = Long.MAX_VALUE;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.e(parcel, iT, LocationRequest.CREATOR);
            } else if (iL != 5) {
                switch (iL) {
                    case 8:
                        zM = SafeParcelReader.m(parcel, iT);
                        break;
                    case 9:
                        zM2 = SafeParcelReader.m(parcel, iT);
                        break;
                    case 10:
                        strF = SafeParcelReader.f(parcel, iT);
                        break;
                    case 11:
                        zM3 = SafeParcelReader.m(parcel, iT);
                        break;
                    case 12:
                        zM4 = SafeParcelReader.m(parcel, iT);
                        break;
                    case 13:
                        strF2 = SafeParcelReader.f(parcel, iT);
                        break;
                    case 14:
                        jX = SafeParcelReader.x(parcel, iT);
                        break;
                    default:
                        SafeParcelReader.A(parcel, iT);
                        break;
                }
            } else {
                arrayListJ = SafeParcelReader.j(parcel, iT, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzdd(locationRequest, arrayListJ, zM, zM2, strF, zM3, zM4, strF2, jX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdd[i];
    }
}
