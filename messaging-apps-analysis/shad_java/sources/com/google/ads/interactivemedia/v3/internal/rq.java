package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class rq extends sb {
    public static final Parcelable.Creator<rq> CREATOR = new rp();
    public final String a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    private final sb[] g;

    rq(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        int i2 = parcel.readInt();
        this.g = new sb[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3] = (sb) parcel.readParcelable(sb.class.getClassLoader());
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && rq.class == obj.getClass()) {
            rq rqVar = (rq) obj;
            if (this.b == rqVar.b && this.c == rqVar.c && this.d == rqVar.d && this.e == rqVar.e && aeu.c(this.a, rqVar.a) && Arrays.equals(this.g, rqVar.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((this.b + 527) * 31) + this.c) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31;
        String str = this.a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.g.length);
        for (sb sbVar : this.g) {
            parcel.writeParcelable(sbVar, 0);
        }
    }

    public rq(String str, int i, int i2, long j, long j2, sb[] sbVarArr) {
        super("CHAP");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.g = sbVarArr;
    }
}
