package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sh extends sb {
    public static final Parcelable.Creator<sh> CREATOR = new sg();
    public final String a;
    public final byte[] b;

    sh(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = (byte[]) aeu.f(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sh.class == obj.getClass()) {
            sh shVar = (sh) obj;
            if (aeu.c(this.a, shVar.a) && Arrays.equals(this.b, shVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb
    public final String toString() {
        String str = this.f;
        String str2 = this.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": owner=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
    }

    public sh(String str, byte[] bArr) {
        super("PRIV");
        this.a = str;
        this.b = bArr;
    }
}
