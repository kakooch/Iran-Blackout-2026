package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;
import ir.nasim.Sl8;

/* loaded from: classes3.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new Sl8();
    private final boolean a;
    private final long b;
    private final long c;

    public zzc(boolean z, long j, long j2) {
        this.a = z;
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            if (this.a == zzcVar.a && this.b == zzcVar.b && this.c == zzcVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(Boolean.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c));
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.a + ",collectForDebugStartTimeMillis: " + this.b + ",collectForDebugExpiryTimeMillis: " + this.c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.c(parcel, 1, this.a);
        AbstractC21804u96.q(parcel, 2, this.c);
        AbstractC21804u96.q(parcel, 3, this.b);
        AbstractC21804u96.b(parcel, iA);
    }
}
