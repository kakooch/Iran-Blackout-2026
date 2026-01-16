package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class Sl8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        boolean zM = false;
        long jX = 0;
        long jX2 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL == 2) {
                jX2 = SafeParcelReader.x(parcel, iT);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                jX = SafeParcelReader.x(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzc(zM, jX, jX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
