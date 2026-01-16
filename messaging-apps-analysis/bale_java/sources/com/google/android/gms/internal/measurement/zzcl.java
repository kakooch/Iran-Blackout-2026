package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C23936xl8;

/* loaded from: classes3.dex */
public final class zzcl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcl> CREATOR = new C23936xl8();
    public final long a;
    public final long b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final Bundle g;
    public final String h;

    public zzcl(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = bundle;
        this.h = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.q(parcel, 1, this.a);
        AbstractC21804u96.q(parcel, 2, this.b);
        AbstractC21804u96.c(parcel, 3, this.c);
        AbstractC21804u96.t(parcel, 4, this.d, false);
        AbstractC21804u96.t(parcel, 5, this.e, false);
        AbstractC21804u96.t(parcel, 6, this.f, false);
        AbstractC21804u96.e(parcel, 7, this.g, false);
        AbstractC21804u96.t(parcel, 8, this.h, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
