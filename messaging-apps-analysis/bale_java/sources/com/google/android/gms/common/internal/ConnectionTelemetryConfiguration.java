package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Xr8;

/* loaded from: classes3.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new Xr8();
    private final RootTelemetryConfiguration a;
    private final boolean b;
    private final boolean c;
    private final int[] d;
    private final int e;
    private final int[] f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.a = rootTelemetryConfiguration;
        this.b = z;
        this.c = z2;
        this.d = iArr;
        this.e = i;
        this.f = iArr2;
    }

    public final RootTelemetryConfiguration A0() {
        return this.a;
    }

    public int P() {
        return this.e;
    }

    public int[] S() {
        return this.d;
    }

    public int[] d0() {
        return this.f;
    }

    public boolean s0() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 1, this.a, i, false);
        AbstractC21804u96.c(parcel, 2, s0());
        AbstractC21804u96.c(parcel, 3, x0());
        AbstractC21804u96.o(parcel, 4, S(), false);
        AbstractC21804u96.n(parcel, 5, P());
        AbstractC21804u96.o(parcel, 6, d0(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    public boolean x0() {
        return this.c;
    }
}
