package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C12498ei8;

/* loaded from: classes3.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new C12498ei8();
    private final int a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final int e;

    public RootTelemetryConfiguration(int i, boolean z, boolean z2, int i2, int i3) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = i2;
        this.e = i3;
    }

    public int P() {
        return this.d;
    }

    public int S() {
        return this.e;
    }

    public boolean d0() {
        return this.b;
    }

    public boolean s0() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, x0());
        AbstractC21804u96.c(parcel, 2, d0());
        AbstractC21804u96.c(parcel, 3, s0());
        AbstractC21804u96.n(parcel, 4, P());
        AbstractC21804u96.n(parcel, 5, S());
        AbstractC21804u96.b(parcel, iA);
    }

    public int x0() {
        return this.a;
    }
}
