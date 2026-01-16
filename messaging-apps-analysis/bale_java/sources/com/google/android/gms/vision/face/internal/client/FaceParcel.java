package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Pl8;

@UsedByNative("wrapper.cc")
/* loaded from: classes3.dex */
public class FaceParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<FaceParcel> CREATOR = new Pl8();
    private final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final LandmarkParcel[] j;
    public final float k;
    public final float l;
    public final float m;
    public final zza[] n;
    public final float o;

    public FaceParcel(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, LandmarkParcel[] landmarkParcelArr, float f8, float f9, float f10, zza[] zzaVarArr, float f11) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.g = f5;
        this.h = f6;
        this.i = f7;
        this.j = landmarkParcelArr;
        this.k = f8;
        this.l = f9;
        this.m = f10;
        this.n = zzaVarArr;
        this.o = f11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.k(parcel, 3, this.c);
        AbstractC21804u96.k(parcel, 4, this.d);
        AbstractC21804u96.k(parcel, 5, this.e);
        AbstractC21804u96.k(parcel, 6, this.f);
        AbstractC21804u96.k(parcel, 7, this.g);
        AbstractC21804u96.k(parcel, 8, this.h);
        AbstractC21804u96.w(parcel, 9, this.j, i, false);
        AbstractC21804u96.k(parcel, 10, this.k);
        AbstractC21804u96.k(parcel, 11, this.l);
        AbstractC21804u96.k(parcel, 12, this.m);
        AbstractC21804u96.w(parcel, 13, this.n, i, false);
        AbstractC21804u96.k(parcel, 14, this.i);
        AbstractC21804u96.k(parcel, 15, this.o);
        AbstractC21804u96.b(parcel, iA);
    }
}
