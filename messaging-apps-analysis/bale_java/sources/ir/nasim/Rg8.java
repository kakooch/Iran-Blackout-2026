package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes3.dex */
public final class Rg8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        LatLng latLng = null;
        float fR = 0.0f;
        float fR2 = 0.0f;
        float fR3 = 0.0f;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                latLng = (LatLng) SafeParcelReader.e(parcel, iT, LatLng.CREATOR);
            } else if (iL == 3) {
                fR = SafeParcelReader.r(parcel, iT);
            } else if (iL == 4) {
                fR2 = SafeParcelReader.r(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                fR3 = SafeParcelReader.r(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new CameraPosition(latLng, fR, fR2, fR3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CameraPosition[i];
    }
}
