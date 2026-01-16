package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vh implements Parcelable {
    public static final Parcelable.Creator<vh> CREATOR = new vg();
    public final int a;
    private final cy[] b;
    private int c;

    vh(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i;
        this.b = new cy[i];
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2] = (cy) parcel.readParcelable(cy.class.getClassLoader());
        }
    }

    public final cy a(int i) {
        return this.b[i];
    }

    public final int b(cy cyVar) {
        int i = 0;
        while (true) {
            cy[] cyVarArr = this.b;
            if (i >= cyVarArr.length) {
                return -1;
            }
            if (cyVar == cyVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vh.class == obj.getClass()) {
            vh vhVar = (vh) obj;
            if (this.a == vhVar.a && Arrays.equals(this.b, vhVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b) + 527;
        this.c = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        for (int i2 = 0; i2 < this.a; i2++) {
            parcel.writeParcelable(this.b[i2], 0);
        }
    }

    public vh(cy... cyVarArr) {
        int length = cyVarArr.length;
        ary.q(length > 0);
        this.b = cyVarArr;
        this.a = length;
    }
}
