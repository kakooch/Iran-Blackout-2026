package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class Mf8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        int iV3 = 0;
        int iV4 = 0;
        long jX = 0;
        long jX2 = 0;
        String strF = null;
        String strF2 = null;
        int iV5 = -1;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 3:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 4:
                    jX = SafeParcelReader.x(parcel, iT);
                    break;
                case 5:
                    jX2 = SafeParcelReader.x(parcel, iT);
                    break;
                case 6:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 7:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 8:
                    iV4 = SafeParcelReader.v(parcel, iT);
                    break;
                case 9:
                    iV5 = SafeParcelReader.v(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new MethodInvocation(iV, iV2, iV3, jX, jX2, strF, strF2, iV4, iV5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MethodInvocation[i];
    }
}
