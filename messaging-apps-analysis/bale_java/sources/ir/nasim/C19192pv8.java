package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.vision.zzs;

/* renamed from: ir.nasim.pv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19192pv8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        int iV3 = 0;
        int iV4 = 0;
        long jX = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 3) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL == 4) {
                iV3 = SafeParcelReader.v(parcel, iT);
            } else if (iL == 5) {
                jX = SafeParcelReader.x(parcel, iT);
            } else if (iL != 6) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV4 = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzs(iV, iV2, iV3, jX, iV4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
