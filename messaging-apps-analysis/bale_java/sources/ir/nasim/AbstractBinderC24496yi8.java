package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.yi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC24496yi8 extends AbstractBinderC12508ej8 implements Bi8 {
    public AbstractBinderC24496yi8() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // ir.nasim.AbstractBinderC12508ej8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        PZ2 c11945do8;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            c11945do8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            c11945do8 = iInterfaceQueryLocalInterface instanceof PZ2 ? (PZ2) iInterfaceQueryLocalInterface : new C11945do8(strongBinder);
        }
        Hk8.b(parcel);
        m2(c11945do8);
        parcel2.writeNoException();
        return true;
    }
}
