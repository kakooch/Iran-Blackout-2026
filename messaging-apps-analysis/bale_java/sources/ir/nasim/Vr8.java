package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;

/* loaded from: classes3.dex */
public final class Vr8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        float fR = 0.0f;
        float fR2 = 0.0f;
        int iV2 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                fR = SafeParcelReader.r(parcel, iT);
            } else if (iL == 3) {
                fR2 = SafeParcelReader.r(parcel, iT);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV2 = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LandmarkParcel(iV, fR, fR2, iV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LandmarkParcel[i];
    }
}
