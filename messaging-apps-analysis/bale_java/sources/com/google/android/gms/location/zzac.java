package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;

@Deprecated
/* loaded from: classes3.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new a();
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    zzac(int i, int i2, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzacVar = (zzac) obj;
            if (this.a == zzacVar.a && this.b == zzacVar.b && this.c == zzacVar.c && this.d == zzacVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(Integer.valueOf(this.b), Integer.valueOf(this.a), Long.valueOf(this.d), Long.valueOf(this.c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.a + " Cell status: " + this.b + " elapsed time NS: " + this.d + " system time ms: " + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.n(parcel, 2, this.b);
        AbstractC21804u96.q(parcel, 3, this.c);
        AbstractC21804u96.q(parcel, 4, this.d);
        AbstractC21804u96.b(parcel, iA);
    }
}
