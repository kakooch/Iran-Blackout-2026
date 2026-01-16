package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Vr8;

@UsedByNative("wrapper.cc")
/* loaded from: classes3.dex */
public final class LandmarkParcel extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<LandmarkParcel> CREATOR = new Vr8();
    private final int a;
    public final float b;
    public final float c;
    public final int d;

    public LandmarkParcel(int i, float f, float f2, int i2) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.k(parcel, 2, this.b);
        AbstractC21804u96.k(parcel, 3, this.c);
        AbstractC21804u96.n(parcel, 4, this.d);
        AbstractC21804u96.b(parcel, iA);
    }
}
