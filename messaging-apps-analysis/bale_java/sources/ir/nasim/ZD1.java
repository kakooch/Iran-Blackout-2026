package ir.nasim;

import android.view.View;
import ir.nasim.AbstractC16558lU2;

/* loaded from: classes2.dex */
public final class ZD1 implements InterfaceC15967kU2 {
    private final View a;

    public ZD1(View view) {
        this.a = view;
    }

    @Override // ir.nasim.InterfaceC15967kU2
    public void a(int i) {
        AbstractC16558lU2.a aVar = AbstractC16558lU2.a;
        if (AbstractC16558lU2.b(i, aVar.a())) {
            this.a.performHapticFeedback(16);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.b())) {
            this.a.performHapticFeedback(6);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.c())) {
            this.a.performHapticFeedback(13);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.d())) {
            this.a.performHapticFeedback(23);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.e())) {
            this.a.performHapticFeedback(0);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.f())) {
            this.a.performHapticFeedback(17);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.g())) {
            this.a.performHapticFeedback(27);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.h())) {
            this.a.performHapticFeedback(26);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.i())) {
            this.a.performHapticFeedback(9);
            return;
        }
        if (AbstractC16558lU2.b(i, aVar.j())) {
            this.a.performHapticFeedback(22);
        } else if (AbstractC16558lU2.b(i, aVar.k())) {
            this.a.performHapticFeedback(21);
        } else if (AbstractC16558lU2.b(i, aVar.l())) {
            this.a.performHapticFeedback(1);
        }
    }
}
