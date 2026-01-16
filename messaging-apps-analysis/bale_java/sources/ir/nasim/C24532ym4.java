package ir.nasim;

import ir.nasim.InterfaceC7584Si4;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.ym4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24532ym4 {
    private static final C24532ym4 b = new C24532ym4();
    private static final b c = new b();
    private final AtomicReference a = new AtomicReference();

    /* renamed from: ir.nasim.ym4$b */
    private static class b implements InterfaceC7584Si4 {
        private b() {
        }

        @Override // ir.nasim.InterfaceC7584Si4
        public InterfaceC7584Si4.a a(C9066Yi4 c9066Yi4, String str, String str2) {
            return AbstractC14322hj4.a;
        }
    }

    public static C24532ym4 b() {
        return b;
    }

    public InterfaceC7584Si4 a() {
        InterfaceC7584Si4 interfaceC7584Si4 = (InterfaceC7584Si4) this.a.get();
        return interfaceC7584Si4 == null ? c : interfaceC7584Si4;
    }
}
