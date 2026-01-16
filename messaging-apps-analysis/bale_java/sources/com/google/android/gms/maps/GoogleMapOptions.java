package com.google.android.gms.maps;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import ir.nasim.FE5;
import ir.nasim.Qg8;

/* loaded from: classes3.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new a();
    private static final Integer t = Integer.valueOf(Color.argb(255, 236, SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER, 225));
    private Boolean a;
    private Boolean b;
    private int c;
    private CameraPosition d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Float n;
    private Float o;
    private LatLngBounds p;
    private Boolean q;
    private Integer r;
    private String s;

    public GoogleMapOptions() {
        this.c = -1;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = null;
        this.s = null;
    }

    public static CameraPosition j2(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, FE5.MapAttrs);
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraTargetLat) ? typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraTargetLat, 0.0f) : 0.0f, typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraTargetLng, 0.0f) : 0.0f);
        CameraPosition.a aVarP = CameraPosition.P();
        aVarP.c(latLng);
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraZoom)) {
            aVarP.e(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraZoom, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraBearing)) {
            aVarP.a(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraBearing, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraTilt)) {
            aVarP.d(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraTilt, 0.0f));
        }
        typedArrayObtainAttributes.recycle();
        return aVarP.b();
    }

    public static LatLngBounds k2(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, FE5.MapAttrs);
        Float fValueOf = typedArrayObtainAttributes.hasValue(FE5.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(FE5.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(FE5.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(FE5.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        typedArrayObtainAttributes.recycle();
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    public static GoogleMapOptions x0(Context context, AttributeSet attributeSet) {
        String string;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, FE5.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_mapType)) {
            googleMapOptions.Y1(typedArrayObtainAttributes.getInt(FE5.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_zOrderOnTop)) {
            googleMapOptions.g2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_useViewLifecycle)) {
            googleMapOptions.f2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiCompass)) {
            googleMapOptions.s0(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiRotateGestures)) {
            googleMapOptions.b2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.d2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiScrollGestures)) {
            googleMapOptions.c2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiTiltGestures)) {
            googleMapOptions.e2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiZoomGestures)) {
            googleMapOptions.i2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiZoomControls)) {
            googleMapOptions.h2(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_liteMode)) {
            googleMapOptions.V1(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_uiMapToolbar)) {
            googleMapOptions.X1(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_ambientEnabled)) {
            googleMapOptions.P(typedArrayObtainAttributes.getBoolean(FE5.MapAttrs_ambientEnabled, false));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.a2(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.Z1(typedArrayObtainAttributes.getFloat(FE5.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_backgroundColor)) {
            googleMapOptions.S(Integer.valueOf(typedArrayObtainAttributes.getColor(FE5.MapAttrs_backgroundColor, t.intValue())));
        }
        if (typedArrayObtainAttributes.hasValue(FE5.MapAttrs_mapId) && (string = typedArrayObtainAttributes.getString(FE5.MapAttrs_mapId)) != null && !string.isEmpty()) {
            googleMapOptions.W1(string);
        }
        googleMapOptions.U1(k2(context, attributeSet));
        googleMapOptions.d0(j2(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public Integer A0() {
        return this.r;
    }

    public CameraPosition C0() {
        return this.d;
    }

    public LatLngBounds J0() {
        return this.p;
    }

    public String N0() {
        return this.s;
    }

    public GoogleMapOptions P(boolean z) {
        this.m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions S(Integer num) {
        this.r = num;
        return this;
    }

    public Float S1() {
        return this.o;
    }

    public Float T1() {
        return this.n;
    }

    public GoogleMapOptions U1(LatLngBounds latLngBounds) {
        this.p = latLngBounds;
        return this;
    }

    public GoogleMapOptions V1(boolean z) {
        this.k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions W1(String str) {
        this.s = str;
        return this;
    }

    public int X0() {
        return this.c;
    }

    public GoogleMapOptions X1(boolean z) {
        this.l = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions Y1(int i) {
        this.c = i;
        return this;
    }

    public GoogleMapOptions Z1(float f) {
        this.o = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions a2(float f) {
        this.n = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions b2(boolean z) {
        this.j = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions c2(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions d0(CameraPosition cameraPosition) {
        this.d = cameraPosition;
        return this;
    }

    public GoogleMapOptions d2(boolean z) {
        this.q = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions e2(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions f2(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions g2(boolean z) {
        this.a = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions h2(boolean z) {
        this.e = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions i2(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions s0(boolean z) {
        this.f = Boolean.valueOf(z);
        return this;
    }

    public String toString() {
        return DG4.c(this).a("MapType", Integer.valueOf(this.c)).a("LiteMode", this.k).a("Camera", this.d).a("CompassEnabled", this.f).a("ZoomControlsEnabled", this.e).a("ScrollGesturesEnabled", this.g).a("ZoomGesturesEnabled", this.h).a("TiltGesturesEnabled", this.i).a("RotateGesturesEnabled", this.j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.q).a("MapToolbarEnabled", this.l).a("AmbientEnabled", this.m).a("MinZoomPreference", this.n).a("MaxZoomPreference", this.o).a("BackgroundColor", this.r).a("LatLngBoundsForCameraTarget", this.p).a("ZOrderOnTop", this.a).a("UseViewLifecycleInFragment", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.f(parcel, 2, Qg8.a(this.a));
        AbstractC21804u96.f(parcel, 3, Qg8.a(this.b));
        AbstractC21804u96.n(parcel, 4, X0());
        AbstractC21804u96.s(parcel, 5, C0(), i, false);
        AbstractC21804u96.f(parcel, 6, Qg8.a(this.e));
        AbstractC21804u96.f(parcel, 7, Qg8.a(this.f));
        AbstractC21804u96.f(parcel, 8, Qg8.a(this.g));
        AbstractC21804u96.f(parcel, 9, Qg8.a(this.h));
        AbstractC21804u96.f(parcel, 10, Qg8.a(this.i));
        AbstractC21804u96.f(parcel, 11, Qg8.a(this.j));
        AbstractC21804u96.f(parcel, 12, Qg8.a(this.k));
        AbstractC21804u96.f(parcel, 14, Qg8.a(this.l));
        AbstractC21804u96.f(parcel, 15, Qg8.a(this.m));
        AbstractC21804u96.l(parcel, 16, T1(), false);
        AbstractC21804u96.l(parcel, 17, S1(), false);
        AbstractC21804u96.s(parcel, 18, J0(), i, false);
        AbstractC21804u96.f(parcel, 19, Qg8.a(this.q));
        AbstractC21804u96.p(parcel, 20, A0(), false);
        AbstractC21804u96.t(parcel, 21, N0(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds, byte b12, Integer num, String str) {
        this.c = -1;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = null;
        this.s = null;
        this.a = Qg8.b(b);
        this.b = Qg8.b(b2);
        this.c = i;
        this.d = cameraPosition;
        this.e = Qg8.b(b3);
        this.f = Qg8.b(b4);
        this.g = Qg8.b(b5);
        this.h = Qg8.b(b6);
        this.i = Qg8.b(b7);
        this.j = Qg8.b(b8);
        this.k = Qg8.b(b9);
        this.l = Qg8.b(b10);
        this.m = Qg8.b(b11);
        this.n = f;
        this.o = f2;
        this.p = latLngBounds;
        this.q = Qg8.b(b12);
        this.r = num;
        this.s = str;
    }
}
