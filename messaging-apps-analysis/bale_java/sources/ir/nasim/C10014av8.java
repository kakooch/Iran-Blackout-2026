package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.StreetViewSource;

/* renamed from: ir.nasim.av8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10014av8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            if (SafeParcelReader.l(iT) != 2) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new StreetViewSource(iV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewSource[i];
    }
}
