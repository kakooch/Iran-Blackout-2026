package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C10014av8;
import ir.nasim.DG4;

/* loaded from: classes3.dex */
public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new C10014av8();
    public static final StreetViewSource b = new StreetViewSource(0);
    public static final StreetViewSource c = new StreetViewSource(1);
    private final int a;

    public StreetViewSource(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.a == ((StreetViewSource) obj).a;
    }

    public int hashCode() {
        return DG4.b(Integer.valueOf(this.a));
    }

    public String toString() {
        int i = this.a;
        return String.format("StreetViewSource:%s", i != 0 ? i != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i)) : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 2, this.a);
        AbstractC21804u96.b(parcel, iA);
    }
}
