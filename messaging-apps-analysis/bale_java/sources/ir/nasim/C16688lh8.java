package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;

/* renamed from: ir.nasim.lh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16688lh8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                status = (Status) SafeParcelReader.e(parcel, iT, Status.CREATOR);
            } else if (iL != 2) {
                SafeParcelReader.A(parcel, iT);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.e(parcel, iT, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
