package ir.nasim;

import android.view.KeyEvent;
import androidx.compose.ui.focus.FocusTargetNode;

/* renamed from: ir.nasim.Fr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC4566Fr2 extends InterfaceC3630Br2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ir.nasim.Fr2$a */
    public static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    static /* synthetic */ boolean u(InterfaceC4566Fr2 interfaceC4566Fr2, KeyEvent keyEvent, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        }
        if ((i & 2) != 0) {
            sa2 = a.e;
        }
        return interfaceC4566Fr2.i(keyEvent, sa2);
    }

    void a(InterfaceC20937sr2 interfaceC20937sr2);

    C3587Bm4 b();

    boolean c(F46 f46, SA2 sa2);

    boolean d(androidx.compose.ui.focus.d dVar, CK5 ck5);

    C6468Nr2 e();

    boolean g(KeyEvent keyEvent);

    FocusTargetNode h();

    boolean i(KeyEvent keyEvent, SA2 sa2);

    void j(FocusTargetNode focusTargetNode);

    void k();

    androidx.compose.ui.e l();

    boolean n();

    boolean o(boolean z, boolean z2, boolean z3, int i);

    Boolean p(int i, CK5 ck5, UA2 ua2);

    InterfaceC5517Jr2 q();

    CK5 r();

    void s(FocusTargetNode focusTargetNode);

    void t();

    void w(InterfaceC4815Gr2 interfaceC4815Gr2);
}
