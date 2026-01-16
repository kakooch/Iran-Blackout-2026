package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationSettingsStates;

/* renamed from: ir.nasim.ph8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19052ph8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        boolean zM = false;
        boolean zM2 = false;
        boolean zM3 = false;
        boolean zM4 = false;
        boolean zM5 = false;
        boolean zM6 = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 2:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 3:
                    zM3 = SafeParcelReader.m(parcel, iT);
                    break;
                case 4:
                    zM4 = SafeParcelReader.m(parcel, iT);
                    break;
                case 5:
                    zM5 = SafeParcelReader.m(parcel, iT);
                    break;
                case 6:
                    zM6 = SafeParcelReader.m(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationSettingsStates(zM, zM2, zM3, zM4, zM5, zM6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
