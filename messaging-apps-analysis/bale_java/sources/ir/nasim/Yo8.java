package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzg;

/* loaded from: classes3.dex */
public final class Yo8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Status status = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            if (SafeParcelReader.l(iT) != 1) {
                SafeParcelReader.A(parcel, iT);
            } else {
                status = (Status) SafeParcelReader.e(parcel, iT, Status.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzg(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzg[i];
    }
}
