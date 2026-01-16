package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 1000;
        int iV2 = 1;
        int iV3 = 1;
        long jX = 0;
        zzac[] zzacVarArr = null;
        boolean zM = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 3:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 4:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 5:
                    zzacVarArr = (zzac[]) SafeParcelReader.i(parcel, iT, zzac.CREATOR);
                    break;
                case 6:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationAvailability(iV, iV2, iV3, jX, zzacVarArr, zM);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
