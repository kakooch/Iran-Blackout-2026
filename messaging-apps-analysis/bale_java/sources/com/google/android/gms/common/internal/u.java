package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Bundle bundleA = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iV = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            int iL = SafeParcelReader.l(iT);
            if (iL == 1) {
                bundleA = SafeParcelReader.a(parcel, iT);
            } else if (iL == 2) {
                featureArr = (Feature[]) SafeParcelReader.i(parcel, iT, Feature.CREATOR);
            } else if (iL == 3) {
                iV = SafeParcelReader.v(parcel, iT);
            } else if (iL != 4) {
                SafeParcelReader.A(parcel, iT);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.e(parcel, iT, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new zzk(bundleA, featureArr, iV, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }
}
