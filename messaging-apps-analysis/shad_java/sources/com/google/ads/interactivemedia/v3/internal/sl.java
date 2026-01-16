package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sl extends sb {
    public static final Parcelable.Creator<sl> CREATOR = new sk();
    public final String a;
    public final String b;

    /* JADX WARN: Illegal instructions before constructor call */
    sl(Parcel parcel) {
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
        if (obj != null && sl.class == obj.getClass()) {
            sl slVar = (sl) obj;
            if (this.f.equals(slVar.f) && aeu.c(this.a, slVar.a) && aeu.c(this.b, slVar.b)) {
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
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public sl(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }
}
