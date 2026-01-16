package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.NZ2;
import ir.nasim.OZ2;

/* loaded from: classes3.dex */
final class n implements OZ2 {
    private final IBinder a;

    n(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // ir.nasim.OZ2
    public final void X(NZ2 nz2, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(nz2 != null ? nz2.asBinder() : null);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                v.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
