package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import ir.nasim.AbstractC12608et8;
import ir.nasim.AbstractC16738lm8;
import ir.nasim.AbstractC21804u96;
import ir.nasim.DG4;

/* loaded from: classes3.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new b();
    private final long a;
    private final int b;
    private final boolean c;
    private final String d;
    private final zzd e;

    public static final class a {
        private long a = Long.MAX_VALUE;
        private int b = 0;
        private boolean c = false;
        private String d = null;
        private zzd e = null;

        public LastLocationRequest a() {
            return new LastLocationRequest(this.a, this.b, this.c, this.d, this.e);
        }
    }

    LastLocationRequest(long j, int i, boolean z, String str, zzd zzdVar) {
        this.a = j;
        this.b = i;
        this.c = z;
        this.d = str;
        this.e = zzdVar;
    }

    public int P() {
        return this.b;
    }

    public long S() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        return this.a == lastLocationRequest.a && this.b == lastLocationRequest.b && this.c == lastLocationRequest.c && DG4.a(this.d, lastLocationRequest.d) && DG4.a(this.e, lastLocationRequest.e);
    }

    public int hashCode() {
        return DG4.b(Long.valueOf(this.a), Integer.valueOf(this.b), Boolean.valueOf(this.c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.a != Long.MAX_VALUE) {
            sb.append("maxAge=");
            AbstractC16738lm8.b(this.a, sb);
        }
        if (this.b != 0) {
            sb.append(", ");
            sb.append(AbstractC12608et8.b(this.b));
        }
        if (this.c) {
            sb.append(", bypass");
        }
        if (this.d != null) {
            sb.append(", moduleId=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", impersonation=");
            sb.append(this.e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.q(parcel, 1, S());
        AbstractC21804u96.n(parcel, 2, P());
        AbstractC21804u96.c(parcel, 3, this.c);
        AbstractC21804u96.t(parcel, 4, this.d, false);
        AbstractC21804u96.s(parcel, 5, this.e, i, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
