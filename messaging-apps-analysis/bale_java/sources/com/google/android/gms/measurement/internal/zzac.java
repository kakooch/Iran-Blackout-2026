package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new C2225d();
    public String a;
    public String b;
    public zzkw c;
    public long d;
    public boolean e;
    public String f;
    public final zzaw g;
    public long h;
    public zzaw i;
    public final long j;
    public final zzaw k;

    zzac(zzac zzacVar) {
        AbstractC3795Cj5.j(zzacVar);
        this.a = zzacVar.a;
        this.b = zzacVar.b;
        this.c = zzacVar.c;
        this.d = zzacVar.d;
        this.e = zzacVar.e;
        this.f = zzacVar.f;
        this.g = zzacVar.g;
        this.h = zzacVar.h;
        this.i = zzacVar.i;
        this.j = zzacVar.j;
        this.k = zzacVar.k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, this.a, false);
        AbstractC21804u96.t(parcel, 3, this.b, false);
        AbstractC21804u96.s(parcel, 4, this.c, i, false);
        AbstractC21804u96.q(parcel, 5, this.d);
        AbstractC21804u96.c(parcel, 6, this.e);
        AbstractC21804u96.t(parcel, 7, this.f, false);
        AbstractC21804u96.s(parcel, 8, this.g, i, false);
        AbstractC21804u96.q(parcel, 9, this.h);
        AbstractC21804u96.s(parcel, 10, this.i, i, false);
        AbstractC21804u96.q(parcel, 11, this.j);
        AbstractC21804u96.s(parcel, 12, this.k, i, false);
        AbstractC21804u96.b(parcel, iA);
    }

    zzac(String str, String str2, zzkw zzkwVar, long j, boolean z, String str3, zzaw zzawVar, long j2, zzaw zzawVar2, long j3, zzaw zzawVar3) {
        this.a = str;
        this.b = str2;
        this.c = zzkwVar;
        this.d = j;
        this.e = z;
        this.f = str3;
        this.g = zzawVar;
        this.h = j2;
        this.i = zzawVar2;
        this.j = j3;
        this.k = zzawVar3;
    }
}
