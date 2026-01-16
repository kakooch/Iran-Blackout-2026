package ir.nasim;

import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import ir.nasim.C17448mz0;

/* renamed from: ir.nasim.tW3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21352tW3 {
    public static final C21352tW3 a = new C21352tW3();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rW3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C21352tW3.c();
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.sW3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C21352tW3.g();
        }
    });
    public static final int d = 8;

    private C21352tW3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5110Hy0 c() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).p0();
    }

    public static final boolean d(int i) {
        if (((C17448mz0) C18039nz0.a.d().getValue()).e() != C17448mz0.a.e) {
            return false;
        }
        if (i != 24 && i != 25) {
            return false;
        }
        a.e().e();
        return true;
    }

    private final InterfaceC5110Hy0 e() {
        return (InterfaceC5110Hy0) b.getValue();
    }

    private final C14176hU2 f() {
        return (C14176hU2) c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14176hU2 g() {
        return ((InterfaceC12620ev0) C92.a(C5721Ko.a.d(), InterfaceC12620ev0.class)).H();
    }

    public static final boolean h(Intent intent) {
        AbstractC13042fc3.i(intent, "mediaButtonIntent");
        KeyEvent keyEvent = Build.VERSION.SDK_INT >= 33 ? (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT", KeyEvent.class) : (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return false;
        }
        C17448mz0.a aVarE = ((C17448mz0) C18039nz0.a.d().getValue()).e();
        if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 79 && keyEvent.getKeyCode() != 85 && keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126)) {
            return false;
        }
        if (aVarE == C17448mz0.a.e) {
            InterfaceC5110Hy0.c(a.e(), true, 0L, 2, null);
        } else if (aVarE != C17448mz0.a.o && aVarE != C17448mz0.a.n && aVarE != C17448mz0.a.d && aVarE != C17448mz0.a.m && aVarE != C17448mz0.a.k && aVarE != C17448mz0.a.l && aVarE != C17448mz0.a.j) {
            C14176hU2.b(a.f(), false, 1, null);
        }
        return true;
    }
}
