package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.Qt8;

/* loaded from: classes3.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new Qt8();
    public final float a;
    public final float b;
    public final float c;
    private final StreetViewPanoramaOrientation d;

    public StreetViewPanoramaCamera(float f, float f2, float f3) {
        boolean z = false;
        if (f2 >= -90.0f && f2 <= 90.0f) {
            z = true;
        }
        AbstractC3795Cj5.b(z, "Tilt needs to be between -90 and 90 inclusive: " + f2);
        this.a = ((double) f) <= 0.0d ? 0.0f : f;
        this.b = 0.0f + f2;
        this.c = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        StreetViewPanoramaOrientation.a aVar = new StreetViewPanoramaOrientation.a();
        aVar.c(f2);
        aVar.a(f3);
        this.d = aVar.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.a) == Float.floatToIntBits(streetViewPanoramaCamera.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(streetViewPanoramaCamera.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(streetViewPanoramaCamera.c);
    }

    public int hashCode() {
        return DG4.b(Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c));
    }

    public String toString() {
        return DG4.c(this).a("zoom", Float.valueOf(this.a)).a("tilt", Float.valueOf(this.b)).a("bearing", Float.valueOf(this.c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.k(parcel, 2, this.a);
        AbstractC21804u96.k(parcel, 3, this.b);
        AbstractC21804u96.k(parcel, 4, this.c);
        AbstractC21804u96.b(parcel, iA);
    }
}
