package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        ArrayList arrayListJ = null;
        boolean zM = false;
        boolean zM2 = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                arrayListJ = SafeParcelReader.j(parcel, iT, LocationRequest.CREATOR);
            } else if (iL == 2) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                zM2 = SafeParcelReader.m(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationSettingsRequest(arrayListJ, zM, zM2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
