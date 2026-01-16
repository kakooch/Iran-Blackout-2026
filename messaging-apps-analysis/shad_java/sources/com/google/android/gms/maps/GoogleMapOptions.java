package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
/* loaded from: classes3.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzab();
    private Boolean zza;
    private Boolean zzb;
    private int zzc;
    private CameraPosition zzd;
    private Boolean zze;
    private Boolean zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private Boolean zzj;
    private Boolean zzk;
    private Boolean zzl;
    private Boolean zzm;
    private Float zzn;
    private Float zzo;
    private LatLngBounds zzp;
    private Boolean zzq;

    public GoogleMapOptions() {
        this.zzc = -1;
        this.zzn = null;
        this.zzo = null;
        this.zzp = null;
    }

    @RecentlyNullable
    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i = R$styleable.MapAttrs_mapType;
        if (typedArrayObtainAttributes.hasValue(i)) {
            googleMapOptions.mapType(typedArrayObtainAttributes.getInt(i, -1));
        }
        int i2 = R$styleable.MapAttrs_zOrderOnTop;
        if (typedArrayObtainAttributes.hasValue(i2)) {
            googleMapOptions.zOrderOnTop(typedArrayObtainAttributes.getBoolean(i2, false));
        }
        int i3 = R$styleable.MapAttrs_useViewLifecycle;
        if (typedArrayObtainAttributes.hasValue(i3)) {
            googleMapOptions.useViewLifecycleInFragment(typedArrayObtainAttributes.getBoolean(i3, false));
        }
        int i4 = R$styleable.MapAttrs_uiCompass;
        if (typedArrayObtainAttributes.hasValue(i4)) {
            googleMapOptions.compassEnabled(typedArrayObtainAttributes.getBoolean(i4, true));
        }
        int i5 = R$styleable.MapAttrs_uiRotateGestures;
        if (typedArrayObtainAttributes.hasValue(i5)) {
            googleMapOptions.rotateGesturesEnabled(typedArrayObtainAttributes.getBoolean(i5, true));
        }
        int i6 = R$styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
        if (typedArrayObtainAttributes.hasValue(i6)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(typedArrayObtainAttributes.getBoolean(i6, true));
        }
        int i7 = R$styleable.MapAttrs_uiScrollGestures;
        if (typedArrayObtainAttributes.hasValue(i7)) {
            googleMapOptions.scrollGesturesEnabled(typedArrayObtainAttributes.getBoolean(i7, true));
        }
        int i8 = R$styleable.MapAttrs_uiTiltGestures;
        if (typedArrayObtainAttributes.hasValue(i8)) {
            googleMapOptions.tiltGesturesEnabled(typedArrayObtainAttributes.getBoolean(i8, true));
        }
        int i9 = R$styleable.MapAttrs_uiZoomGestures;
        if (typedArrayObtainAttributes.hasValue(i9)) {
            googleMapOptions.zoomGesturesEnabled(typedArrayObtainAttributes.getBoolean(i9, true));
        }
        int i10 = R$styleable.MapAttrs_uiZoomControls;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            googleMapOptions.zoomControlsEnabled(typedArrayObtainAttributes.getBoolean(i10, true));
        }
        int i11 = R$styleable.MapAttrs_liteMode;
        if (typedArrayObtainAttributes.hasValue(i11)) {
            googleMapOptions.liteMode(typedArrayObtainAttributes.getBoolean(i11, false));
        }
        int i12 = R$styleable.MapAttrs_uiMapToolbar;
        if (typedArrayObtainAttributes.hasValue(i12)) {
            googleMapOptions.mapToolbarEnabled(typedArrayObtainAttributes.getBoolean(i12, true));
        }
        int i13 = R$styleable.MapAttrs_ambientEnabled;
        if (typedArrayObtainAttributes.hasValue(i13)) {
            googleMapOptions.ambientEnabled(typedArrayObtainAttributes.getBoolean(i13, false));
        }
        int i14 = R$styleable.MapAttrs_cameraMinZoomPreference;
        if (typedArrayObtainAttributes.hasValue(i14)) {
            googleMapOptions.minZoomPreference(typedArrayObtainAttributes.getFloat(i14, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(i14)) {
            googleMapOptions.maxZoomPreference(typedArrayObtainAttributes.getFloat(R$styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(zza(context, attributeSet));
        googleMapOptions.camera(zzb(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    @RecentlyNullable
    public static LatLngBounds zza(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.MapAttrs);
        int i = R$styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        Float fValueOf = typedArrayObtainAttributes.hasValue(i) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i, 0.0f)) : null;
        int i2 = R$styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(i2) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i2, 0.0f)) : null;
        int i3 = R$styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(i3) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i3, 0.0f)) : null;
        int i4 = R$styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(i4) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i4, 0.0f)) : null;
        typedArrayObtainAttributes.recycle();
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    @RecentlyNullable
    public static CameraPosition zzb(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.MapAttrs);
        int i = R$styleable.MapAttrs_cameraTargetLat;
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(i) ? typedArrayObtainAttributes.getFloat(i, 0.0f) : 0.0f, typedArrayObtainAttributes.hasValue(R$styleable.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes.getFloat(r0, 0.0f) : 0.0f);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        int i2 = R$styleable.MapAttrs_cameraZoom;
        if (typedArrayObtainAttributes.hasValue(i2)) {
            builder.zoom(typedArrayObtainAttributes.getFloat(i2, 0.0f));
        }
        int i3 = R$styleable.MapAttrs_cameraBearing;
        if (typedArrayObtainAttributes.hasValue(i3)) {
            builder.bearing(typedArrayObtainAttributes.getFloat(i3, 0.0f));
        }
        int i4 = R$styleable.MapAttrs_cameraTilt;
        if (typedArrayObtainAttributes.hasValue(i4)) {
            builder.tilt(typedArrayObtainAttributes.getFloat(i4, 0.0f));
        }
        typedArrayObtainAttributes.recycle();
        return builder.build();
    }

    @RecentlyNonNull
    public GoogleMapOptions ambientEnabled(boolean z) {
        this.zzm = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzd = cameraPosition;
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzf = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNullable
    public CameraPosition getCamera() {
        return this.zzd;
    }

    @RecentlyNullable
    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzp;
    }

    public int getMapType() {
        return this.zzc;
    }

    @RecentlyNullable
    public Float getMaxZoomPreference() {
        return this.zzo;
    }

    @RecentlyNullable
    public Float getMinZoomPreference() {
        return this.zzn;
    }

    @RecentlyNonNull
    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.zzp = latLngBounds;
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions liteMode(boolean z) {
        this.zzk = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzl = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions mapType(int i) {
        this.zzc = i;
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions maxZoomPreference(float f) {
        this.zzo = Float.valueOf(f);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions minZoomPreference(float f) {
        this.zzn = Float.valueOf(f);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzj = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzg = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        this.zzq = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzi = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.zzc)).add("LiteMode", this.zzk).add("Camera", this.zzd).add("CompassEnabled", this.zzf).add("ZoomControlsEnabled", this.zze).add("ScrollGesturesEnabled", this.zzg).add("ZoomGesturesEnabled", this.zzh).add("TiltGesturesEnabled", this.zzi).add("RotateGesturesEnabled", this.zzj).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzq).add("MapToolbarEnabled", this.zzl).add("AmbientEnabled", this.zzm).add("MinZoomPreference", this.zzn).add("MaxZoomPreference", this.zzo).add("LatLngBoundsForCameraTarget", this.zzp).add("ZOrderOnTop", this.zza).add("UseViewLifecycleInFragment", this.zzb).toString();
    }

    @RecentlyNonNull
    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, com.google.android.gms.maps.internal.zza.zzb(this.zza));
        SafeParcelWriter.writeByte(parcel, 3, com.google.android.gms.maps.internal.zza.zzb(this.zzb));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i, false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zzb(this.zze));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zzb(this.zzf));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zzb(this.zzg));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zzb(this.zzh));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zzb(this.zzi));
        SafeParcelWriter.writeByte(parcel, 11, com.google.android.gms.maps.internal.zza.zzb(this.zzj));
        SafeParcelWriter.writeByte(parcel, 12, com.google.android.gms.maps.internal.zza.zzb(this.zzk));
        SafeParcelWriter.writeByte(parcel, 14, com.google.android.gms.maps.internal.zza.zzb(this.zzl));
        SafeParcelWriter.writeByte(parcel, 15, com.google.android.gms.maps.internal.zza.zzb(this.zzm));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i, false);
        SafeParcelWriter.writeByte(parcel, 19, com.google.android.gms.maps.internal.zza.zzb(this.zzq));
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @RecentlyNonNull
    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zza = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zze = Boolean.valueOf(z);
        return this;
    }

    @RecentlyNonNull
    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzh = Boolean.valueOf(z);
        return this;
    }

    GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds, byte b12) {
        this.zzc = -1;
        this.zzn = null;
        this.zzo = null;
        this.zzp = null;
        this.zza = com.google.android.gms.maps.internal.zza.zza(b);
        this.zzb = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzc = i;
        this.zzd = cameraPosition;
        this.zze = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzf = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzg = com.google.android.gms.maps.internal.zza.zza(b5);
        this.zzh = com.google.android.gms.maps.internal.zza.zza(b6);
        this.zzi = com.google.android.gms.maps.internal.zza.zza(b7);
        this.zzj = com.google.android.gms.maps.internal.zza.zza(b8);
        this.zzk = com.google.android.gms.maps.internal.zza.zza(b9);
        this.zzl = com.google.android.gms.maps.internal.zza.zza(b10);
        this.zzm = com.google.android.gms.maps.internal.zza.zza(b11);
        this.zzn = f;
        this.zzo = f2;
        this.zzp = latLngBounds;
        this.zzq = com.google.android.gms.maps.internal.zza.zza(b12);
    }
}
