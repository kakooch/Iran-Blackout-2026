package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: ir.nasim.jk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC15536jk8 extends AbstractBinderC11906dk8 implements InterfaceC17309mk8 {
    public static InterfaceC17309mk8 C2(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC17309mk8 ? (InterfaceC17309mk8) iInterfaceQueryLocalInterface : new C14338hk8(iBinder);
    }
}
