package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e();
    final int a;
    private final ConnectionResult b;
    private final zav c;

    zak(int i, ConnectionResult connectionResult, zav zavVar) {
        this.a = i;
        this.b = connectionResult;
        this.c = zavVar;
    }

    public final ConnectionResult P() {
        return this.b;
    }

    public final zav S() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.s(parcel, 2, this.b, i, false);
        AbstractC21804u96.s(parcel, 3, this.c, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
