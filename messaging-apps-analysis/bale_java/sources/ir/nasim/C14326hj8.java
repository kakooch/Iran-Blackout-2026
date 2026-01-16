package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appset.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: ir.nasim.hj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14326hj8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        String strF = null;
        String strF2 = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                strF = SafeParcelReader.f(parcel, iT);
            } else if (iL != 2) {
                SafeParcelReader.A(parcel, iT);
            } else {
                strF2 = SafeParcelReader.f(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zza(strF, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
