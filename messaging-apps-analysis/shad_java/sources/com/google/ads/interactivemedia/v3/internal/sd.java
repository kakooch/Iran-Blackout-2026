package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sd extends sb {
    public static final Parcelable.Creator<sd> CREATOR = new sc();
    public final String a;
    public final String b;
    public final String c;

    sd(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        int i = aeu.a;
        this.a = string;
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sd.class == obj.getClass()) {
            sd sdVar = (sd) obj;
            if (aeu.c(this.b, sdVar.b) && aeu.c(this.a, sdVar.a) && aeu.c(this.c, sdVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb
    public final String toString() {
        String str = this.f;
        String str2 = this.a;
        String str3 = this.b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.c);
    }

    public sd(String str, String str2, String str3) {
        super("----");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
