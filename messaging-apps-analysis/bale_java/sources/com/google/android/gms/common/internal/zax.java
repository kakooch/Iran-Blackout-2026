package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new k();
    final int a;
    private final int b;
    private final int c;
    private final Scope[] d;

    zax(int i, int i2, int i3, Scope[] scopeArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.n(parcel, 3, this.c);
        AbstractC21804u96.w(parcel, 4, this.d, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
