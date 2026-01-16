package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.InterfaceC10069b16;
import ir.nasim.Yo8;

/* loaded from: classes3.dex */
public final class zzg extends AbstractSafeParcelable implements InterfaceC10069b16 {
    private final Status a;
    public static final zzg b = new zzg(Status.f);
    public static final Parcelable.Creator<zzg> CREATOR = new Yo8();

    public zzg(Status status) {
        this.a = status;
    }

    @Override // ir.nasim.InterfaceC10069b16
    public final Status j() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 1, this.a, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
