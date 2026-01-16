package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C19703qn8;
import ir.nasim.DG4;

/* loaded from: classes3.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new C19703qn8();
    public final LatLng a;
    public final LatLng b;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        AbstractC3795Cj5.k(latLng, "southwest must not be null.");
        AbstractC3795Cj5.k(latLng2, "northeast must not be null.");
        double d = latLng2.a;
        double d2 = latLng.a;
        AbstractC3795Cj5.c(d >= d2, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(latLng2.a));
        this.a = latLng;
        this.b = latLng2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.a.equals(latLngBounds.a) && this.b.equals(latLngBounds.b);
    }

    public int hashCode() {
        return DG4.b(this.a, this.b);
    }

    public String toString() {
        return DG4.c(this).a("southwest", this.a).a("northeast", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 2, this.a, i, false);
        AbstractC21804u96.s(parcel, 3, this.b, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
