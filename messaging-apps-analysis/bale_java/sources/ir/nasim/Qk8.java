package ir.nasim;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.zza;

/* loaded from: classes3.dex */
public final class Qk8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        PointF[] pointFArr = null;
        int iV = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 2) {
                pointFArr = (PointF[]) SafeParcelReader.i(parcel, iT, PointF.CREATOR);
            } else if (iL != 3) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zza(pointFArr, iV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
