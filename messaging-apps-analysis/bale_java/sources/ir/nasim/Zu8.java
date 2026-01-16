package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Zu8 extends AbstractBinderC11896dj8 implements InterfaceC15055iv8 {
    public static InterfaceC15055iv8 C2(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof InterfaceC15055iv8 ? (InterfaceC15055iv8) iInterfaceQueryLocalInterface : new Lu8(iBinder);
    }
}
