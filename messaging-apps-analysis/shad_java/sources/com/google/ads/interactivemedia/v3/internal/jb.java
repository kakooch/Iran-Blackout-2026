package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jb implements Parcelable {
    public static final Parcelable.Creator<jb> CREATOR = new ja();
    public final UUID a;
    public final String b;
    public final String c;
    public final byte[] d;
    private int e;

    jb(Parcel parcel) {
        this.a = new UUID(parcel.readLong(), parcel.readLong());
        this.b = parcel.readString();
        String string = parcel.readString();
        int i = aeu.a;
        this.c = string;
        this.d = parcel.createByteArray();
    }

    public final boolean a(jb jbVar) {
        if (!b() || jbVar.b()) {
            return false;
        }
        return bi.a.equals(this.a) || jbVar.a.equals(this.a);
    }

    public final boolean b() {
        return this.d != null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jb)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        jb jbVar = (jb) obj;
        return aeu.c(this.b, jbVar.b) && aeu.c(this.c, jbVar.c) && aeu.c(this.a, jbVar.a) && Arrays.equals(this.d, jbVar.d);
    }

    public final int hashCode() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d);
        this.e = iHashCode2;
        return iHashCode2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a.getMostSignificantBits());
        parcel.writeLong(this.a.getLeastSignificantBits());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }

    public jb(UUID uuid, String str, String str2, byte[] bArr) {
        ary.t(uuid);
        this.a = uuid;
        this.b = str;
        ary.t(str2);
        this.c = str2;
        this.d = bArr;
    }

    public jb(UUID uuid, String str, byte[] bArr) {
        this(uuid, null, str, bArr);
    }
}
