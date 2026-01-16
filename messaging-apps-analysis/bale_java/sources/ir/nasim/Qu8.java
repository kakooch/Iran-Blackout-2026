package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;

/* loaded from: classes3.dex */
public final class Qu8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        int iV = 0;
        int iV2 = 0;
        boolean zM = false;
        int iV3 = 0;
        boolean zM2 = true;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 3:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 4:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 5:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
                case 6:
                    strF3 = SafeParcelReader.f(parcel, iT);
                    break;
                case 7:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 8:
                    strF4 = SafeParcelReader.f(parcel, iT);
                    break;
                case 9:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 10:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzr(strF, iV, iV2, strF2, strF3, zM2, strF4, zM, iV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
