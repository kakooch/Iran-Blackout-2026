package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zag;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class Ff8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        ArrayList arrayListH = null;
        String strF = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                arrayListH = SafeParcelReader.h(parcel, iT);
            } else if (iL != 2) {
                SafeParcelReader.A(parcel, iT);
            } else {
                strF = SafeParcelReader.f(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zag(arrayListH, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zag[i];
    }
}
