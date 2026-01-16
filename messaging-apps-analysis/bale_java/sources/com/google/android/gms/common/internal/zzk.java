package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new u();
    Bundle a;
    Feature[] b;
    int c;
    ConnectionTelemetryConfiguration d;

    zzk(Bundle bundle, Feature[] featureArr, int i, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.a = bundle;
        this.b = featureArr;
        this.c = i;
        this.d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.e(parcel, 1, this.a, false);
        AbstractC21804u96.w(parcel, 2, this.b, i, false);
        AbstractC21804u96.n(parcel, 3, this.c);
        AbstractC21804u96.s(parcel, 4, this.d, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
