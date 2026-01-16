package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.Ek8;
import ir.nasim.Gg8;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class m extends Gg8 implements IInterface {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int D2() {
        Parcel parcelB2 = B2(6, C2());
        int i = parcelB2.readInt();
        parcelB2.recycle();
        return i;
    }

    public final int E2(XZ2 xz2, String str, boolean z) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(z ? 1 : 0);
        Parcel parcelB2 = B2(3, parcelC2);
        int i = parcelB2.readInt();
        parcelB2.recycle();
        return i;
    }

    public final int F2(XZ2 xz2, String str, boolean z) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(z ? 1 : 0);
        Parcel parcelB2 = B2(5, parcelC2);
        int i = parcelB2.readInt();
        parcelB2.recycle();
        return i;
    }

    public final XZ2 G2(XZ2 xz2, String str, int i) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(i);
        Parcel parcelB2 = B2(2, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    public final XZ2 H2(XZ2 xz2, String str, int i, XZ2 xz22) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(i);
        Ek8.d(parcelC2, xz22);
        Parcel parcelB2 = B2(8, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    public final XZ2 I2(XZ2 xz2, String str, int i) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(i);
        Parcel parcelB2 = B2(4, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    public final XZ2 J2(XZ2 xz2, String str, boolean z, long j) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(z ? 1 : 0);
        parcelC2.writeLong(j);
        Parcel parcelB2 = B2(7, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }
}
