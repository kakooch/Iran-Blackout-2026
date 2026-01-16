package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Mf8;

/* loaded from: classes3.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new Mf8();
    private final int a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final String f;
    private final String g;
    private final int h;
    private final int i;

    public MethodInvocation(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = str;
        this.g = str2;
        this.h = i4;
        this.i = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.n(parcel, 3, this.c);
        AbstractC21804u96.q(parcel, 4, this.d);
        AbstractC21804u96.q(parcel, 5, this.e);
        AbstractC21804u96.t(parcel, 6, this.f, false);
        AbstractC21804u96.t(parcel, 7, this.g, false);
        AbstractC21804u96.n(parcel, 8, this.h);
        AbstractC21804u96.n(parcel, 9, this.i);
        AbstractC21804u96.b(parcel, iA);
    }
}
