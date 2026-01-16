package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;

/* loaded from: classes3.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new j();
    final int a;
    final IBinder b;
    private final ConnectionResult c;
    private final boolean d;
    private final boolean e;

    zav(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public final ConnectionResult P() {
        return this.c;
    }

    public final e S() {
        IBinder iBinder = this.b;
        if (iBinder == null) {
            return null;
        }
        return e.a.C2(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.c.equals(zavVar.c) && DG4.a(S(), zavVar.S());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.m(parcel, 2, this.b, false);
        AbstractC21804u96.s(parcel, 3, this.c, i, false);
        AbstractC21804u96.c(parcel, 4, this.d);
        AbstractC21804u96.c(parcel, 5, this.e);
        AbstractC21804u96.b(parcel, iA);
    }
}
