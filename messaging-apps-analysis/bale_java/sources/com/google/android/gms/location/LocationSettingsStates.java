package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C19052ph8;

/* loaded from: classes3.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new C19052ph8();
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
    }

    public boolean A0() {
        return this.b;
    }

    public boolean P() {
        return this.f;
    }

    public boolean S() {
        return this.c;
    }

    public boolean d0() {
        return this.d;
    }

    public boolean s0() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.c(parcel, 1, s0());
        AbstractC21804u96.c(parcel, 2, A0());
        AbstractC21804u96.c(parcel, 3, S());
        AbstractC21804u96.c(parcel, 4, d0());
        AbstractC21804u96.c(parcel, 5, x0());
        AbstractC21804u96.c(parcel, 6, P());
        AbstractC21804u96.b(parcel, iA);
    }

    public boolean x0() {
        return this.e;
    }
}
