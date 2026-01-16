package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        List listJ = LocationResult.b;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            if (SafeParcelReader.l(iT) != 1) {
                SafeParcelReader.A(parcel, iT);
            } else {
                listJ = SafeParcelReader.j(parcel, iT, Location.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationResult(listJ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationResult[i];
    }
}
