package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class abe implements Parcelable {
    public static final Parcelable.Creator<abe> CREATOR;
    public static final abe z;
    public final arn<String> A;
    public final arn<String> B;
    public final int C;
    public final boolean D;
    public final int E;

    static {
        abd abdVar = new abd();
        z = new abe(abdVar.a, abdVar.b, abdVar.c);
        CREATOR = new abc();
    }

    abe(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.A = arn.l(arrayList);
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.B = arn.l(arrayList2);
        this.C = parcel.readInt();
        this.D = aeu.s(parcel);
        this.E = parcel.readInt();
    }

    abe(arn<String> arnVar, arn<String> arnVar2, int i) {
        this.A = arnVar;
        this.B = arnVar2;
        this.C = i;
        this.D = false;
        this.E = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            abe abeVar = (abe) obj;
            if (this.A.equals(abeVar.A) && this.B.equals(abeVar.B) && this.C == abeVar.C && this.D == abeVar.D && this.E == abeVar.E) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.A.hashCode() + 31) * 31) + this.B.hashCode()) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + this.E;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.A);
        parcel.writeList(this.B);
        parcel.writeInt(this.C);
        aeu.t(parcel, this.D);
        parcel.writeInt(this.E);
    }
}
