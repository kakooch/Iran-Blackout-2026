package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sf extends sb {
    public static final Parcelable.Creator<sf> CREATOR = new se();
    public final int a;
    public final int b;
    public final int c;
    public final int[] d;
    public final int[] e;

    public sf(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.sb, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && sf.class == obj.getClass()) {
            sf sfVar = (sf) obj;
            if (this.a == sfVar.a && this.b == sfVar.b && this.c == sfVar.c && Arrays.equals(this.d, sfVar.d) && Arrays.equals(this.e, sfVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
    }

    sf(Parcel parcel) {
        super("MLLT");
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = (int[]) aeu.f(parcel.createIntArray());
        this.e = (int[]) aeu.f(parcel.createIntArray());
    }
}
