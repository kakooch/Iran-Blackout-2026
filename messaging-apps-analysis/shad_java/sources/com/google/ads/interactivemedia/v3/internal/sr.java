package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sr implements Comparable<sr>, Parcelable {
    public static final Parcelable.Creator<sr> CREATOR = new sq();
    public final int a;
    public final int b;
    public final int c;

    public sr() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    sr(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(sr srVar) {
        sr srVar2 = srVar;
        int i = this.a - srVar2.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - srVar2.b;
        return i2 == 0 ? this.c - srVar2.c : i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sr.class == obj.getClass()) {
            sr srVar = (sr) obj;
            if (this.a == srVar.a && this.b == srVar.b && this.c == srVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
