package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ro extends sb {
    public static final Parcelable.Creator<ro> CREATOR = new rn();
    public final byte[] a;

    /* JADX WARN: Illegal instructions before constructor call */
    ro(Parcel parcel) {
        String string = parcel.readString();
        int i = aeu.a;
        super(string);
        this.a = (byte[]) aeu.f(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ro.class == obj.getClass()) {
            ro roVar = (ro) obj;
            if (this.f.equals(roVar.f) && Arrays.equals(this.a, roVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f.hashCode() + 527) * 31) + Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByteArray(this.a);
    }

    public ro(String str, byte[] bArr) {
        super(str);
        this.a = bArr;
    }
}
