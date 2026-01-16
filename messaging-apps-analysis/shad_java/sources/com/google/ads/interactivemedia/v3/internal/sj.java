package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sj extends sb {
    public static final Parcelable.Creator<sj> CREATOR = new si();
    public final String a;
    public final String b;

    /* JADX WARN: Illegal instructions before constructor call */
    sj(Parcel parcel) {
        String string = parcel.readString();
        int i = aeu.a;
        super(string);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sj.class == obj.getClass()) {
            sj sjVar = (sj) obj;
            if (this.f.equals(sjVar.f) && aeu.c(this.a, sjVar.a) && aeu.c(this.b, sjVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f.hashCode() + 527) * 31;
        String str = this.a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb
    public final String toString() {
        String str = this.f;
        String str2 = this.a;
        String str3 = this.b;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public sj(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }
}
