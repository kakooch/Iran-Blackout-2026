package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new k4();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final long f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final long j;
    public final String k;
    public final long l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Boolean r;
    public final long s;
    public final List t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;

    zzq(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11) {
        AbstractC3795Cj5.f(str);
        this.a = str;
        this.b = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.c = str3;
        this.j = j;
        this.d = str4;
        this.e = j2;
        this.f = j3;
        this.g = str5;
        this.h = z;
        this.i = z2;
        this.k = str6;
        this.l = 0L;
        this.m = j5;
        this.n = i;
        this.o = z3;
        this.p = z4;
        this.q = str7;
        this.r = bool;
        this.s = j6;
        this.t = list;
        this.u = null;
        this.v = str9;
        this.w = str10;
        this.x = str11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, this.a, false);
        AbstractC21804u96.t(parcel, 3, this.b, false);
        AbstractC21804u96.t(parcel, 4, this.c, false);
        AbstractC21804u96.t(parcel, 5, this.d, false);
        AbstractC21804u96.q(parcel, 6, this.e);
        AbstractC21804u96.q(parcel, 7, this.f);
        AbstractC21804u96.t(parcel, 8, this.g, false);
        AbstractC21804u96.c(parcel, 9, this.h);
        AbstractC21804u96.c(parcel, 10, this.i);
        AbstractC21804u96.q(parcel, 11, this.j);
        AbstractC21804u96.t(parcel, 12, this.k, false);
        AbstractC21804u96.q(parcel, 13, this.l);
        AbstractC21804u96.q(parcel, 14, this.m);
        AbstractC21804u96.n(parcel, 15, this.n);
        AbstractC21804u96.c(parcel, 16, this.o);
        AbstractC21804u96.c(parcel, 18, this.p);
        AbstractC21804u96.t(parcel, 19, this.q, false);
        AbstractC21804u96.d(parcel, 21, this.r, false);
        AbstractC21804u96.q(parcel, 22, this.s);
        AbstractC21804u96.v(parcel, 23, this.t, false);
        AbstractC21804u96.t(parcel, 24, this.u, false);
        AbstractC21804u96.t(parcel, 25, this.v, false);
        AbstractC21804u96.t(parcel, 26, this.w, false);
        AbstractC21804u96.t(parcel, 27, this.x, false);
        AbstractC21804u96.b(parcel, iA);
    }

    zzq(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.j = j3;
        this.d = str4;
        this.e = j;
        this.f = j2;
        this.g = str5;
        this.h = z;
        this.i = z2;
        this.k = str6;
        this.l = j4;
        this.m = j5;
        this.n = i;
        this.o = z3;
        this.p = z4;
        this.q = str7;
        this.r = bool;
        this.s = j6;
        this.t = list;
        this.u = str8;
        this.v = str9;
        this.w = str10;
        this.x = str11;
    }
}
