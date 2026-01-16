package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import ir.nasim.Qg8;

/* loaded from: classes3.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new e();
    private StreetViewPanoramaCamera a;
    private String b;
    private LatLng c;
    private Integer d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private StreetViewSource j;

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5, StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.e = bool;
        this.f = bool;
        this.g = bool;
        this.h = bool;
        this.j = StreetViewSource.b;
        this.a = streetViewPanoramaCamera;
        this.c = latLng;
        this.d = num;
        this.b = str;
        this.e = Qg8.b(b);
        this.f = Qg8.b(b2);
        this.g = Qg8.b(b3);
        this.h = Qg8.b(b4);
        this.i = Qg8.b(b5);
        this.j = streetViewSource;
    }

    public String P() {
        return this.b;
    }

    public LatLng S() {
        return this.c;
    }

    public Integer d0() {
        return this.d;
    }

    public StreetViewSource s0() {
        return this.j;
    }

    public String toString() {
        return DG4.c(this).a("PanoramaId", this.b).a("Position", this.c).a("Radius", this.d).a("Source", this.j).a("StreetViewPanoramaCamera", this.a).a("UserNavigationEnabled", this.e).a("ZoomGesturesEnabled", this.f).a("PanningGesturesEnabled", this.g).a("StreetNamesEnabled", this.h).a("UseViewLifecycleInFragment", this.i).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 2, x0(), i, false);
        AbstractC21804u96.t(parcel, 3, P(), false);
        AbstractC21804u96.s(parcel, 4, S(), i, false);
        AbstractC21804u96.p(parcel, 5, d0(), false);
        AbstractC21804u96.f(parcel, 6, Qg8.a(this.e));
        AbstractC21804u96.f(parcel, 7, Qg8.a(this.f));
        AbstractC21804u96.f(parcel, 8, Qg8.a(this.g));
        AbstractC21804u96.f(parcel, 9, Qg8.a(this.h));
        AbstractC21804u96.f(parcel, 10, Qg8.a(this.i));
        AbstractC21804u96.s(parcel, 11, s0(), i, false);
        AbstractC21804u96.b(parcel, iA);
    }

    public StreetViewPanoramaCamera x0() {
        return this.a;
    }
}
