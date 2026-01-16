package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        byte bO = -1;
        byte bO2 = -1;
        byte bO3 = -1;
        byte bO4 = -1;
        byte bO5 = -1;
        byte bO6 = -1;
        byte bO7 = -1;
        byte bO8 = -1;
        byte bO9 = -1;
        byte bO10 = -1;
        byte bO11 = -1;
        byte bO12 = -1;
        int iV = 0;
        CameraPosition cameraPosition = null;
        Float fS = null;
        Float fS2 = null;
        LatLngBounds latLngBounds = null;
        Integer numW = null;
        String strF = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    bO = SafeParcelReader.o(parcel, iT);
                    break;
                case 3:
                    bO2 = SafeParcelReader.o(parcel, iT);
                    break;
                case 4:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.e(parcel, iT, CameraPosition.CREATOR);
                    break;
                case 6:
                    bO3 = SafeParcelReader.o(parcel, iT);
                    break;
                case 7:
                    bO4 = SafeParcelReader.o(parcel, iT);
                    break;
                case 8:
                    bO5 = SafeParcelReader.o(parcel, iT);
                    break;
                case 9:
                    bO6 = SafeParcelReader.o(parcel, iT);
                    break;
                case 10:
                    bO7 = SafeParcelReader.o(parcel, iT);
                    break;
                case 11:
                    bO8 = SafeParcelReader.o(parcel, iT);
                    break;
                case 12:
                    bO9 = SafeParcelReader.o(parcel, iT);
                    break;
                case 13:
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
                case 14:
                    bO10 = SafeParcelReader.o(parcel, iT);
                    break;
                case 15:
                    bO11 = SafeParcelReader.o(parcel, iT);
                    break;
                case 16:
                    fS = SafeParcelReader.s(parcel, iT);
                    break;
                case 17:
                    fS2 = SafeParcelReader.s(parcel, iT);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.e(parcel, iT, LatLngBounds.CREATOR);
                    break;
                case 19:
                    bO12 = SafeParcelReader.o(parcel, iT);
                    break;
                case 20:
                    numW = SafeParcelReader.w(parcel, iT);
                    break;
                case 21:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new GoogleMapOptions(bO, bO2, iV, cameraPosition, bO3, bO4, bO5, bO6, bO7, bO8, bO9, bO10, bO11, fS, fS2, latLngBounds, bO12, numW, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
