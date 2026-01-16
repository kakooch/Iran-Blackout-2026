package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class rs extends sb {
    public static final Parcelable.Creator<rs> CREATOR = new rr();
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String[] d;
    private final sb[] e;

    rs(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = (String[]) aeu.f(parcel.createStringArray());
        int i2 = parcel.readInt();
        this.e = new sb[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.e[i3] = (sb) parcel.readParcelable(sb.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && rs.class == obj.getClass()) {
            rs rsVar = (rs) obj;
            if (this.b == rsVar.b && this.c == rsVar.c && aeu.c(this.a, rsVar.a) && Arrays.equals(this.d, rsVar.d) && Arrays.equals(this.e, rsVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.b ? 1 : 0) + 527) * 31) + (this.c ? 1 : 0)) * 31;
        String str = this.a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.d);
        parcel.writeInt(this.e.length);
        for (sb sbVar : this.e) {
            parcel.writeParcelable(sbVar, 0);
        }
    }

    public rs(String str, boolean z, boolean z2, String[] strArr, sb[] sbVarArr) {
        super("CTOC");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = strArr;
        this.e = sbVarArr;
    }
}
