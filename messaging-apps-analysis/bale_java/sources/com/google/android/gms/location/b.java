package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

/* loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        long jX = Long.MAX_VALUE;
        int iV = 0;
        boolean zM = false;
        String strF = null;
        zzd zzdVar = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                jX = SafeParcelReader.x(parcel, iT);
            } else if (iL == 2) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 3) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL == 4) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                zzdVar = (zzd) SafeParcelReader.e(parcel, iT, zzd.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LastLocationRequest(jX, iV, zM, strF, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LastLocationRequest[i];
    }
}
