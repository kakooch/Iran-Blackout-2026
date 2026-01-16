package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: ir.nasim.qn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19703qn8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                latLng = (LatLng) SafeParcelReader.e(parcel, iT, LatLng.CREATOR);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                latLng2 = (LatLng) SafeParcelReader.e(parcel, iT, LatLng.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LatLngBounds(latLng, latLng2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
