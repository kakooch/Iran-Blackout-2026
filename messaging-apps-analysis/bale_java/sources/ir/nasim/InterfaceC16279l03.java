package ir.nasim;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: ir.nasim.l03, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC16279l03 extends IInterface {
    public static final String f = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* renamed from: ir.nasim.l03$a */
    public static abstract class a extends Binder implements InterfaceC16279l03 {

        /* renamed from: ir.nasim.l03$a$a, reason: collision with other inner class name */
        private static class C1365a implements InterfaceC16279l03 {
            private IBinder a;

            C1365a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static InterfaceC16279l03 B2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC16279l03.f);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC16279l03)) ? new C1365a(iBinder) : (InterfaceC16279l03) iInterfaceQueryLocalInterface;
        }
    }
}
