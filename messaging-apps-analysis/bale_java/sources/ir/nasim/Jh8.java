package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Jh8 extends AbstractBinderC10511bj8 implements Mh8 {
    public static Mh8 C2(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return iInterfaceQueryLocalInterface instanceof Mh8 ? (Mh8) iInterfaceQueryLocalInterface : new Fh8(iBinder);
    }
}
