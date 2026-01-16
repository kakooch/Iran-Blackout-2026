package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: ir.nasim.ei8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12498ei8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        int iV = 0;
        boolean zM = false;
        boolean zM2 = false;
        int iV2 = 0;
        int iV3 = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL == 2) {
                zM = SafeParcelReader.m(parcel, iT);
            } else if (iL == 3) {
                zM2 = SafeParcelReader.m(parcel, iT);
            } else if (iL == 4) {
                iV2 = SafeParcelReader.v(parcel, iT);
            } else if (iL != 5) {
                SafeParcelReader.A(parcel, iT);
            } else {
                iV3 = SafeParcelReader.v(parcel, iT);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new RootTelemetryConfiguration(iV, zM, zM2, iV2, iV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
