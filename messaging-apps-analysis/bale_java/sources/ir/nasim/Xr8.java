package ir.nasim;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class Xr8 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrD = null;
        int[] iArrD2 = null;
        boolean zM = false;
        boolean zM2 = false;
        int iV = 0;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.e(parcel, iT, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 3:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 4:
                    iArrD = SafeParcelReader.d(parcel, iT);
                    break;
                case 5:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 6:
                    iArrD2 = SafeParcelReader.d(parcel, iT);
                    break;
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zM, zM2, iArrD, iV, iArrD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
