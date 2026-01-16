package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C16688lh8;
import ir.nasim.InterfaceC10069b16;

/* loaded from: classes3.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements InterfaceC10069b16 {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new C16688lh8();
    private final Status a;
    private final LocationSettingsStates b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.a = status;
        this.b = locationSettingsStates;
    }

    public LocationSettingsStates P() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC10069b16
    public Status j() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 1, j(), i, false);
        AbstractC21804u96.s(parcel, 2, P(), i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
