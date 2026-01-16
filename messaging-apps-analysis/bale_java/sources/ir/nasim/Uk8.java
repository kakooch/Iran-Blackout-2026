package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class Uk8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        long jX = -1;
        int iV = 0;
        String strF = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL == 2) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                jX = SafeParcelReader.x(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new Feature(strF, iV, jX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Feature[i];
    }
}
