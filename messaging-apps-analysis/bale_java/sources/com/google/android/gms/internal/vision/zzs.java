package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C19192pv8;
import ir.nasim.C7501Rz2;

/* loaded from: classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new C19192pv8();
    public int a;
    public int b;
    public int c;
    public long d;
    public int e;

    public zzs() {
    }

    public static zzs P(C7501Rz2 c7501Rz2) {
        zzs zzsVar = new zzs();
        zzsVar.a = c7501Rz2.c().e();
        zzsVar.b = c7501Rz2.c().a();
        zzsVar.e = c7501Rz2.c().c();
        zzsVar.c = c7501Rz2.c().b();
        zzsVar.d = c7501Rz2.c().d();
        return zzsVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 2, this.a);
        AbstractC21804u96.n(parcel, 3, this.b);
        AbstractC21804u96.n(parcel, 4, this.c);
        AbstractC21804u96.q(parcel, 5, this.d);
        AbstractC21804u96.n(parcel, 6, this.e);
        AbstractC21804u96.b(parcel, iA);
    }

    public zzs(int i, int i2, int i3, long j, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = i4;
    }
}
