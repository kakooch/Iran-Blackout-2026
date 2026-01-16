package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: ir.nasim.eo8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12558eo8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        double dP = 0.0d;
        double dP2 = 0.0d;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                dP = SafeParcelReader.p(parcel, iT);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                dP2 = SafeParcelReader.p(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LatLng(dP, dP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LatLng[i];
    }
}
