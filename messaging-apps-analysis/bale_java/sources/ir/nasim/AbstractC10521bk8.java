package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.bk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10521bk8 implements IInterface {
    private final IBinder a;
    private final String h;

    protected AbstractC10521bk8(IBinder iBinder, String str) {
        this.a = iBinder;
        this.h = str;
    }

    protected final Parcel B2() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.h);
        return parcelObtain;
    }

    protected final Parcel C2(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.a.transact(i, parcel, parcelObtain, 0);
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

    protected final void D2(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
