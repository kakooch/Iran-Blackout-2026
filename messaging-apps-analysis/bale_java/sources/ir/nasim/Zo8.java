package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Zo8 extends AbstractBinderC12508ej8 implements Xp8 {
    public static Xp8 C2(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        return iInterfaceQueryLocalInterface instanceof Xp8 ? (Xp8) iInterfaceQueryLocalInterface : new C19713qo8(iBinder);
    }
}
