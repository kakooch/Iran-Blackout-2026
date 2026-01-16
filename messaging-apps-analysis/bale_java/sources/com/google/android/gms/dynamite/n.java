package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.Ek8;
import ir.nasim.Gg8;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class n extends Gg8 implements IInterface {
    n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final XZ2 D2(XZ2 xz2, String str, int i, XZ2 xz22) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(i);
        Ek8.d(parcelC2, xz22);
        Parcel parcelB2 = B2(2, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    public final XZ2 E2(XZ2 xz2, String str, int i, XZ2 xz22) {
        Parcel parcelC2 = C2();
        Ek8.d(parcelC2, xz2);
        parcelC2.writeString(str);
        parcelC2.writeInt(i);
        Ek8.d(parcelC2, xz22);
        Parcel parcelB2 = B2(3, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }
}
