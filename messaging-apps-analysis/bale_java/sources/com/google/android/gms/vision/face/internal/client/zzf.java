package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Qm8;

/* loaded from: classes3.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new Qm8();
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public float f;

    public zzf() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 2, this.a);
        AbstractC21804u96.n(parcel, 3, this.b);
        AbstractC21804u96.n(parcel, 4, this.c);
        AbstractC21804u96.c(parcel, 5, this.d);
        AbstractC21804u96.c(parcel, 6, this.e);
        AbstractC21804u96.k(parcel, 7, this.f);
        AbstractC21804u96.b(parcel, iA);
    }

    public zzf(int i, int i2, int i3, boolean z, boolean z2, float f) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = z2;
        this.f = f;
    }
}
