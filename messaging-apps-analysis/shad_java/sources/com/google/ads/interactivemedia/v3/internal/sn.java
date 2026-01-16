package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sn implements qy {
    public static final Parcelable.Creator<sn> CREATOR = new sm();
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    /* synthetic */ sn(Parcel parcel) {
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = (byte[]) aeu.f(parcel.createByteArray());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public sn(String str, byte[] bArr, int i, int i2) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sn.class == obj.getClass()) {
            sn snVar = (sn) obj;
            if (this.a.equals(snVar.a) && Arrays.equals(this.b, snVar.b) && this.c == snVar.c && this.d == snVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        return strValueOf.length() != 0 ? "mdta: key=".concat(strValueOf) : new String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
