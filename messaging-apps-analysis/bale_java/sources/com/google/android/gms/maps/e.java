package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String strF = null;
        LatLng latLng = null;
        Integer numW = null;
        StreetViewSource streetViewSource = null;
        byte bO = 0;
        byte bO2 = 0;
        byte bO3 = 0;
        byte bO4 = 0;
        byte bO5 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.e(parcel, iT, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.e(parcel, iT, LatLng.CREATOR);
                    break;
                case 5:
                    numW = SafeParcelReader.w(parcel, iT);
                    break;
                case 6:
                    bO = SafeParcelReader.o(parcel, iT);
                    break;
                case 7:
                    bO2 = SafeParcelReader.o(parcel, iT);
                    break;
                case 8:
                    bO3 = SafeParcelReader.o(parcel, iT);
                    break;
                case 9:
                    bO4 = SafeParcelReader.o(parcel, iT);
                    break;
                case 10:
                    bO5 = SafeParcelReader.o(parcel, iT);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.e(parcel, iT, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, strF, latLng, numW, bO, bO2, bO3, bO4, bO5, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
