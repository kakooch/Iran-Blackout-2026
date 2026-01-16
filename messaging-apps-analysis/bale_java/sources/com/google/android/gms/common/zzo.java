package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.CG4;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new s();
    private final String a;
    private final boolean b;
    private final boolean c;
    private final Context d;
    private final boolean e;
    private final boolean f;

    zzo(String str, boolean z, boolean z2, IBinder iBinder, boolean z3, boolean z4) {
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = (Context) CG4.D2(XZ2.a.C2(iBinder));
        this.e = z3;
        this.f = z4;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, ir.nasim.XZ2] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 1, str, false);
        AbstractC21804u96.c(parcel, 2, this.b);
        AbstractC21804u96.c(parcel, 3, this.c);
        AbstractC21804u96.m(parcel, 4, CG4.E2(this.d), false);
        AbstractC21804u96.c(parcel, 5, this.e);
        AbstractC21804u96.c(parcel, 6, this.f);
        AbstractC21804u96.b(parcel, iA);
    }
}
