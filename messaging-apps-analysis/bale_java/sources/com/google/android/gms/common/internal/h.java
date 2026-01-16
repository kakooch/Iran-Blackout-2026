package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.AbstractC11061cf8;
import ir.nasim.Le8;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class h extends Le8 implements IInterface {
    h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final XZ2 F2(XZ2 xz2, zax zaxVar) {
        Parcel parcelB2 = B2();
        AbstractC11061cf8.d(parcelB2, xz2);
        AbstractC11061cf8.c(parcelB2, zaxVar);
        Parcel parcelC2 = C2(2, parcelB2);
        XZ2 xz2C2 = XZ2.a.C2(parcelC2.readStrongBinder());
        parcelC2.recycle();
        return xz2C2;
    }
}
