package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public abstract class Mv8 extends AbstractBinderC10511bj8 implements InterfaceC14306hh8 {
    public Mv8() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static InterfaceC14306hh8 C2(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof InterfaceC14306hh8 ? (InterfaceC14306hh8) iInterfaceQueryLocalInterface : new Gv8(iBinder);
    }

    @Override // ir.nasim.AbstractBinderC10511bj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            XZ2 xz2D = d();
            parcel2.writeNoException();
            Ek8.d(parcel2, xz2D);
        } else {
            if (i != 2) {
                return false;
            }
            int iE = e();
            parcel2.writeNoException();
            parcel2.writeInt(iE);
        }
        return true;
    }
}
