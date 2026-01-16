package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Ff8;
import ir.nasim.InterfaceC10069b16;
import java.util.List;

/* loaded from: classes3.dex */
public final class zag extends AbstractSafeParcelable implements InterfaceC10069b16 {
    public static final Parcelable.Creator<zag> CREATOR = new Ff8();
    private final List a;
    private final String b;

    public zag(List list, String str) {
        this.a = list;
        this.b = str;
    }

    @Override // ir.nasim.InterfaceC10069b16
    public final Status j() {
        return this.b != null ? Status.f : Status.j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.v(parcel, 1, this.a, false);
        AbstractC21804u96.t(parcel, 2, this.b, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
