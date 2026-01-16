package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.am8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9921am8 implements IInterface {
    private final IBinder a;
    private final String h;

    protected AbstractC9921am8(IBinder iBinder, String str) {
        this.a = iBinder;
        this.h = str;
    }

    protected final Parcel B2() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.h);
        return parcelObtain;
    }

    protected final void C2(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.a.transact(2, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
