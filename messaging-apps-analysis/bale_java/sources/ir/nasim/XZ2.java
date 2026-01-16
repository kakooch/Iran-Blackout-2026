package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public interface XZ2 extends IInterface {

    public static abstract class a extends AbstractBinderC10511bj8 implements XZ2 {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static XZ2 C2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof XZ2 ? (XZ2) iInterfaceQueryLocalInterface : new C22730vj8(iBinder);
        }
    }
}
