package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.cd8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11041cd8 implements IInterface {
    private final IBinder a;
    private final String h = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected AbstractC11041cd8(IBinder iBinder) {
        this.a = iBinder;
    }

    protected final Parcel B2() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.h);
        return parcelObtain;
    }

    protected final Parcel C2(Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.a.transact(1, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
