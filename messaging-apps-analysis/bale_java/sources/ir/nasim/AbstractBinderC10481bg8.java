package ir.nasim;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.bg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC10481bg8 extends Binder implements IInterface {
    protected AbstractBinderC10481bg8(String str) {
        attachInterface(this, str);
    }

    protected abstract boolean B2(int i, Parcel parcel, Parcel parcel2, int i2);

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return B2(i, parcel, parcel2, i2);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
