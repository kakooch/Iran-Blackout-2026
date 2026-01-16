package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.Rg8;

/* loaded from: classes3.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Rg8();
    public final LatLng a;
    public final float b;
    public final float c;
    public final float d;

    public static final class a {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public a a(float f) {
            this.d = f;
            return this;
        }

        public CameraPosition b() {
            return new CameraPosition(this.a, this.b, this.c, this.d);
        }

        public a c(LatLng latLng) {
            this.a = (LatLng) AbstractC3795Cj5.k(latLng, "location must not be null.");
            return this;
        }

        public a d(float f) {
            this.c = f;
            return this;
        }

        public a e(float f) {
            this.b = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        AbstractC3795Cj5.k(latLng, "camera target must not be null.");
        boolean z = false;
        if (f2 >= 0.0f && f2 <= 90.0f) {
            z = true;
        }
        AbstractC3795Cj5.c(z, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.a = latLng;
        this.b = f;
        this.c = f2 + 0.0f;
        this.d = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public static a P() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.a.equals(cameraPosition.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(cameraPosition.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(cameraPosition.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(cameraPosition.d);
    }

    public int hashCode() {
        return DG4.b(this.a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d));
    }

    public String toString() {
        return DG4.c(this).a("target", this.a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 2, this.a, i, false);
        AbstractC21804u96.k(parcel, 3, this.b);
        AbstractC21804u96.k(parcel, 4, this.c);
        AbstractC21804u96.k(parcel, 5, this.d);
        AbstractC21804u96.b(parcel, iA);
    }
}
