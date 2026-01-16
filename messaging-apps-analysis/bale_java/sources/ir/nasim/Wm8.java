package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Wm8 extends AbstractBinderC25100zj8 implements InterfaceC22180un8 {
    public static InterfaceC22180un8 B2(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC22180un8 ? (InterfaceC22180un8) iInterfaceQueryLocalInterface : new Wl8(iBinder);
    }
}
