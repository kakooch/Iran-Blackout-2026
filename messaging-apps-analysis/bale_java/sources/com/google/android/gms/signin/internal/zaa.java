package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.InterfaceC10069b16;

/* loaded from: classes3.dex */
public final class zaa extends AbstractSafeParcelable implements InterfaceC10069b16 {
    public static final Parcelable.Creator<zaa> CREATOR = new b();
    final int a;
    private int b;
    private Intent c;

    zaa(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    @Override // ir.nasim.InterfaceC10069b16
    public final Status j() {
        return this.b == 0 ? Status.f : Status.j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.s(parcel, 3, this.c, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
