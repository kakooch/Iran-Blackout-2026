package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class qz implements Parcelable {
    public static final Parcelable.Creator<qz> CREATOR = new qx();
    private final qy[] a;

    qz(Parcel parcel) {
        this.a = new qy[parcel.readInt()];
        int i = 0;
        while (true) {
            qy[] qyVarArr = this.a;
            if (i >= qyVarArr.length) {
                return;
            }
            qyVarArr[i] = (qy) parcel.readParcelable(qy.class.getClassLoader());
            i++;
        }
    }

    public qz(qy... qyVarArr) {
        this.a = qyVarArr;
    }

    public final int a() {
        return this.a.length;
    }

    public final qy b(int i) {
        return this.a[i];
    }

    public final qz c(qz qzVar) {
        return qzVar == null ? this : d(qzVar.a);
    }

    public final qz d(qy... qyVarArr) {
        return qyVarArr.length == 0 ? this : new qz((qy[]) aeu.j(this.a, qyVarArr));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qz.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((qz) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        String strValueOf = String.valueOf(Arrays.toString(this.a));
        return strValueOf.length() != 0 ? "entries=".concat(strValueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (qy qyVar : this.a) {
            parcel.writeParcelable(qyVar, 0);
        }
    }

    public qz(List<? extends qy> list) {
        this.a = (qy[]) list.toArray(new qy[0]);
    }
}
