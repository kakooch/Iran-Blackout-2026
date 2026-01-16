package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.Mu8;

/* loaded from: classes3.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new Mu8();
    public final float a;
    public final float b;

    public static final class a {
        public float a;
        public float b;

        public a a(float f) {
            this.a = f;
            return this;
        }

        public StreetViewPanoramaOrientation b() {
            return new StreetViewPanoramaOrientation(this.b, this.a);
        }

        public a c(float f) {
            this.b = f;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        boolean z = false;
        if (f >= -90.0f && f <= 90.0f) {
            z = true;
        }
        AbstractC3795Cj5.b(z, "Tilt needs to be between -90 and 90 inclusive: " + f);
        this.a = f + 0.0f;
        this.b = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.a) == Float.floatToIntBits(streetViewPanoramaOrientation.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(streetViewPanoramaOrientation.b);
    }

    public int hashCode() {
        return DG4.b(Float.valueOf(this.a), Float.valueOf(this.b));
    }

    public String toString() {
        return DG4.c(this).a("tilt", Float.valueOf(this.a)).a("bearing", Float.valueOf(this.b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.k(parcel, 2, this.a);
        AbstractC21804u96.k(parcel, 3, this.b);
        AbstractC21804u96.b(parcel, iA);
    }
}
