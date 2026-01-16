package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new t();
    private final boolean a;
    private final String b;
    private final int c;
    private final int d;

    zzq(boolean z, String str, int i, int i2) {
        this.a = z;
        this.b = str;
        this.c = x.a(i) - 1;
        this.d = h.a(i2) - 1;
    }

    public final String P() {
        return this.b;
    }

    public final boolean S() {
        return this.a;
    }

    public final int d0() {
        return h.a(this.d);
    }

    public final int s0() {
        return x.a(this.c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.c(parcel, 1, this.a);
        AbstractC21804u96.t(parcel, 2, this.b, false);
        AbstractC21804u96.n(parcel, 3, this.c);
        AbstractC21804u96.n(parcel, 4, this.d);
        AbstractC21804u96.b(parcel, iA);
    }
}
