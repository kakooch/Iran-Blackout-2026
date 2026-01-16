package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vj implements Parcelable {
    public final int b;
    private final vh[] c;
    private int d;
    public static final vj a = new vj(new vh[0]);
    public static final Parcelable.Creator<vj> CREATOR = new vi();

    vj(Parcel parcel) {
        int i = parcel.readInt();
        this.b = i;
        this.c = new vh[i];
        for (int i2 = 0; i2 < this.b; i2++) {
            this.c[i2] = (vh) parcel.readParcelable(vh.class.getClassLoader());
        }
    }

    public final vh a(int i) {
        return this.c[i];
    }

    public final int b(vh vhVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] == vhVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vj.class == obj.getClass()) {
            vj vjVar = (vj) obj;
            if (this.b == vjVar.b && Arrays.equals(this.c, vjVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.c);
        this.d = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        for (int i2 = 0; i2 < this.b; i2++) {
            parcel.writeParcelable(this.c[i2], 0);
        }
    }

    public vj(vh... vhVarArr) {
        this.c = vhVarArr;
        this.b = vhVarArr.length;
    }
}
