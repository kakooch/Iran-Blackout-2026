package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aat implements Parcelable {
    public static final Parcelable.Creator<aat> CREATOR = new aas();
    public final int a;
    public final int[] b;
    public final int c;
    public final int d;
    public final int e;

    aat(Parcel parcel) {
        this.a = parcel.readInt();
        int i = parcel.readByte();
        this.c = i;
        int[] iArr = new int[i];
        this.b = iArr;
        parcel.readIntArray(iArr);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aat.class == obj.getClass()) {
            aat aatVar = (aat) obj;
            if (this.a == aatVar.a && Arrays.equals(this.b, aatVar.b) && this.d == aatVar.d && this.e == aatVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.d) * 31) + this.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b.length);
        parcel.writeIntArray(this.b);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
