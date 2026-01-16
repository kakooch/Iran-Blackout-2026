package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: ir.nasim.kk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC16127kk8 extends AbstractBinderC12508ej8 implements InterfaceC18491ok8 {
    public AbstractBinderC16127kk8() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // ir.nasim.AbstractBinderC12508ej8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        InterfaceC12079e03 c23336wk8;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            c23336wk8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            c23336wk8 = iInterfaceQueryLocalInterface instanceof InterfaceC12079e03 ? (InterfaceC12079e03) iInterfaceQueryLocalInterface : new C23336wk8(strongBinder);
        }
        Hk8.b(parcel);
        H1(c23336wk8);
        parcel2.writeNoException();
        return true;
    }
}
