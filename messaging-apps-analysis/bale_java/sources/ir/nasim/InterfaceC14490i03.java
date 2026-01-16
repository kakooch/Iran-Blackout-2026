package ir.nasim;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: ir.nasim.i03, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC14490i03 extends IInterface {

    /* renamed from: ir.nasim.i03$a */
    public static abstract class a extends Binder implements InterfaceC14490i03 {

        /* renamed from: ir.nasim.i03$a$a, reason: collision with other inner class name */
        private static class C1287a implements InterfaceC14490i03 {
            private IBinder a;

            C1287a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static InterfaceC14490i03 B2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC14490i03)) ? new C1287a(iBinder) : (InterfaceC14490i03) iInterfaceQueryLocalInterface;
        }
    }
}
