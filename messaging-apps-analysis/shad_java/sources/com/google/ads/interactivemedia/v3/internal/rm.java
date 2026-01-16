package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class rm extends sb {
    public static final Parcelable.Creator<rm> CREATOR = new rl();
    public final String a;
    public final String b;
    public final int c;
    public final byte[] d;

    rm(Parcel parcel) {
        super("APIC");
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = (byte[]) aeu.f(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && rm.class == obj.getClass()) {
            rm rmVar = (rm) obj;
            if (this.c == rmVar.c && aeu.c(this.a, rmVar.a) && aeu.c(this.b, rmVar.b) && Arrays.equals(this.d, rmVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.c + 527) * 31;
        String str = this.a;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb
    public final String toString() {
        String str = this.f;
        String str2 = this.a;
        String str3 = this.b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.d);
    }

    public rm(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = bArr;
    }
}
