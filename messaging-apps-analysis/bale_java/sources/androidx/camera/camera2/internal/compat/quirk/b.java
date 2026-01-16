package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.t;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.C5826Kz5;
import ir.nasim.C6293Mz5;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceC5592Jz5;
import ir.nasim.PI3;

/* loaded from: classes.dex */
public abstract class b {
    private static volatile C6293Mz5 a;

    static {
        C5826Kz5.b().c(AbstractC20567sE0.a(), new InterfaceC25043ze1() { // from class: ir.nasim.vK1
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                androidx.camera.camera2.internal.compat.quirk.b.d((androidx.camera.core.impl.t) obj);
            }
        });
    }

    public static InterfaceC5592Jz5 b(Class cls) {
        return a.b(cls);
    }

    public static C6293Mz5 c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(t tVar) {
        a = new C6293Mz5(c.a(tVar));
        PI3.a("DeviceQuirks", "camera2 DeviceQuirks = " + C6293Mz5.d(a));
    }
}
