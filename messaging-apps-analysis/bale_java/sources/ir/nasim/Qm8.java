package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.zzf;

/* loaded from: classes3.dex */
public final class Qm8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        int iV2 = 0;
        int iV3 = 0;
        boolean zM = false;
        boolean zM2 = false;
        float fR = -1.0f;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 2:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 3:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 4:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 5:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 6:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 7:
                    fR = SafeParcelReader.r(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzf(iV, iV2, iV3, zM, zM2, fR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }
}
